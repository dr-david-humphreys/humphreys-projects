<template>
    <header>
      <h1>Welcome To The Humphreys Music Practice Tracker!!!</h1>
      <img src="img/Generic-Music-Notes.jpg" alt="Generic Music Picture" class="music-image" />
      <nav>
        <ul>
          <li><router-link to="/practice-session">Practice Sessions</router-link></li>
          <li><router-link to="/goal">Goals</router-link></li>
          <li><router-link to="/about">About</router-link></li>
          <li><router-link to="/contact">Contact</router-link></li>
        </ul>
      </nav>
    </header>
  </template>
  
  <script>
  export default {
    name: "HeaderComponent",
  };
  </script>
  
  <style scoped>
  
  header {
    background-color: #024950;
    color: #afdde5;
    padding: 20px;
    text-align: center;
  }
  nav ul {
    list-style-type: none;
    padding: 0;
  }
  nav li {
    display: inline;
    margin-right: 15px;
  }
  </style>