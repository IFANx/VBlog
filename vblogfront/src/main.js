// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

import App from './App'
import Vue from 'vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/display.css'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueRouter from 'vue-router'
import qs from 'qs'
import 'fullpage.js/vendors/scrolloverflow'
import fullpage from 'vue-fullpage.js'

Vue.use(fullpage)
Vue.use(qs)
Vue.use(VueRouter)
Vue.use(ElementUI)
Vue.use(VueAxios, axios)
axios.defaults.baseURL = 'http://localhost:8989'
axios.defaults.withCredentials = true
Vue.config.productionTip = false

// 建立登录状态检测，已登录用户不可以访问login 和 sign up界面 完成√
// 在main中写函数
/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  components: { App },
  template: '<App/>',
  created () {
    // let ison = localStorage.getItem('line')
    // let that = this
    // let hasMenus = {}
    // if (ison === 'true') {
    //   hasMenus = {
    //     'login': true,
    //     'sign': true,
    //     'center': false,
    //     'editor': false,
    //     'main': true,
    //     'homework': false,
    //     'test': true,
    //     'test1': true
    //   }
    // } else {
    //   hasMenus = {
    //     'login': false,
    //     'sign': false,
    //     'center': true,
    //     'editor': true,
    //     'main': true,
    //     'homework': true,
    //     'test': true,
    //     'test1': true
    //   }
    // }
    // if (hasMenus[that.$route.name]) {
    //   console.log(that.$route.name)
    // } else {
    //   if (hasMenus['main']) {
    //     that.$router.push({name: 'main'})
    //   } else {
    //     that.$router.push({name: 'login'})
    //   }
    // }
  }
})
