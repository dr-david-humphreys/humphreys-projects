<template>
    <div class="new-book-view">
      <h1>Add a New Book</h1>
      <new-book-form />
    </div>
  </template>
  
  <script>
  import NewBookForm from '@/components/NewBookForm.vue'; // Adjust the path as needed
  
  export default {
    components: {
      NewBookForm,
    }
  }
  </script>
  
  <style>
  .new-book-view {
    padding: 20px;
  }
  </style>