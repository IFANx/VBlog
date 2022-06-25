<template>
  <div class="b-example-divider"></div>

  <header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="#" class="nav-link px-2 text-white">Home</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input v-model="title" type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
        </form>

        <div class="text-end">
          <button type="button" class="btn btn-warning" @click="doSearch(this.title)">search</button>
          <button type="button" class="btn btn-outline-light me-2" @click="LoginView">Login</button>
          <button type="button" class="btn btn-warning" @click="SignUpView">Sign-up</button>
        </div>
      </div>
    </div>
  </header>


  <router-view/>
</template>
<script>
  export default {
    name: 'App',
    data() {
      return {
        title: ''
      }
    },
    methods:{
      doSearch(title) {
        this.$router.push('searchArticle?fuzzyTitle=' + title)
      },
      //Button 跳转到login或者signup页面
      LoginView(){
        this.$router.push("Login")
      },
      SignUpView(){
        this.$router.push("SignUp")
      },

    }
  }
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
