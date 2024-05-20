package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FlowerOrderTest {

    private Class<?> flowerOrderClass;
    private Object flowerOrderInstance;

    @Before
    public void setUp() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        try {
            flowerOrderClass = Class.forName("com.techelevator.FlowerOrder");
            flowerOrderInstance = flowerOrderClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            Assert.fail("Default constructor not found. Ensure the default constructor exists and is public.");
        }
    }

    @Test
    public void testConstructorWithoutArguments() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Verify the presence and correctness of the default constructor
        Constructor constructor = flowerOrderClass.getDeclaredConstructor();
        flowerOrderInstance = constructor.newInstance();

        // Verify the initial values after invoking the default constructor
        Assert.assertEquals("small", invokeGetter("getSize"));
        Assert.assertEquals(0, invokeGetter("getNumRoses"));
        Assert.assertFalse((Boolean) invokeGetter("isIncludeVase"));
    }

    @Test
    public void testConstructorWithArguments() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Verify the presence and correctness of the constructor with arguments
        Constructor constructor = null;
        try {
            constructor = flowerOrderClass.getDeclaredConstructor(String.class, int.class, boolean.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Three-parameter constructor not found. Ensure the constructor exists, the parameter types are correct, the parameters are in the correct order per the README, and the constructor is public.");
        }
        flowerOrderInstance = constructor.newInstance("medium", 5, true);

        // Verify the values after invoking the constructor
        Assert.assertEquals("medium", invokeGetter("getSize"));
        Assert.assertEquals(5, invokeGetter("getNumRoses"));
        Assert.assertTrue((Boolean) invokeGetter("isIncludeVase"));
    }

    @Test
    public void testSettersAndGetters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Ensure all getters and setters exist with correct signatures
        assertMethodExists("getSize");
        assertMethodExists("setSize", String.class);
        assertMethodExists("getNumRoses");
        assertMethodExists("setNumRoses", int.class);
        assertMethodExists("isIncludeVase");
        assertMethodExists("setIncludeVase", boolean.class);

        invokeSetter("setSize", "large");
        invokeSetter("setNumRoses", 10);
        invokeSetter("setIncludeVase", true);

        Assert.assertEquals("large", invokeGetter("getSize"));
        Assert.assertEquals(10, invokeGetter("getNumRoses"));
        Assert.assertTrue((Boolean) invokeGetter("isIncludeVase"));
    }

    @Test
    public void testGetPreTaxPrice() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Verify the existence correctness of the getPreTaxPrice() method
        assertMethodExists("getPreTaxPrice");

        invokeSetter("setSize", "small");
        invokeSetter("setNumRoses", 3);
        invokeSetter("setIncludeVase", true);

        double expectedPrice = 19.5;
        Assert.assertEquals("getPreTaxPrice() should return 19.5 for a small, 3 rose order that includes a vase", expectedPrice, (Double)invokeMethod("getPreTaxPrice"), 0.001);

        invokeSetter("setSize", "large");
        invokeSetter("setNumRoses", 0);
        invokeSetter("setIncludeVase", false);

        expectedPrice = 20.0;
        Assert.assertEquals("getPreTaxPrice() should return 20.0 for a large order with no roses and no vase", expectedPrice, (Double)invokeMethod("getPreTaxPrice"), 0.001);

        invokeSetter("setSize", "medium");
        invokeSetter("setNumRoses", 1);
        invokeSetter("setIncludeVase", false);

        expectedPrice = 16.5;
        Assert.assertEquals("getPreTaxPrice() should return 16.5 for a medium order with 1 rose and no vase", expectedPrice, (Double)invokeMethod("getPreTaxPrice"), 0.001);

    }

    @Test
    public void testGetTax() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Verify the existence and correctness of the getTax() method
        assertMethodExists("getTax");

        invokeSetter("setSize", "small");
        invokeSetter("setNumRoses", 3);
        invokeSetter("setIncludeVase", true);

        double expectedTax = 19.5 * 0.05;
        Assert.assertEquals("getTax() should return " + expectedTax + " for a small, 3 rose order that includes a vase", expectedTax, (Double)invokeMethod("getTax"), 0.001);

        invokeSetter("setSize", "large");
        invokeSetter("setNumRoses", 0);
        invokeSetter("setIncludeVase", false);

        expectedTax = 20.0 * 0.05;
        Assert.assertEquals("getTax() should return " + expectedTax + " for a large order with no roses and no vase", expectedTax, (Double)invokeMethod("getTax"), 0.001);

        invokeSetter("setSize", "medium");
        invokeSetter("setNumRoses", 1);
        invokeSetter("setIncludeVase", false);

        expectedTax = 16.5 * 0.05;
        Assert.assertEquals("getTax() should return " + expectedTax + " for a medium order with 1 rose and no vase", expectedTax, (Double)invokeMethod("getTax"), 0.001);
    }

    @Test
    public void testGetTotalPrice() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // Verify the existence and correctness of the getTotalPrice() method
        assertMethodExists("getTotalPrice");

        invokeSetter("setSize", "small");
        invokeSetter("setNumRoses", 3);
        invokeSetter("setIncludeVase", true);

        double expectedTotal = 19.5 + 19.5 * 0.05;
        Assert.assertEquals("getTotalPrice() should return " + expectedTotal + " for a small, 3 rose order that includes a vase", expectedTotal, (Double)invokeMethod("getTotalPrice"), 0.001);

        invokeSetter("setSize", "large");
        invokeSetter("setNumRoses", 0);
        invokeSetter("setIncludeVase", false);

        expectedTotal = 20.0 + 20.0 * 0.05;
        Assert.assertEquals("getTotalPrice() should return " + expectedTotal + " for a large order with no roses and no vase", expectedTotal, (Double)invokeMethod("getTotalPrice"), 0.001);

        invokeSetter("setSize", "medium");
        invokeSetter("setNumRoses", 1);
        invokeSetter("setIncludeVase", false);

        expectedTotal = 16.5 + 16.5 * 0.05;
        Assert.assertEquals("getTotalPrice() should return " + expectedTotal + " for a medium order with 1 rose and no vase", expectedTotal, (Double)invokeMethod("getTotalPrice"), 0.001);
    }

    @Test
    public void testToString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // Verify the existence and correctness of the toString() method
        assertMethodExists("toString");

        invokeSetter("setSize", "small");
        invokeSetter("setNumRoses", 3);
        invokeSetter("setIncludeVase", true);

        String expectedString = "Size: small, Num Roses: 3, Include Vase: true, Pre-Tax Price: 19.5";
        Assert.assertEquals("toString() returned incorrect value", expectedString, invokeMethod("toString"));

        invokeSetter("setSize", "large");
        invokeSetter("setNumRoses", 0);
        invokeSetter("setIncludeVase", false);

        expectedString = "Size: large, Num Roses: 0, Include Vase: false, Pre-Tax Price: 20.0";
        Assert.assertEquals("toString() returned incorrect value", expectedString, invokeMethod("toString"));

        invokeSetter("setSize", "medium");
        invokeSetter("setNumRoses", 1);
        invokeSetter("setIncludeVase", false);

        expectedString = "Size: medium, Num Roses: 1, Include Vase: false, Pre-Tax Price: 16.5";
        Assert.assertEquals("toString() returned incorrect value", expectedString, invokeMethod("toString"));

    }

    // Helper methods for invoking methods and getters/setters using reflection

    private Object invokeMethod(String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = flowerOrderClass.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(flowerOrderInstance);
    }

    private Object invokeGetter(String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return invokeMethod(methodName);
    }

    private void invokeSetter(String methodName, Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setterMethod = flowerOrderClass.getDeclaredMethod(methodName, value.getClass());
        setterMethod.setAccessible(true);
        setterMethod.invoke(flowerOrderInstance, value);
    }

    private void invokeSetter(String methodName, int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setterMethod = flowerOrderClass.getDeclaredMethod(methodName, int.class);
        setterMethod.setAccessible(true);
        setterMethod.invoke(flowerOrderInstance, value);
    }

    private void invokeSetter(String methodName, boolean value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setterMethod = flowerOrderClass.getDeclaredMethod(methodName, boolean.class);
        setterMethod.setAccessible(true);
        setterMethod.invoke(flowerOrderInstance, value);
    }

    private Method getMethod(String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        try {
            return flowerOrderClass.getDeclaredMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            String parameterTypesString = "";
            for (Class<?> parameterType : parameterTypes) {
                if (!parameterTypesString.isEmpty()) {
                    parameterTypesString += ", ";
                }
                parameterTypesString += parameterType.getName();
            }
            String errorMessage = String.format("Method '%s(%s)' not found in FlowerOrder class. Ensure the method name and parameter type(s) exactly match the README",
                    methodName, parameterTypesString);
            throw new NoSuchMethodException(errorMessage);
        }
    }

    private void assertMethodExists(String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        try {
            getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            Assert.fail(e.getMessage());
        }
    }
}
