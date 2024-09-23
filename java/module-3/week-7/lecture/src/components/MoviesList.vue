<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="movie in $store.state.movies" v-bind:key="movie.id">
        <td>{{ movie.id }}</td>
        <td>
          <router-link
            v-bind:to="{ name: 'movie-detail', params: { id: movie.id }}"
          >{{ movie.name }}</router-link>
        </td>
        <td>{{ movie.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {};
</script>

<style scoped>
table {
  margin: auto;
}

th, td {
  text-align: left;
  padding: 10px;
  vertical-align: top;
}

tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
