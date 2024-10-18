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
      <h2>Contact</h2>
      <p>
        You can reach me at 
        <a href="mailto:david.k.humphreys1@gmail.com">david.k.humphreys1@gmail.com</a>.
      </p>
    </section>

    <footer>
      <p>&copy; 2024 Humphreys Music Practice Tracker. All Rights Reserved.</p>
    </footer>
  </div>
</template>
  
  <script>
  export default {
    name: "ContactView",
  };
  </script>
  
  <style scoped>
  p {
    margin-top: 20px;
  }
  
  a:hover {
    text-decoration: underline;
  }
  </style>
  