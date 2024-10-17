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
        <h2>Add New Goal!</h2>
        <form @submit.prevent="addGoal">
            <input v-model="newGoal.description" type="text" placeholder="Goal Description" required />
            <input v-model="newGoal.targetDate" type="date" required />
            <input v-model="newGoal.notes" type="text" placeholder="Notes" />
            <button type="submit">Add Goal</button>
        </form>

        <ul>
          <li v-for="goal in goals" :key="goal.id">
            <p>Description: {{ goal.description }}</p>
            <p>Target Date: {{ goal.targetDate }}</p>
            <p>Achieved: {{ goal.achieved ? 'Yes' : 'No' }}</p>
            <p>Notes: {{ goal.notes }}</p>
            <button @click="updateGoal(goal.id)">Update</button>
            <button @click="deleteGoal(goal.id)">Delete</button>
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
        goals: [],
        newGoal: {
          userId: this.userId,
          description: '',
          targetDate: '',
          achieved: false,
          notes: '',
        },
      };
    },

    created() {
      this.loadGoals();
    },
    methods: {
      buttonClicked() {
        alert("Button clicked!");
      },
      toggleTheme() {
        document.body.classList.toggle("dark-mode");
      },
      removeLastItem() {
        if (this.goals.length) {
          this.goals.pop();
        }
      },

      loadGoals() {
            ApiService.getGoals(this.userId)
                .then(response => {
                    this.goals = response.data;
                })
                .catch(error => {
                    console.error('Error loading goals:', error);
                });
        },

        addGoal() {
            ApiService.addGoal(this.newGoal)
                .then(response => {
                    console.log('Goal added:', response.data);
                    this.loadGoals();
                    this.resetNewGoal();
                })
                .catch(error => {
                    console.error('Error adding goal:', error);
                });
        },

        updateGoal(id) {
            const updatedGoalData = {
                ...this.goals.find(goal => goal.id === id),
                description: prompt("Enter new description:", ""),
                targetDate: prompt("Enter new target date:", ""),
                notes: prompt("Enter new notes:", ""),
            };

            ApiService.updateGoal(id, updatedGoalData)
                .then(response => {
                    console.log('Goal updated:', response.data);
                    this.loadGoals();
                })
                .catch(error => {
                    console.error('Error updating goal:', error);
                });
        },

        deleteGoal(id) {
            if (confirm("Are you sure you want to delete this goal?")) {
                ApiService.deleteGoal(id)
                    .then(() => {
                        console.log('Goal deleted');
                        this.loadGoals();
                    })
                    .catch(error => {
                        console.error('Error deleting goal:', error);
                    });
            }
        },

        resetNewGoal() {
            this.newGoal = {
                userId: this.userId,
                description: '',
                targetDate: '',
                achieved: false,
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