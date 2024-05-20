# Module Assessment

## Introduction

This assessment verifies the competencies that you learned during the module. It's a hands-on assessment that you'll complete inside your IDE. The assessment has two parts:

* **Part One** covers foundational programming concepts such as data types, branching, loops, arrays, and collections. These code challenges look like the exercises you completed in the associated units. The project includes tests that verify that you have completed each challenge.

* **Part Two** includes a written specification. You'll build a class by adding fields and methods. The provided tests verify that you correctly coded the class according to specification, much like the object-oriented programming exercises you completed earlier in the module. You'll find a detailed specification of the requirements of this class in a later section of this document.

**After completing both parts, you need to `add`, `commit`, and `push` the solution code to your repository.

## Hints and suggestions

* You can freely switch between both parts. If you get stuck on one part, you may want to move to the other.
* `push` your code often. Whenever you reach a point where you feel like you've made good progress and your code builds, commit and push your changes.
* The code you submit must build properly to get scored. _Please make sure you don't have any build errors._

### Running the tests

The project includes tests so you can verify your code. You can find the tests under `src/test/java/com.techelevator/`. The tests in the `AssessmentPart1Test` class are for part one, and the tests in the `FlowerOrderTest` class are for part two. **Be sure to run all of these tests.**

> To run all tests in _IntelliJ_, you can right-click in the `java` folder beneath `test`, and select **Run 'All Tests'**.

## Part One: Code challenges

All of the challenges are in `src/main/java/com.techelevator/AssessmentPart1.java`. Work through each challenge, running tests as you see fit.

After finishing your work, commit, and push the code to your repository.

## Part Two: Class specification

In this part, you'll complete a `FlowerOrder` class in `src/main/java/com.techelevator/FlowerOrder.java`. As you work through the following list, you'll be able to run tests at any point to see your progress.

* `FlowerOrder` must have the following attributes:
  * `size` (`String`) indicates the size of the order: `"small"`, `"medium"`, or `"large"`. _Public getter and setter_.
  * `numRoses` (`int`) indicates how many roses to add to the order. _Public getter and setter_.
  * `includeVase` (`boolean`) indicates whether or not the order includes a vase _Public getter and setter_.
  * `preTaxPrice` (`double`) _Public getter_. Calculated using these values:

    | Item         | Cost         |
    |--------------|---------------|
    | Small Order  | $10.00       |
    | Medium Order | $15.00       |
    | Large Order  | $20.00       |
    | Roses        | $ 1.50 each  |
    | Vase         | $ 5.00       |

  * `tax` (`double`) _Public getter_. Calculated as 5% of the pre-tax price
  * `totalPrice` (`double`) _Public getter_. Sum of the pre-tax price and the tax

* `FlowerOrder` must have a public default constructor. A default constructed `FlowerOrder` must be set to a small size with no roses and no vase.

* `FlowerOrder` must have a public constructor which accepts the parameters `size`, `numRoses`, and `includeVase` (in that order), with the appropriate data types for their corresponding fields. Set the values of the object's fields using the arguments passed into the constructor.

* `FlowerOrder` must have a public `toString` method that has the appropriate annotation and returns a `String` in the following format

   `Size: {size}, Num Roses: {numRoses}, Include Vase: {includeVase}, Pre-Tax Price: {preTaxPrice}`

    where the values in curly brackets are placeholders for the actual values. For example:
  
    `Size: medium, Num Roses: 1, Include Vase: false, Pre-Tax Price: 16.5`

    *Note:* The pre-tax price does not need to be formatted as currency

## Finalizing your work

After finishing your work, be sure the project builds. Then add, commit, and push the code to your repository.
