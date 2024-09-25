<template>
    <div class="my-books-view">
      <h1>My Reading List</h1>
      <reading-list :books="myBooks" />
      <router-link to="/addBook" class="add-book-link">Add a New Book</router-link>
    </div>
  </template>
  
  <script>
  import ReadingList from '@/components/ReadingList.vue'; // Adjust the path as needed
  
  export default {
    components: {
      ReadingList,
    },
    computed: {
      myBooks() {
        return this.$store.state.books; // Assuming 'books' contains the user's reading list
      }
    }
  }
  </script>
  
  <style>
  .my-books-view {
    padding: 20px;
  }
  </style>