import {createApp} from 'vue'
import App from './App.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import router from './router'
import store from './store'
import axios from 'axios'
import VueAxios from 'vue-axios'
import qs from 'qs'


axios.defaults.baseURL = 'http://localhost:8989'
axios.defaults.withCredentials = true

createApp(App).use(store).use(router).use(VueAxios,axios).use(qs).mount('#app')

