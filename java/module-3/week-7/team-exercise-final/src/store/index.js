import { createStore as _createStore } from 'vuex';

export function createStore() {
  return _createStore({
    state: {
      ratingsFilter: 0,
      nextReviewId: 1005,
      movies: [
        {
          id: 1,
          name: 'Prey',
          description: 'Set in the Comanche Nation 300 years ago, "Prey" is the story of a young woman, Naru, a fierce and highly skilled warrior.  She has been raised in the shadow of some of the most legendary hunters who roam the Great Plains, so when danger threatens her camp, she sets out to protect her people. ',
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
        },
        {
          id: 2,
          name: 'Alien Romulus',
          description: 'Space colonizers come face to face with the most terrifying life-form in the universe while scavenging the deep ends of a derelict space station.',
          reviews: []
        },
        {
          id: 3,
          name: 'American Fiction',
          description: 'Monk is a frustrated novelist who\'s fed up with the establishment that profits from Black entertainment that relies on tired and offensive tropes. To prove his point, he uses a pen name to write an outlandish Black book of his own, a book that propels him to the heart of hypocrisy and the madness he claims to disdain.',
          reviews: []
        },
        {
          id: 4,
          name: 'Dune - Part Two',
          description: 'Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the universe, he must prevent a terrible future only he can foresee.',
          reviews: []
        },
        {
          id: 5,
          name: 'A Quiet Place: Day One',
          description: 'When New York City comes under attack from an alien invasion, a woman and other survivors try to find a way to safety. They soon learn that they must remain absolutely silent as the mysterious creatures are drawn to the slightest sound.',
          reviews: []
        }
      ]
    },
    mutations: {
      ADD_REVIEW(state, review) {
        const movie = state.movies.find(p => p.id == review.movieId);
        review.id = state.nextReviewId++;
        movie.reviews.unshift(review);
      },
      UPDATE_FILTER(state, ratingsFilter) {
        state.ratingsFilter = ratingsFilter;
      },
      FLIP_FAVORITED(state, reviewToChange) {
        reviewToChange.favorited = ! reviewToChange.favorited;
      },
    },
    actions: {},
    modules: {},
    // Strict should not be used in production code. It is used here as a
    // learning aid to warn you if state is modified without using a mutation.
    strict: true
  });
}
