<template>
  <div class="card" :class="{ read: book.read }">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img 
      class="book-image"
      v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'"
      alt="Book cover"
    />

    <button
      v-if="book.read"
      class="mark-unread"
      @click="triggerToggleReadStatus"
    >
      Mark as Unread
    </button>
    <button
      v-else
      class="mark-read"
      @click="triggerToggleReadStatus"
    >
      Mark as Read
    </button>

  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  props: {
    book: Object
  },
  methods: {
    ...mapActions(['toggleReadStatus']),
    triggerToggleReadStatus() {
      this.toggleReadStatus(this.book.isbn);
    }
  }
}
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  position: relative;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}

.book-image {
  width: 80%;
}

.mark-read, .mark-unread {
  display: block;
  position: absolute;
  bottom: 40px;
  width: 80%;
  left: 10%;
  font-size: 1rem;
}
</style>