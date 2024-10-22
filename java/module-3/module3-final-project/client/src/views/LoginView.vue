<template>
  <div class="description-text">
    <p>The Music Practice Tracker app is designed to help musicians organize and optimize their practice routines by logging practice sessions, setting goals, and tracking progress over time.</p>
    <p>With features that allow users to record the duration, pieces practiced, and notes for each session, as well as set specific musical goals, this app enables users to stay consistent, focused, and motivated in their practice.</p>
    <p>Whether you're a beginner or a professional, this app helps you stay on top of your practice schedule and see measurable improvement, making it an essential tool for achieving musical growth!</p>
  </div>
  <div id="login">
    <form v-on:submit.prevent="login">
      <h1>Please Sign In</h1>
      <div id="fields">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password">Password</label>
        <input
          type="password"
          id="password"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <div><button type="submit">Sign in</button></div>
      </div>
      <hr/>
      Need an account? <router-link v-bind:to="{ name: 'register' }">Register!</router-link>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push( { name: "practice-session" });
          }
        })
        .catch((error) => {
          const response = error.response;
          if (!response) {
            alert(error);
          } else if (response.status === 401) {
            alert("Invalid username and password!");
          } else {
            alert(response.message);
          }
        });
    },
  },
};
</script>

<style scoped>
body {
  font-family: Arial, sans-serif;
  background-color: #afdde5;
  color: #003135;
}

.description-text {
  max-width: 600px;
  margin: 20px auto;
  text-align: center;
  font-size: 18px;
  line-height: 1.6;
  color: #024950;
}

#login {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h1 {
  color: #024950;
  text-align: center;
}

#fields {
  display: grid;
  gap: 10px;
}

label {
  margin-bottom: 5px;
  color: #003135;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #f9f9f9;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #024950;
  color: #afdde5;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

button:hover {
  background-color: #046369;
}

router-link {
  text-decoration: none;
  color: #024950;
}

router-link:hover {
  text-decoration: underline;
}

@media (min-width: 1024px) {
  #login {
    max-width: 500px;
  }
}

@media (max-width: 425px) {
  #login {
    padding: 10px;
  }
}

</style>
