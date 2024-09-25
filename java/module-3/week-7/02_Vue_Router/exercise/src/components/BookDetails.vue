<template>
    <div class="book-details">
      <h1>{{ book.title }}</h1>
      <p><strong>Author:</strong> {{ book.author }}</p>
      <p><strong>ISBN:</strong> {{ book.isbn }}</p>
      <p><strong>Number of Pages:</strong> {{ book.numPages }}</p>
      <a :href="book.moreInfoLink" target="_blank">More Information</a>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      book: {
        type: Object,
        required: true,
      },
    },
  }
  </script>
  
  <style>
  .book-details {
    padding: 20px;
  }
  </style>