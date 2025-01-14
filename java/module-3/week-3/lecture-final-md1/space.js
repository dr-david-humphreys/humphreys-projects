/**
 * Simulates a space journey with takeoff, in-flight controls, and landing.
 */

// Variables and Data Types
let altitude = 0; // Altitude of the spacecraft
let speed = 0; // Speed of the spacecraft

/**
 * Function to handle takeoff.
 * @param {number} initialSpeed - The initial speed for takeoff, defaulting to 1000 if not provided.
 */
function takeOff(initialSpeed = 1000) {
    console.log("Initiating takeoff sequence.");
    speed = initialSpeed;
    altitude = 1000;
    console.log(`Speed set to ${speed} and altitude reached ${altitude}.`);
}

// Named function for altitude adjustment
/**
 * Adjusts the altitude of the spacecraft.
 * @param {number} adjustment - The amount to adjust the altitude by.
 * @returns {number} The new altitude.
 */
function adjustAltitude(adjustment) {
    altitude += adjustment;
    return altitude;
}

// Anonymous function for speed adjustment, stored in a variable
const adjustSpeed = (adjustment) => {    
    console.log(`Target Speed adjusted to ${speed}.`);
    return speed += adjustment;
};

// Looping - Simple in-flight check
for (let i = 0; i < 5; i++) {
    console.log(`In-flight check ${i + 1}: All systems operational.`);
}

// Arrays - Storing in-flight tasks
const tasks = ["Stabilize orbit", "Collect data", "Deploy satellite", "Start return journey"];

// Iterating over array using forEach (anonymous function)
tasks.forEach((task, index) => {
    console.log(`Task ${index + 1}: ${task}.`);
});

// Function that returns a value - check fuel
/**
 * Checks the fuel level.
 * @returns {string} A message about the fuel level.
 */
function checkFuel() {
    // Assuming a constant for demonstration
    const fuelLevel = 50;
    return fuelLevel > 25 ? "Fuel level is adequate." : "Warning: Low fuel.";
}

// Final approach - Function without a return value
/**
 * Handles the landing sequence.
 */
function land() {
    console.log("Initiating landing sequence.");
    adjustSpeed(-speed); // Slowing down to 0
    while (altitude > 0) {
        adjustAltitude(-100); // Decreasing altitude
        console.log(`Current altitude: ${altitude}`);
    }
    console.log("Landing complete.");
}


function runSimulator(){
    // TODO 1: Create a variable to hold an array of space objects to investigate. 
    //properties: name - string, size - number, tracked - boolean
    // Arrays - Space objects encountered during the journey
   

    // Objects with a size greater than 10 may be worth futher investigation/analysis.
    //Create a variable -"objectsToInvestigate" to hold objects with a size greater than 10. 
    //Use "filter" with an anonymous function to find objects with a size > 10.
    const objectsToInvestigate = spaceObjects.filter(object => object.size > 10);


    // TODO 2:
    // Simulate the space journey (takeoff, adjust altitude, adjust speed, check fuel, investigate objects, land)

    takeOff();
    console.log(adjustAltitude(500)); // Adjusting altitude
    adjustSpeed(200); // Adjusting speed
    console.log(checkFuel()); // Checking fuel

    console.log("Objects to investigate:", objectsToInvestigate);

    land(); // Landing
}




