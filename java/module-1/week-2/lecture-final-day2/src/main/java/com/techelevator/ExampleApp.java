package com.techelevator;

public class ExampleApp {

    public static void main(String[] args) {

        String input;

        String text = "Hello World";

        //String is a character array
        for(int i = 0; i < text.length(); i++){
            char selectedChar = text.charAt(i);
            System.out.print(selectedChar);
        }

        System.out.println();
        String textNoSpace = text.replace("World", "Country");
        System.out.println(textNoSpace);

        //String subText = text.substring(6); //World
        String subText = text.substring(0, 5); // Hello
        boolean containsHello = text.contains("Hello"); //true






        System.out.println(subText);
        System.out.println(containsHello);

        double[] scores = new double[5];

        int len = scores.length;
        text.length();


    }

}
