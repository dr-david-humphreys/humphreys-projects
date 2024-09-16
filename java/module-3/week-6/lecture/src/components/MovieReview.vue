<template>
  <div class="main">
    
    <h2> 
      <p>
        <img src="../assets/movieImg.png" class="movie-cover">
      </p>
      Movie Reviews for {{ name }}
    </h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount" v-on:click="starFilter = 0">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 1">{{ numberOfOneStarReviews }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 2">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 3">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 4">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 5">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

    <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = true"
      v-if="showForm === false"
      >Show Form</a
    >

    <form v-on:submit.prevent="addNewReview" v-show="showForm === true">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <!-- NOTE: Use .number modifier here so newReview.rating is a number, not a string -->
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <input type="submit" value="Save">
      <input type="button" value="Cancel" v-on:click="resetForm">
    </form>

    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in filteredReviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-bind:id="'favorite_' + review.id" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: 'Prey',
      description:
        'Set in the Comanche Nation 300 years ago, "Prey" is the story of a young woman, Naru, a fierce and highly skilled warrior.  She has been raised in the shadow of some of the most legendary hunters who roam the Great Plains, so when danger threatens her camp, she sets out to protect her people. ',
      nextReviewId: 1005,
      newReview: {},
      showForm: false,
      starFilter: 0,
      reviews: [
      {
        id: 1000,
        reviewer: "ActionFanatic",
        title: "A Fresh Take on Predator!",
        review: "Absolutely loved this new addition to the Predator series. The setting and the protagonist made the movie feel fresh and exciting. Great tension and action scenes. A must-watch!",
        rating: 5,
        favorited: false
      },
      {
        id: 1001,
        reviewer: "CinemaLover",
        title: "A Step in the Right Direction",
        review: "Prey brings something fresh to the franchise. The historical setting and the protagonist’s journey were a nice change. Loved the cinematography!",
        rating: 4,
        favorited: false
      },
      {
        id: 1002,
        reviewer: "PredatorFan24",
        title: "A Worthy Prequel",
        review: "Prey is a worthy prequel to the Predator series. It brings a different atmosphere and more grounded action. While not perfect, it's still an enjoyable movie.",
        rating: 4,
        favorited: false
      },
      {
        id: 1003,
        reviewer: "HorrorHunter",
        title: "Excellent Predator Sequel",
        review: "Prey is easily one of the best Predator sequels. The setting in the past works surprisingly well, and the lead character was great. A fantastic addition to the franchise!",
        rating: 5,
        favorited: false
      },
      {
        id: 1004,
        reviewer: "IndieFilmFan",
        title: "Beautiful but Flawed",
        review: "The movie looks beautiful and I loved the idea of setting it in a historical period, but the execution wasn’t as sharp as I had hoped. Still enjoyable though!",
        rating: 3,
        favorited: false
      }
      ]
    };
  },
  computed: {
    averageRating() {
      if (this.reviews.length === 0) {
        return 0;
      }
      
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(2);
    },
    numberOfOneStarReviews() {
      return this.numberOfReviews(1);
    },
    numberOfTwoStarReviews() {
      return this.numberOfReviews(2);
    },
    numberOfThreeStarReviews() {
      return this.numberOfReviews(3);
    },
    numberOfFourStarReviews() {
      return this.numberOfReviews(4);
    },
    numberOfFiveStarReviews() {
      return this.numberOfReviews(5);
    },
    filteredReviews() {
      return this.reviews.filter(review => {
        return this.starFilter === 0 || this.starFilter === review.rating;
      });
    }
  },
  methods: {
    /*
     * Returns the next review id. Normally, a database would assign a unique id for the review.
     * This code simulates that since there's no database in this example.
     */
    getNextReviewId() {
      return this.nextReviewId++;
    },
    addNewReview() {
      this.newReview.id = this.getNextReviewId();
      this.reviews.unshift(this.newReview);
      this.resetForm();
    },
    resetForm() {
      this.newReview = {};
      this.showForm = false;
    },
    numberOfReviews(numOfStars) {
      const reviewsWithNumStars = this.reviews.filter((review) => {
        return review.rating === numOfStars;
      });
      return reviewsWithNumStars.length;
    },
  }
  
};
</script>

<style scoped>
.main {
  margin: 1rem 0;
}

.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}

.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}

.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

.amount:hover {
  cursor: pointer;
}

.favorited {
  background-color: lightyellow;
}

.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

.rating img {
  height: 100%;
}

.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  text-align: left;
}
.review p {
  margin: 20px;
}

.review h3 {
  display: block;
  margin: 1rem;
}

.review h4 {
  font-size: 1rem;
}

.form-element {
  margin-top: 10px;
}

.form-element label {
  display: block;
}

.form-element input,
.form-element select {
  height: 30px;
  width: 300px;
}

.form-element textarea {
  height: 60px;
  width: 300px;
}

form input[type=button] {
  width: 100px;
}

form input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
.movie-cover{
  height: 20vh;
}
</style>
