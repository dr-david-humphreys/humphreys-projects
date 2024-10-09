<template>
    <div>
      <h1>Contact</h1>
      <p>
        You can reach me at 
        <a href="mailto:david.k.humphreys1@gmail.com">david.k.humphreys1@gmail.com</a>.
      </p>
    </div>
  </template>
  
  <script>
  export default {
    name: "ContactView",
  };
  </script>
  
  <style scoped>
  p {
    font-size: 1.2rem;
    margin-top: 20px;
  }
  
  a {
    color: #3498db;
    text-decoration: none;
  }
  
  a:hover {
    text-decoration: underline;
  }
  </style>
  