const starshipName = 'Starship Discovery';
const description = 'Plan the perfect intergalactic adventure getaway for all of your friends.';
const reviews = [
  {
    reviewer: "Alice Starbound",
    title: "A Journey Beyond the Stars",
    review: "The Discovery offered an unforgettable voyage to the Andromeda Galaxy. The crew was professional, and the accommodations were top-notch.",
    rating: 5
  },
  {
      reviewer: "Zane Cosmos",
      title: "Smooth Sailing Through the Asteroid Belt",
      review: "Discovery handled the rough terrain of the asteroid belt with ease. The onboard entertainment kept us engaged throughout the journey.",
      rating: 4
  },
  {
      reviewer: "Luna Celeste",
      title: "Good, but Room for Improvement",
      review: "While the Discovery's amenities were decent, I found the food options to be lacking. However, the views of the nebulae were breathtaking.",
      rating: 3
  },
  {
      reviewer: "Orion Skywalker",
      title: "Adventure of a Lifetime",
      review: "Traveling on the Discovery was an experience like no other. From start to finish, everything was perfectly executed. Highly recommended!",
      rating: 5
  }
];

/**
 * Add the product name to the page title
 * Get the page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {}

/**
 * Add the product description to the page.
 */
function setPageDescription() {}

/**
 * Display all of the reviews on the page.
 * Loop over the array of reviews and use some helper functions
 * to create the elements needed for the markup and add them to the DOM.
 */
function displayReviews() {}

/**
 * Create a new h2 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {}

/**
 * Add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {}

/**
 * Add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {}

/**
 * Add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
