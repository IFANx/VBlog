<template>
  <main class="form-signin">
    <form>
      <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
      <h1 class="h3 mb-3 fw-normal">请注册</h1>

      <div class="form-floating">
        <input v-model="account" class="form-control" id="account" placeholder="name@example.com">
        <label for="account">Account</label>
      </div>
      <div class="form-floating">
        <input v-model="password" type="password" class="form-control" id="password" placeholder="Password">
        <label for="password">Password</label>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="w-100 btn btn-lg btn-primary" type="submit" @click="signup">Sign Up</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
    </form>
  </main>
</template>

<script>
export default {
  name: 'SignUpView',
  data() {
    return {
      account: '',
      password: ''
    }
  },
  methods:{
    signup(){
      this.$api.user.register(this.account, this.password).then(
              (res) => {
                if(res.data.code === '0000') {
                  alert(res.data.message)
                  this.$router.push('login')
                } else {
                  console.log(res.data.message)
                }
              }
      ).catch((error) => {
        Promise.reject(error)
      })
    }
  }
}
</script>

<style scoped>
html,
body {
  height: 100%;
}

body {
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
