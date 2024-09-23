import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import MoviesView from '../views/MoviesView.vue';
import MovieDetailView from '../views/MovieDetailView.vue';
import AddReviewView from '../views/AddReviewView.vue';

const routes = [
  {
    path: '/',
    name: 'movies',
    component: MoviesView
  },
  {
    path: '/movie/:id',
    name: 'movie-detail',
    component: MovieDetailView
  },
  {
    path: '/movie/:id/add-review',
    name: 'add-review',
    component: AddReviewView
  }
];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
