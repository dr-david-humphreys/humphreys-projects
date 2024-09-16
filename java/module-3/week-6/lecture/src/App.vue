<template>
  <div class="main">
     <header class="app-header">
        <div class="logo-container">
            <img src="./assets/appLogo.png" alt="Movie Review Logo" class="logo">
            <h1 class="app-title">Movie Reviews App</h1>
        </div>
    </header>
    <!-- <img alt="App logo" src="./assets/movieImg.png" /> -->
    
    <movie-review />
  </div>
</template>

<script>
import MovieReview from './components/MovieReview.vue';

export default {
  components: {
    MovieReview
  }
};
</script>

<style scoped>
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}

.app-header {
    background-color: #1f1f1f;
    color: white;
    display: flex;
    align-items: center;
    padding: 10px 20px;
    height: 60px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.logo-container {
    display: flex;
    align-items: center;
}

.logo {
    height: 40px;
    width: auto;
    margin-right: 10px;
}

.app-title {
    font-size: 24px;
    font-weight: bold;
    color: #ffffff;
}
</style>
