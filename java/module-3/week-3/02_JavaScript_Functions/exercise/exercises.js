/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa is above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */

    function isAdmitted(gpa, satScore = 0, recommendation = false) {
        if (gpa > 4.0 || satScore > 1300 || (gpa > 3.0 && recommendation) || (satScore > 1200 && recommendation)) {
            return true;
        }
        return false;
    }

/**
 * Write a function called useParameterToFilterArray that accepts a filter function
 * as a parameter. Use this function to filter unfilteredArray and return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
let unfilteredArray = [1, 2, 3, 4, 5, 6];

    function useParameterToFilterArray(filterFunction) {
        return unfilteredArray.filter(filterFunction);
    }

/**
 * Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */

    function makeNumber(first, second = '') {
        return Number(first + second);
    }

/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */

    function addAll(...num) {
        let sum = 0;
        for (let i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum;
    }

/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */
    /**
     * 
     * @param {string[]} words An array of words to prepend 'Happy' to 
     * @returns {string[]} a new array with 'Happy ' prepended to the front
     */
    function makeHappy(words) {
        return words.map(word => 'Happy ' + word);
    }

/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects. Each object contains the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * getFullAddressesOfProperties returns an array of strings. 
 * Each string is a mailing address generated from the data of a single JavaScript object. 
 * 
 * Each mailing address should have the following format:
 *    
 *  streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */
    /**
     * 
     * @param {Object[]} properties an array containing streetNumber, streetName, streetType, city, state, zip 
     * @returns {string[]} an array of mailing address strings formatted as 'streetNumber streetName streetType city state zip'
     */
    function getFullAddressesOfProperties(properties) {
        return properties.map(property => `${property.streetNumber} ${property.streetName} ${property.streetType} ${property.city} ${property.state} ${property.zip}`);
    }

/** 
 * Write and document a function called findLargest that uses `forEach`
 * to find the largest element in an array.
 * The function must work for strings and numbers.
 * 
 * For strings, "largest" means the word coming last in lexographical order.
 * Lexographic is similar to alphabetical order except that 
 * capital letters come before lowercase letters: 
 * 
 * "cat" < "dog" but "Dog" < "cat"
 *
 * @param {number[]|string[]} searchArray the array to search
 * @returns {number|string} the number or string that is largest
 **/

    function findLargest(searchArray) {
        if (searchArray.length === 0) {
            return 'Array is empty';
        }

        let largest = searchArray[0];

        searchArray.forEach(element => {
            if (typeof element === 'string' && typeof largest === 'string') {
                if (element > largest) {
                    largest = element;
                }
            } else if (typeof element === 'number' && typeof largest === 'number') {
                    if (element > largest) {
                        largest = element;
                    }
            } else {
                return 'Array has mixed types';
            }
        });
        return largest
    }


/*
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */

    /**
     * 
     * @param {number[][]} arrayOfArrays array of arrays, containing numbers 
     * @returns {number} the sum of all of the numbers in all of the sub-arrays
     */
    function getSumOfSubArrayValues(arrayOfArrays) {
        return arrayOfArrays.reduce((totalSum, subArray) => totalSum + subArray.reduce((subArraySum, value) => subArraySum + value, 0), 0);
    }