import {createApp} from 'vue'
import App from './App.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import router from './router'
import store from './store'
import axios from 'axios'
import VueAxios from 'vue-axios'
import qs from 'qs'
import api from "@/service/api";

axios.defaults.withCredentials = true

const app = createApp(App)
app.config.globalProperties.$api = api
app.use(store).use(router).use(VueAxios,axios).use(qs)
app.mount('#app')

