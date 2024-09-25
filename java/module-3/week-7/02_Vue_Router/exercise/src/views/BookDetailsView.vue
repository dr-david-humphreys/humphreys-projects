<template>
    <div class="book-details-view">
      <BookDetails v-if="book" :book="book" />
      <p v-else>Loading...</p>
    </div>
  </template>
  
  <script>
  import { mapState } from 'vuex';
  import BookDetails from '@/components/BookDetails.vue';
  
  export default {
    components: {
      BookDetails,
    },
    computed: {
      ...mapState(['books']),
      book() {
        const isbn = this.$route.params.isbn;
        return this.books.find(b => b.isbn === isbn);
      }
    }
  }
  </script>
  
  <style>
  .book-details-view {
    padding: 20px;
  }
  </style>