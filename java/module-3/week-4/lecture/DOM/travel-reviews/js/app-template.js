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
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = starshipName;
}

/**
 * Add the product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * Use a template to display all of the reviews on the web page
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    const main = document.getElementById('main');
    reviews.forEach((review) => {
      const tmpl = document.getElementById('review-template').content.cloneNode(true);
      tmpl.querySelector('h2').innerText = review.reviewer;
      tmpl.querySelector('h3').innerText = review.title;
      tmpl.querySelector('p').innerText = review.review;
      // there will always be 1 star because it is a part of the template
      for (let i = 1; i < review.rating; ++i) {
        const img = tmpl.querySelector('img').cloneNode();
        tmpl.querySelector('.rating').appendChild(img);
      }
      main.appendChild(tmpl);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
