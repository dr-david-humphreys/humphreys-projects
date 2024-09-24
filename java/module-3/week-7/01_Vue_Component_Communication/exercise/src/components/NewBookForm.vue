<template>
    <form class="new-book-form" @submit.prevent="addBook">
      <input class="title-input" v-model="title" placeholder="Title" required />
      <input class="author-input" v-model="author" placeholder="Author" required />
      <input class="isbn-input" v-model="isbn" placeholder="ISBN" required />
      <button type="submit">Add Book</button>
    </form>
  </template>
  
  <script>
  export default {
    data() {
      return {
        title: '',
        author: '',
        isbn: ''
      };
    },
    methods: {
      addBook() {
        const newBook = {
          title: this.title,
          author: this.author,
          isbn: this.isbn,
          read: false // Default new book as unread
        };
        this.$store.dispatch('addBook', newBook);
        // Reset form fields
        this.title = '';
        this.author = '';
        this.isbn = '';
      }
    }
  };
  </script>
  
  <style>
  .new-book-form {
    margin: 20px;
    display: flex;
    flex-direction: column;
  }
  
  .new-book-form input {
    margin-bottom: 10px;
  }
  
  .title-input,
  .author-input,
  .isbn-input {
    padding: 8px;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  </style>