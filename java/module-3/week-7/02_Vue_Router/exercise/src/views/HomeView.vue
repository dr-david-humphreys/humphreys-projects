<template>
    <div class="home-view">
      <h1>Best Sellers</h1>
      <best-seller-list :books="popularBooks.filter(book => book.bestSeller)" />
      
      <h1>New Releases</h1>
      <new-releases-list :books="popularBooks.filter(book => book.newRelease)" />
    </div>
  </template>
  
  <script>
  import BestSellerList from '@/components/BestSellerList.vue'; // Adjust the path as needed
  import NewReleasesList from '@/components/NewReleasesList.vue'; // Adjust the path as needed
  
  export default {
    components: {
      BestSellerList,
      NewReleasesList,
    },
    computed: {
      popularBooks() {
        return this.$store.state.popularBooks;
      }
    }
  }
  </script>
  
  <style>
  .home-view {
    padding: 20px;
  }
  </style>