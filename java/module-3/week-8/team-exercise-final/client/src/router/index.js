import { createRouter as _createRouter, createWebHistory } from 'vue-router'

import HotelsView from '../views/HotelsView.vue'
import HotelDetailsView from '../views/HotelDetailsView.vue'
import ReservationAddView from '../views/ReservationAddView.vue'
import ReservationUpdateView from '../views/ReservationUpdateView.vue'
import ReservationDeleteView from '../views/ReservationDeleteView.vue'

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 */

const routes = [
    {
      path: '/',
      name: 'home',
      component: HotelsView,
    },
    {
      path: '/hotel/:id',
      name: 'hotel',
      component: HotelDetailsView,
    },
    {
      path: '/hotel/:id/newreservation',
      name: 'add-reservation',
      component: ReservationAddView,
    },
    {
      path: '/reservation/:id/update',
      name: 'update-reservation',
      component: ReservationUpdateView,
    },
    {
      path: '/reservation/:id/delete',
      name: 'delete-reservation',
      component: ReservationDeleteView,
    },
  ];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
