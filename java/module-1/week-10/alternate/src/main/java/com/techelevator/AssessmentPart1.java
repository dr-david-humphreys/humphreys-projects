package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AssessmentPart1 {

    /*
    Topics: Data types

    The purpose of this method is to calculate the average of two integers and return the result
    as a double.

        Q01_calculateAverage(10, 20) -> 15.0
        Q01_calculateAverage(4, 5) -> 4.5
     */
    public double Q01_calculateAverage(int num1, int num2) {
        return 0.0;
    }

    /*
    Topics: Expressions

    The purpose of this method is to determine if the sum of two integers is evenly divisible by 3.
    Sum the values 'a' and 'b'. Then return true if the result is evenly divisible by 3, false if not.

         Q02_isSumDivisibleByThree(4, 5) -> true
         Q02_isSumDivisibleByThree(3, 4) -> false
    */
    public boolean Q02_isSumDivisibleByThree(int a, int b) {
        return false;
    }

    /*
    Topics: Branching

    The purpose of this method is to calculate toll road rates.
    Vehicles with 4 or fewer tires pay $3.
    All other vehicles pay $5.

    Return the appropriate price based on the number of tires.

        Q03_calculateTollRate(4) -> 3
        Q03_calculateTollRate(18) -> 5
        q03_calculateTollRate(2) -> 3
     */
    public int Q03_calculateTollRate(int numTires) {
        return 0;
    }

    /*
    Topics: Branching, Local variables

    The purpose of this method is to calculate toll road rates.

    The base rate for vehicles with 4 or fewer tires is $3.
    The base rate for all other vehicles is $5.

    On weekends, all vehicles receive a $1 discount.

    On holidays, vehicles with 4 or few tires pay an additional $2. Vehicles with more than 4 tires
    don't pay any additional on holidays.

    Return the appropriate price based on the number of tires (numTires), whether it's
    a weekend (isWeekend), and whether it's a holiday (isHoliday).

        Q04_calculateTollRate(4, true, true) -> 4 ($3 base - $1 for weekend + $2 for four tires on a holiday)
        Q04_calculateTollRate(18, true, true) -> 4 ($5 base - $1 for weekend + $0 for more than four tires on a holiday)
        Q04_calculateTollRate(4, false, false) -> 3
        Q04_calculateTollRate(2, true, false) -> 2
     */
    public int Q04_calculateTollRate(int numTires, boolean isWeekend, boolean isHoliday) {
        return 0;
    }

    /*
    Topics: Loops, Arrays

    The purpose of this method is to sum and return the values in the array 'nums' from 'startIndex' (inclusive)
    to 'endIndex' (inclusive).

    'startIndex' is always less than or equal to 'endIndex' and both are always valid indexes in 'nums'

        Q05_sumArrayRange([2, 4, 6, 8, 10], 1, 3) -> 18 (4 + 6 + 8)
        Q05_sumArrayRange([2, 4, 6, 8, 10], 2, 2) -> 6
        Q05_sumArrayRange([1, 3, 5], 0, 2) -> 9 (1 + 3 + 5)
     */
    public int Q05_sumArrayRange(int[] nums, int startIndex, int endIndex) {
        return 0;
    }

    /*
    Topics: Strings

    The purpose of this method is to remove all the characters 'charToRemove' from the String 'str'. Return the
    resulting String.

    If 'str' is null then the method should return null.

        Q06_removeChar("Hello", 'l') -> "Heo"
        Q06_removeChar("Abba", 'A') -> "bba"
        Q06_removeChar("Mississippi", 's') -> "Miiippi"
        Q06_removeChar(null, 'x') -> null

     */
    public String Q06_removeChar(String str, char charToRemove) {
        return null;
    }

    /*
    Topic: Strings

    Fix the bug!

    The purpose of this method is to return an uppercase version of the String 'str'.

    The tests for the method fail. Fix the code in this method so that the tests pass. (Don't
    modify the tests.)

    Run the tests to see what the expected results are and what the method returns.
     */
    public String Q07_makeUpper(String str) {
        str.toUpperCase();
        return str;
    }

    /*
    Topic: Expressions

    Fix the bug!

    A house painter takes 2 hours to paint a room. The purpose of this method is to calculate how many
    hours of work remain based on the total number of rooms to paint and the number completed.

    The tests for this method fail. Fix the code in this method so that the tests pass. (Don't
    modify the tests.)

    Run the tests to see what the expected results are and what the method actually returns.
     */
    public int Q08_calculateHoursOfWorkRemaining(int numRoomsToPaint, int numComplete) {
        return numRoomsToPaint - numComplete * 2;
    }

    /*
    Topic: Expressions, Data types

    Fix the bug!

    A house painter takes 2 hours to stain 3 cabinets. The purpose of this method is to calculate how
    many hours it will take to stain a given number of cabinets.

    The tests for this method fail. Fix the code in this method so that the tests pass. (Don't
    modify the tests.)

    Run the tests to see what the expected results are and what the method actually returns.
     */
    public double Q09_calculateTotalHours(int numCabinetsToStain) {
        return numCabinetsToStain * 2 / 3;
    }

    /*
    Topic: Arrays, Loops

    The purpose of this method is to accept an array of integers ('nums') and return a new array of the same size. The
    elements of the new array are triple the value of the corresponding elements in 'nums'.

    The code must not modify 'nums'.

    If 'nums' is null then null is returned.

        Q10_tripleArray([1, 2, 3]) -> [3, 6, 9]
        Q10_tripleArray([5, 0, -3]) -> [15, 0, -9]
        Q10_tripleArray(null) -> null
     */
    public int[] Q10_tripleArray(int[] nums) {
        return null;
    }

    /*
    Topics: Collections, Arrays, Loops, Strings

    The purpose of this method is to accept a List of Strings and return a Map. The keys in the Map are the
    first letter of the Strings and the values are the number of words that start with that letter. (Case is
    significant).

    'strs' is never null, but may be empty. The Strings in 'strs' are never null or empty.

        Q11_countFirstLetters(["apple", "banana", "avocado"]) -> { 'a' : 2, 'b' : 1 }
        Q11_countFirstLetters(["cat", "dog", "Cancun", "dollar"]) -> { 'c' : 1, 'd' : 2, 'C' : 1 }

    NOTE: Since the Map is an unordered collection, the order in which the entries are added or displayed is not
    important to the result.

     */
    public Map<Character, Integer> Q11_countFirstLetters(List<String> strs) {
        return null;
    }
}
