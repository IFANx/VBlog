<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/>

  <div class="container">
    <form class="form-login">
      <h1 class="h3 mb-3 font-weight-normal">Bootstrap Component Import Test</h1>
      <label for="inputEmail" class="sr-only">Email Address</label>
      <input type="email" id="inputEmail" class="form-control mb-2" placeholder="Email Address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" class="form-control mb-2" id="inputPassword" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"/>Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>
  </div>

</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
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
  margin-top: 60px;
}
</style>
