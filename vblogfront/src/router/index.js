import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import MainPage from '@/components/Pages/MainPage'
import EditProfile from '@/components/Pages/EditProfile'
// import Center from '@/user/center'
// import Editor from '@/user/Edit'
// import Manager from '@/admin/userManager'
// import Create from '@/admin/CreateClass'
// import Homework from '@/works/homework'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/mainpage',
      name: 'mainpage',
      component: MainPage
    },
    {
      path: '/editprofile',
      name: 'editprofile',
      component: EditProfile
    }
    //  url存疑
    // {
    //   path: '/users/' + localStorage.getItem('username') + '/center',
    //   name: 'center',
    //   component: Center
    // },
    // {
    //   path: '/users/' + localStorage.getItem('username') + '/edit',
    //   name: 'editor',
    //   component: Editor
    // },
    // {
    //   path: '/admin/' + localStorage.getItem('username') + '/Manager',
    //   name: 'manager',
    //   component: Manager
    // },
    // {
    //   path: '/admin/' + localStorage.getItem('username') + '/createClass',
    //   name: 'create',
    //   component: Create
    // },
    // {
    //   path: '/homework/' + localStorage.getItem('kno'),
    //   name: 'homework',
    //   component: Homework
    // }
  ]
})
