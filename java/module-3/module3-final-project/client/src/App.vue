<template>
  <div id="cart-app">
    <header>
      <!-- Insert header component -->
    </header>
    <nav>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
          Logout
        </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
    </nav>
    <main>
      <router-view />
    </main>
    <footer>
      <!-- Insert footer component -->
    </footer>
  </div>
</template>

<style scoped>

</style>