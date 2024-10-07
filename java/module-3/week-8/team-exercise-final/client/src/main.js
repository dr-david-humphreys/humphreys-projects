import { createApp } from 'vue'
import MyApp from './App.vue'
import { createStore } from './store'
import { createRouter } from './router'

import axios from 'axios'

/* import fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faTrashCan, faRotate, faPenToSquare, faHouse } from '@fortawesome/free-solid-svg-icons'

/* add icons to the library */
library.add(faTrashCan);
library.add(faRotate);
library.add(faPenToSquare);
library.add(faHouse);

/* sets the base url for server API communication with axios */
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;

const store = createStore()
const router = createRouter()

const app = createApp(MyApp);
app.use(store);
app.use(router);
app.component('font-awesome-icon', FontAwesomeIcon);
app.mount('#app');
