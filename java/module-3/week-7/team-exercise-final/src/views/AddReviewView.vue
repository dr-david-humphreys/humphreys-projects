<template>
  <h1>Add Review</h1>
  <add-review v-bind:movieId="movieId"/>
</template>

<script>
import AddReview from '../components/AddReview.vue';

export default {
  components: {
    AddReview
  },
  computed: {
    movieId() {
      // Get movie id from the URL
      return this.$route.params.id
    },
  }
};
</script>

<style>
</style>
