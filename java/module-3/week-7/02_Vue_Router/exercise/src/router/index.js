import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
import MyBooksView from '@/views/MyBooksView.vue';
import NewBookView from '@/views/NewBookView.vue';
import BookDetailsView from '@/views/BookDetailsView.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView,
  },

  {
    path: '/myBooks',
    name: 'MyBooks',
    component: MyBooksView,
  },

  {
    path: '/addBook',
    name: 'NewBook',
    component: NewBookView,
  },

  {
    path: '/book/:isbn',
    name: 'BookDetails',
    component: BookDetailsView,
  }
];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
