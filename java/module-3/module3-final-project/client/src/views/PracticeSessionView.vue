<template>
    <div>
      <header>
        <h1>Music Practice Tracker!</h1>
        <img src="img/Generic-Music-Notes.jpg" alt="Generic Music Picture" class="music-image" />
        <nav>
          <ul>
            <li><router-link to="/">Home</router-link></li>
            <li><router-link to="/about">About</router-link></li>
            <li><router-link to="/contact">Contact</router-link></li>
          </ul>
        </nav>
        <button @click="buttonClicked">Click Me</button>
        <button @click="toggleTheme">Toggle Theme</button>
        <button @click="removeLastItem">Remove Last Item</button>
      </header>
  
      <main id="resource-container">
        <div v-for="resource in resources" :key="resource.id">
          <h3>Practice Session: {{ resource.practiceSessionNumber }}</h3>
          <p>Goal: {{ resource.goal }}</p>
        </div>
      </main>
  
      <section>
        <h2>Add New Practice Session!</h2>
        <form @submit.prevent="addPracticeSession">
          <input type="text" v-model="newPracticeSessionNumber" placeholder="Enter Practice Session Number" required />
          <input type="text" v-model="newGoal" placeholder="Enter Goal" required />
          <button type="submit">Add Item</button>
        </form>
      </section>
  
      <footer>
        <p>&copy; 2024 Humphreys Music Practice Tracker. All Rights Reserved.</p>
      </footer>
    </div>
  </template>
  
  <script>
  import { resourceService } from "../services/ResourceService";
  import { fetchPracticeSessions, addPracticeSession } from "../services/api";
  
  export default {
    data() {
      return {
        resources: [],
        newPracticeSessionNumber: "",
        newGoal: "",
      };
    },
    created() {
      this.resources = resourceService.getResources();
      this.loadPracticeSessions();
    },
    methods: {
      buttonClicked() {
        alert("Button clicked!");
      },
      toggleTheme() {
        document.body.classList.toggle("dark-mode");
      },
      removeLastItem() {
        if (this.resources.length) {
          this.resources.pop();
        }
      },
      async loadPracticeSessions() {
        try {
          const response = await fetchPracticeSessions();
          this.resources = response.data;
        } catch (error) {
          console.error("Error fetching practice sessions:", error);
        }
      },
      async addPracticeSession() {
        const newResource = {
          id: this.resources.length + 1,
          practiceSessionNumber: this.newPracticeSessionNumber,
          goal: this.newGoal,
        };
        try {
          const response = await addPracticeSession(newResource);
          this.resources.push(response.data);
          this.newPracticeSessionNumber = "";
          this.newGoal = "";
        } catch (error) {
          console.error("Error adding practice session:", error);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  body {
    font-family: Arial, sans-serif;
    display: grid;
    grid-template-columns: 1fr;
    grid-gap: 20px;
    margin: 0;
    padding: 0;
    background-color: #afdde5;
    color: #003135;
  }
  
  .dark-mode {
    background-color: #003135;
    color: #afdde5;
  }
  
  header {
    background-color: #024950;
    color: #afdde5;
    padding: 20px;
    text-align: center;
  }
  
  .music-image {
    width: 700px;
    height: 200px;
    object-fit: cover;
  }
  
  nav ul {
    list-style-type: none;
    padding: 0;
  }
  
  nav ul li {
    display: inline-block;
    margin-right: 10px;
  }
  
  nav ul li a {
    color: #afdde5;
    text-decoration: none;
  }
  
  main {
    padding: 20px;
  }
  
  footer {
    background-color: #024950;
    color: #afdde5;
    text-align: center;
    padding: 10px;
  }
  
  @media (min-width: 1024px) {
    body {
      display: grid;
      grid-template-columns: 1fr 3fr;
      grid-gap: 20px;
    }
  
    header,
    footer {
      grid-column: span 2;
    }
  }
  
  @media (max-width: 425px) {
    body {
      grid-template-columns: 1fr;
    }
  
    nav ul {
      display: flex;
      justify-content: center;
      flex-wrap: wrap;
      flex-direction: column;
      align-items: center;
    }
  
    nav ul li {
      display: block;
      margin-bottom: 10px;
    }
  }
  
  body {
    overflow-x: hidden;
  }
  </style>
  