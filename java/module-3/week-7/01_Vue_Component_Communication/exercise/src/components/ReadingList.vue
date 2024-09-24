<template>
  <div class="book-container">
    <BookCard
      v-for="book in books"
      :key="book.isbn"
      :book="book"
    />
  </div>
</template>

<script>
import { mapState } from "vuex";
import BookCard from './BookCard.vue';


export default {
    components: { BookCard },
    computed: {
      ...mapState(['books'])
    }
}
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>