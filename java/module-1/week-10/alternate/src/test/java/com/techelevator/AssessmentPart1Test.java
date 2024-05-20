package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssessmentPart1Test {

	AssessmentPart1 assessmentPart1 = new AssessmentPart1();

	/*
	 */
	@Test
	public void Q01_calculateAverage_test() {
		assertEquals("Q01_calculateAverage(10, 20) should == 15.0", 15.0, assessmentPart1.Q01_calculateAverage(10, 20), 0.001);
		assertEquals("Q01_calculateAverage(4, 5) should == 4.5", 4.5, assessmentPart1.Q01_calculateAverage(4, 5), 0.001);
		assertEquals("Q01_calculateAverage(0, 0) should == 0.0", 0.0, assessmentPart1.Q01_calculateAverage(0, 0), 0.001);
		assertEquals("Q01_calculateAverage(-10, -10) should == -10.0", -10.0, assessmentPart1.Q01_calculateAverage(-10, -10), 0.001);
	}

	@Test
	public void Q02_isSumDivisibleByThree_test() {
		assertTrue("Q1_isSumDivisibleByThree(4, 5) should return true", assessmentPart1.Q02_isSumDivisibleByThree(4, 5));
		assertFalse("Q1_isSumDivisibleByThree(3, 4) should return false", assessmentPart1.Q02_isSumDivisibleByThree(3, 4));
		assertTrue("Q1_isSumDivisibleByThree(0, 0) should return true", assessmentPart1.Q02_isSumDivisibleByThree(0, 0));
		assertFalse("Q1_isSumDivisibleByThree(-4, 2) should return false", assessmentPart1.Q02_isSumDivisibleByThree(-4, 2));
	}

	@Test
	public void Q03_calculateTollRate_test() {
		assertEquals("Q03_calculateTollRate(4) should return 3", 3, assessmentPart1.Q03_calculateTollRate((4)));
		assertEquals("Q03_calculateTollRate(18) should return 5", 5, assessmentPart1.Q03_calculateTollRate((18)));
		assertEquals("Q03_calculateTollRate(2) should return 3", 3, assessmentPart1.Q03_calculateTollRate((2)));
		assertEquals("Q03_calculateTollRate(5) should return 5", 5, assessmentPart1.Q03_calculateTollRate((5)));
	}

	@Test
	public void Q04_calculateTollRate_test() {
		assertEquals("Q04_calculateTollRate(4, true, true) should return 4", 4, assessmentPart1.Q04_calculateTollRate(4, true, true));
		assertEquals("Q04_calculateTollRate(18, true, true) should return 4", 4, assessmentPart1.Q04_calculateTollRate(18, true, true));
		assertEquals("Q04_calculateTollRate(4, false, false) should return 3", 3, assessmentPart1.Q04_calculateTollRate(4, false, false));
		assertEquals("Q04_calculateTollRate(2, true, false) should return 2", 2, assessmentPart1.Q04_calculateTollRate(2, true, false));
	}

	@Test
	public void Q05_sumArrayRange_test() {
		assertEquals("Q05_sumArrayRange([2, 4, 6, 8, 10], 1, 3) should return 18", 18, assessmentPart1.Q05_sumArrayRange(new int[] { 2, 4, 6, 8, 10 }, 1, 3));
		assertEquals("Q05_sumArrayRange([2, 4, 6, 8, 10], 2, 2) should return 6", 6, assessmentPart1.Q05_sumArrayRange(new int[] { 2, 4, 6, 8, 10 }, 2, 2));
		assertEquals("Q05_sumArrayRange([1, 3, 5], 0, 2) should return 9", 9, assessmentPart1.Q05_sumArrayRange(new int[] { 1, 3, 5 }, 0, 2));
	}

	@Test
	public void Q06_removeChar_test() {
		assertEquals("Q06_removeChar(\"Hello\", 'l') should return \"Heo\"", "Heo", assessmentPart1.Q06_removeChar("Hello", 'l'));
		assertEquals("Q06_removeChar(\"Abba\", 'A') should return \"bba\"", "bba", assessmentPart1.Q06_removeChar("Abba", 'A'));
		assertEquals("Q06_removeChar(\"Mississippi\", 's') should return \"Miiippi\"", "Miiippi", assessmentPart1.Q06_removeChar("Mississippi", 's'));
		assertNull("Q06_removeChar(null, 'x') should return null", assessmentPart1.Q06_removeChar(null, 'x'));
	}

	@Test
	public void Q07_makeUpper_test() {
		assertEquals("Q07_makeUpper(\"Hello\") should return \"HELLO\"", "HELLO", assessmentPart1.Q07_makeUpper("Hello"));
		assertEquals("Q07_makeUpper(\"ABC\") should return \"ABC\"", "ABC", assessmentPart1.Q07_makeUpper("ABC"));
		assertEquals("Q07_makeUpper(\"abc\") should return \"ABC\"", "ABC", assessmentPart1.Q07_makeUpper("abc"));
	}

	@Test
	public void Q08_calculateHoursOfWorkRemaining_test() {
		assertEquals("Q08_calculateHoursOfWorkRemaining(4, 2) should return 4", 4, assessmentPart1.Q08_calculateHoursOfWorkRemaining(4,2));
		assertEquals("Q08_calculateHoursOfWorkRemaining(5, 5) should return 0", 0, assessmentPart1.Q08_calculateHoursOfWorkRemaining(5, 5));
		assertEquals("Q08_calculateHoursOfWorkRemaining(3, 0) should return 6", 6, assessmentPart1.Q08_calculateHoursOfWorkRemaining(3, 0));
	}

	@Test
	public void Q09_calculateTotalHours_test() {
		assertEquals("Q09_calculateTotalHours(3) should return 2.0", 2.0, assessmentPart1.Q09_calculateTotalHours(3), 0.001);
		assertEquals("Q09_calculateTotalHours(1) should return 0.666", 0.666, assessmentPart1.Q09_calculateTotalHours(1), 0.001);
		assertEquals("Q09_calculateTotalHours(5) should return 3.333", 3.333, assessmentPart1.Q09_calculateTotalHours(5), 0.001);
	}

	@Test
	public void Q10_tripleArray_test() {
		int[] input = new int[] { 1, 2, 3 };
		int[] inputCopy = new int[] { 1, 2, 3 };
		int[] expected = new int[] { 3, 6, 9 };
		int[] actual = assessmentPart1.Q10_tripleArray(input);

		assertArrayEquals("Q10_tripleArray should not modify the input array", inputCopy, input);
		assertArrayEquals("Q10_tripleArray([1, 2, 3]) should return [3, 6, 9]", expected, actual);

		input = new int[] { 5, 0, -3 };
		inputCopy = new int[] { 5, 0, -3 };
		expected = new int[] { 15, 0, -9 };
		actual = assessmentPart1.Q10_tripleArray(input);

		assertArrayEquals("Q10_tripleArray should not modify the input array", inputCopy, input);
		assertArrayEquals("Q10_tripleArray([5, 0, -3]) should return [15, 0, -9]", expected, actual);

		assertNull("Q10_tripleArray(null) should return null", assessmentPart1.Q10_tripleArray(null));
	}

	@Test
	public void Q11_countFirstLetters_test() {
		List<String> strs = Arrays.asList();
		Map<Character, Integer> expected = new HashMap<>();
		Map<Character, Integer> actual = assessmentPart1.Q11_countFirstLetters(strs);
		assertEquals("Q10_countFirstLetters should return an empty Map for an empty input List", expected, actual);

		strs = Arrays.asList("apple", "banana", "avocado");
		expected = new HashMap<>();
		expected.put('a', 2);
		expected.put('b', 1);
		actual = assessmentPart1.Q11_countFirstLetters(strs);
		assertEquals("Q10_countFirstLetters(\"apple\", \"banana\", \"avocado\") did not return the expected Map", expected, actual);

		strs = Arrays.asList("cat", "dog", "Cancun", "dollar");
		expected = new HashMap<>();
		expected.put('c', 1);
		expected.put('d', 2);
		expected.put('C', 1);
		actual = assessmentPart1.Q11_countFirstLetters(strs);
		assertEquals("Q10_countFirstLetters(\"cat\", \"dog\", \"Cancun\", \"dollar\") did not return the expected Map", expected, actual);

		strs = Arrays.asList("a", "b", "c");
		expected = new HashMap<>();
		expected.put('a', 1);
		expected.put('b', 1);
		expected.put('c', 1);
		actual = assessmentPart1.Q11_countFirstLetters(strs);
		assertEquals("Q10_countFirstLetters(\"a\", \"b\", \"c\") did not return the expected Map", expected, actual);
	}
}
