<template>
    <div>
      <header>
        <h1>Music Practice Tracker!</h1>
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
  
      <section>
        <h2>About</h2>
          <p>This app was created to help musicians track their practice sessions by Dr. David Humphreys</p>
      </section>
  
      <footer>
        <p>&copy; 2024 Humphreys Music Practice Tracker. All Rights Reserved.</p>
      </footer>
    </div>
  </template>
  
  <script>
  export default {
    name: "AboutView"
  };
  </script>
  
  <style scoped>
  #about {
    text-align: center;
    margin-top: 50px;
  }

  a:hover {
    text-decoration: underline;
  }
  </style>
  