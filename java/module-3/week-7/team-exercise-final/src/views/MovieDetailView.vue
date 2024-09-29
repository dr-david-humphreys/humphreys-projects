<template>
  <h1>{{ movie.name }}</h1>
  <p class="description">{{ movie.description }}</p>
  <div class="actions">
    <router-link v-bind:to="{ name: 'movies' }">Back to movies</router-link>&nbsp;|
    <router-link v-bind:to="{ name: 'add-review', params: { id: movie.id } }">Add Review</router-link>
  </div>
  <div class="well-display">
    <average-summary v-bind:reviews="movie.reviews"/>
    <star-summary 
        v-for="i in 5" 
        v-bind:rating="i" 
        v-bind:key="i"
        v-bind:reviews="movie.reviews" />
  </div>
  <review-list v-bind:reviews="movie.reviews"/>
</template>

<script>
import AverageSummary from '../components/AverageSummary.vue';
import StarSummary from '../components/StarSummary.vue';
import ReviewList from '../components/ReviewList.vue';

export default {
  components: {
    AverageSummary,
    StarSummary,
    ReviewList
  },
  computed: {
    movie() {
      // Get movie id from the URL
      let movieId = this.$route.params.id;
      let movie = this.$store.state.movies.find(p => p.id == movieId);
      return movie;
    },
  },
};
</script>

<style scoped>
.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}
.actions {
  margin: 2rem;
}
</style>
