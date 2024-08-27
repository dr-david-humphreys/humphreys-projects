/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
 function variables() {
    // Declares a variable where the value cannot be changed
    const daysPerWeek = 7;
    console.log(`There are ${daysPerWeek} days in the week.`);
  
    // Declares a variable whose value can be changed
    let daysPerMonth = 31;
    console.log(`There are ${daysPerMonth} days in the month.`);
  
    // Declares a variable that will always be an array
    const weekdays = [
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
      "Saturday",
      "Sunday"
    ];
    console.table(weekdays);
  }


  function arrayAddRemoveElements(){
    //Arrays
    //The push() method adds one or more elements to the end of an array and returns the new length of the array.
    // Initialize an array of planets
    let planets = ['Mercury', 'Venus', 'Earth'];
    console.log('Original planets:', planets);

    // Adding a single element to the array
    planets.push('Mars');
    console.log('After push (single element):', planets);

    // Adding multiple elements to the array
    planets.push('Jupiter', 'Saturn');
    console.log('After push (multiple elements):', planets);


    // The pop() method removes the last element from an array and returns that element. This method changes the length of the array.
    // Continue with the current array
    console.log('Initial array:', planets);

    // Removing the last element from the array
    let removedPlanet = planets.pop();
    console.log('After pop:', planets);
    console.log('Removed planet:', removedPlanet);


    // The shift() method removes the first element from the array. In our planetary example, let's remove the first planet from the list.
    // Removing the first planet from the array
    removedPlanet = planets.shift();
    console.log('After shift (removing first planet):', planets);
    console.log('Removed planet:', removedPlanet);


    //The unshift() method adds one or more elements to the beginning of the array. We'll add a couple of planets to the beginning of our planets array.
    // Continue with the current array of planets
    console.log('Initial array:', planets);

    // Adding a single planet to the beginning of the array
    planets.unshift('Neptune');
    console.log('After unshift (adding one planet):', planets);

    // Adding multiple planets to the beginning of the array
    planets.unshift('Galileo', 'Ceres');
    console.log('After unshift (adding multiple planets):', planets);



  }

  
  /**
   * Functions can also accept parameters.
   * Notice the parameters do not have types. 
   * Note: The types shown in these docs is informational only and not enforced. 
   * @param {Number} param1 The first number to display
   * @param {Number} param2 The second number to display
   */
  function printParameters(param1, param2) {
    console.log(`The value of param1 is ${param1} and its type is ${typeof param1}`);
    console.log(`The value of param2 is ${param2} and its type is ${typeof param2}`);
  }
  
  /**
   * Compares two values x and y.
   * == is loose equality
   * === is strict equality
   * @param {Object} x
   * @param {Object} y
   */
  function equality(x, y) {
    console.log(`x is ${typeof x}`);
    console.log(`y is ${typeof y}`);
  
    console.log(`x == y : ${x == y}`); // true
    console.log(`x === y : ${x === y}`); // false
  }
  
  /**
   * Each value is inherently truthy or falsy.
   * false, 0, '', null, undefined, and NaN are always falsy
   * everything else is always truthy
   * @param {Object} x The object to check for truthy or falsy,
   */
  function falsy(x) {
    if (x) {
      console.log(`${x} is truthy`);
    } else {
      console.log(`${x} is falsy`);
    }
  }
  
  /**
   *  Objects are simple key-value pairs
      - values can be primitive data types
      - values can be arrays
      - or they can be functions
  */
  function objects() {
    const person = {
      firstName: "Bill",
      lastName: "Lumbergh",
      age: 42,
      employees: [
        "Peter Gibbons",
        "Milton Waddams",
        "Samir Nagheenanajar",
        "Michael Bolton"
      ],
      toString: function() {
        return `${this.lastName}, ${this.firstName} (${this.age})`;
      }
    };
  
    console.table(person);
  
    console.log(`${person.firstName} ${person.lastName}`);
  
    for (let i = 0; i < person.employees.length; i++) {
      console.log(`Employee ${i + 1} is ${person.employees[i]}`);
    }
  
    console.log(person.toString());
  }
  
  /*
  ########################
  Function Overloading
  ########################
  
  Function Overloading is not available in Javascript. If you declare a
  function with the same name, more than one time in a script file, the
  earlier ones are overriden and the most recent one will be used.
  */
  
  function add(num1, num2) {
    return num1 + num2;
  }
  
  function add(num1, num2, num3) {
    return num1 + num2 + num3;
  }
  
  /*
  ########################
  Math Library
  ########################
  
  A built-in `Math` object has properties and methods for mathematical constants and functions.
  */
  
  function mathFunctions() {
    console.log("Math.PI : " + Math.PI);
    console.log("Math.LOG10E : " + Math.LOG10E);
    console.log("Math.abs(-10) : " + Math.abs(-10));
    console.log("Math.floor(1.99) : " + Math.floor(1.99));
    console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
    console.log("Math.random() : " + Math.random());
  }
  
  /*
  ########################
  String Methods
  ########################
  
  The string data type has a lot of properties and methods similar to strings in Java/C#
  */
  
  function stringFunctions(value) {
    console.log(`.length -  ${value.length}`);
    console.log(`.endsWith('World') - ${value.endsWith("World")}`);
    console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
    console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);
  
       /*
      Some Other Methods
          - split(string)
          - substr(number, number)
          - substring(number, number)
          - toLowerCase()
          - trim()
          - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
      */
     //The split() method splits a string into an array of substrings based on a specified separator and returns the new array.
     let sentence = "The agile cow jumps over the moon";
     let words = sentence.split(" "); // Splitting the string by spaces
     console.log(words); // ["The", "agile", "cow", "jumps", "over", "the", "moon"]
 
 
     // The substring() method returns a part of the string between the start and end indexes, or to the end of the string.
     let text = "Hello, World!";
     let segment = text.substring(7, 12); // Extracting a substring from index 7 to 12
     console.log(segment); // "World"
 
     //The toLowerCase() method returns the calling string value converted to lowercase.
     let greeting = "Hello, GALAXY!";
     let lowerCaseGreeting = greeting.toLowerCase(); // Converting the string to lowercase
     console.log(lowerCaseGreeting); // "hello, galaxy!"
 
     //The trim() method removes whitespace from both ends of a string.
     let messyString = "    Space here and there     ";
     let cleanedString = messyString.trim(); // Removing whitespace from both ends
     console.log(cleanedString); // "Space here and there"
 
 
     //These string methods can also be used in combination for more complex operations. For instance:
     let data = "  Cow:Jump;Over:Moon  ";
     let cleanedData = data.trim().toLowerCase();
     let pairs = cleanedData.split(";");
     pairs.forEach(pair => {
         let [key, value] = pair.split(":");
         console.log(`Key: ${key}, Value: ${value}`);
     });
 
  
   }


 
   /*
  ########################
  Logical branching
  ########################
  */
 
 /**
 * Determines a student's grade based on their score.
 * @param {number} score - The student's score.
 * @returns {string} The grade.
 */
  function getGrade(score) {
    let grade;

    if (score >= 90) {
        grade = 'A';
    } else if (score >= 80) {
        grade = 'B';
    } else if (score >= 70) {
        grade = 'C';
    } else if (score >= 60) {
        grade = 'D';
    } else {
        grade = 'F';
    }

    return grade;
}

console.log(getGrade(85)); // Should return 'B'


/**
* Provides a basic description of a planet.
* @param {string} planet - The name of the planet.
* @returns {string} Description of the planet.
*/
function describePlanet(planet) {
let description;

switch (planet) {
  case 'Mercury':
      description = 'Mercury is the closest planet to the Sun.';
      break;
  case 'Venus':
      description = 'Venus is known as Earth\'s twin because of their similar size.';
      break;
  case 'Earth':
      description = 'Earth is the only planet known to support life.';
      break;
  case 'Mars':
      description = 'Mars is known as the Red Planet.';
      break;
  default:
      description = 'Information about this planet is not available.';
}

return description;
}

console.log(describePlanet('Mars')); // Should return 'Mars is known as the Red Planet.'

  
/*
  ########################
  Looping
  ########################
  */
  function forLoops(){
    //for loop
    // Looping through an array with a for loop
    const planets = ['Mercury', 'Venus', 'Earth', 'Mars'];

    for (let i = 0; i < planets.length; i++) {
        console.log(planets[i]);
    }

    // Using a for loop to print numbers from 1 to 5
    for (let i = 1; i <= 5; i++) {
      console.log(i);
    }


    //while loop
    // Using a while loop to print numbers from 1 to 5
    let i = 1;
    while (i <= 5) {
        console.log(i);
        i++;
    }


    //do while loop
    // Using a do...while loop to print numbers from 1 to 5
    let j = 1;
    do {
        console.log(j);
        j++;
    } while (j <= 5);


    //for of loop (value)
    // Looping through an array with a for...of loop (ES6)
    for (const planet of planets) {
      console.log(planet);
    }

    //for in loop (key)
    for (const planet in planets) {
      console.log(planet);
    }

    //forEach
    // Using forEach to iterate over an array
    planets.forEach(function(planet) {
      console.log(planet);
    });
}