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
        <button @click="buttonClicked">Click Me</button>
        <button @click="toggleTheme">Toggle Theme</button>
        <button @click="removeLastItem">Remove Last Item</button>
      </header>
  
      <section>
        <h2>Add New Practice Session!</h2>
        <form @submit.prevent="addPracticeSession">
          <input v-model="newSession.date" type="date" required />
          <input v-model.number="newSession.duration" type="number" placeholder="Duration (min)" required />
          <input v-model="newSession.piecesPracticed" type="text" placeholder="Pieces Practiced" required />
          <textarea v-model="newSession.notes" placeholder="Notes"></textarea>
          <button type="submit">Add Practice Session</button>
        </form>

        <ul>
          <li v-for="session in practiceSessions" :key="session.practiceSessionId">
        <p>Date: {{ session.date }}</p>
        <p>Duration: {{ session.duration }} minutes</p>
        <p>Pieces Practiced: {{ session.piecesPracticed }}</p>
        <p>Notes: {{ session.notes }}</p>
        <button @click="updatePracticeSession(session.practiceSessionId)">Update</button>
        <button @click="deletePracticeSession(session.practiceSessionId)">Delete</button>
      </li>
        </ul>
      </section>
  
      <footer>
        <p>&copy; 2024 Humphreys Music Practice Tracker. All Rights Reserved.</p>
      </footer>
    </div>
  </template>
  
  <script>
  import ApiService from '../services/ApiService';
  
  export default {
    data() {
      return {
        practiceSessions: [],
        newSession: {
          userId: this.userId,
          date: '',
          duration: '',
          piecesPracticed: '',
          notes: '',
        },
      };
    },

    created() {
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
        if (this.practiceSessions.length) {
          this.practiceSessions.pop();
        }
      },

      loadPracticeSessions() {
        ApiService.getPracticeSessions()
          .then(response => {
            this.practiceSessions = response.data;
          })
          .catch(error => {
            console.error('Error loading practice sessions:', error);
          });
      },

      addPracticeSession() {
        ApiService.addPracticeSession(this.newSession)
          .then(response => {
            console.log('Practice session added:', response.data);
            this.loadPracticeSessions();
            this.resetNewSession();
          })
          .catch(error => {
            console.error('Error adding practice session:', error);
          });
      },

      updatePracticeSession(id) {
        const updatedSessionData = {
          ...this.practiceSessions.find(session => session.practiceSessionId === id),
          duration: prompt("Enter new duration:", this.practiceSessions.find(session => session.practiceSessionId === id).duration),
          piecesPracticed: prompt("Enter new pieces practiced:", this.practiceSessions.find(session => session.practiceSessionId === id).piecesPracticed),
          notes: prompt("Enter new notes:", this.practiceSessions.find(session => session.practiceSessionId === id).notes),
        };

        ApiService.updatePracticeSession(id, updatedSessionData)
          .then(response => {
            console.log('Practice session updated:', response.data);
            this.loadPracticeSessions();
          })
          .catch(error => {
            console.error('Error updating practice session:', error);
          });
      },

      deletePracticeSession(id) {
        if (confirm("Are you sure you want to delete this practice session?")) {
          ApiService.deletePracticeSession(id)
            .then(() => {
              console.log('Practice session deleted');
              this.loadPracticeSessions();
            })
            .catch(error => {
              console.error('Error deleting practice session:', error);
            });
        }
      },

      resetNewSession() {
        this.newSession = {
          userId: this.userId,
          date: '',
          duration: '',
          piecesPracticed: '',
          notes: '',
        };
      }
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
    /*width: 700px;
    height: 200px;*/
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

  a:hover {
    text-decoration: underline;
  }
  </style>
  ../services/ApiService