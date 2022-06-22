<template>
  <el-dialog title="欢迎回来" :visible="visible" :before-close="handleClose" width="30%">
    <el-input class="el-input" placeholder="请输入邮箱" v-model="username"></el-input><br>
    <el-input class="el-input" placeholder="请输入密码" v-model="pwd" show-password></el-input><br><br>
    <div style="margin-top: 30px">
      <el-button class="el-button" type="primary" plain @click="login" style="width: 100px">登录</el-button>&nbsp;&nbsp;&nbsp;
      <el-button class="el-button" @click="signUp" style="width: 100px">注册</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: 'LoginDialog',
  props: ['visible'],
  data () {
    return {
      username: '',
      pwd: ''
    }
  },
  methods: {
    handleClose (done) {
      this.$emit('update:visible', false)
      done()
    },
    login () {
      this.axios.post('/user/login', {account: this.username, password: this.pwd}).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '登陆成功',
            type: 'success'
          })
          /* 储存登录信息 */
          sessionStorage.setItem('UserInfo', JSON.stringify(res.data))
          this.$router.push({name: 'mainpage'})
        } else {
          this.$message.error('登陆失败，请核对用户名和密码')
        }
      }).catch(error => {
        console.log(error)
        this.$message.error('登陆失败，请检查网络')
      })
    },
    signUp () {
      this.$emit('func', {signUpArg: true, loginArg: false})
    }
  }
}
</script>

<style scoped>
  .el-input {
    margin-top: 10px;
    width: 300px;
  }
</style>
