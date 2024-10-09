<template>
  <h1>Logout</h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>

<style scoped>
body {
  font-family: Arial, sans-serif;
  background-color: #afdde5;
  color: #003135;
}

#logout {
  text-align: center;
  padding: 20px;
  margin-top: 50px;
}

h1 {
  color: #024950;
  font-size: 24px;
}

@media (max-width: 425px) {
  #logout {
    padding: 10px;
  }
}
</style>