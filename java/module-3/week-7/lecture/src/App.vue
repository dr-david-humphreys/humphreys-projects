<template>
  <div class="main">
    <SiteHeader />  
    <router-view />
  </div>
</template>

<script>
import SiteHeader from './components/SiteHeader.vue';

export default {
  components:{
    SiteHeader
  }
};
</script>

<style>
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}


</style>
