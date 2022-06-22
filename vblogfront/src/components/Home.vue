<template>
  <div>
    <login-dialog @func="stateEmit" :visible.sync="loginDialogVisible"></login-dialog>
    <sign-up-dialog :visible.sync="signUpDialogVisible"></sign-up-dialog>
    <full-page :options="options" id="fullpage" style="margin-top: -60px;">
      <div class="section">
        <el-container class="back-img">
          <logined-header v-if="logined"></logined-header>
          <original-header v-else @func="stateEmit"></original-header>
          <first-page @RegisterInstantly="registerInstantly" :show_first="first_Father" :ChangeBtn="logined"></first-page>
        </el-container>
      </div>
      <div class="section">
        <el-container class="back-img-2">
          <logined-header v-if="logined"></logined-header>
          <original-header v-else @func="stateEmit"></original-header>
          <second-page :ValuesForSecondPage="ValuesForSecondPage"></second-page>
        </el-container>
      </div>
      <div class="section">
        <el-container class="back-img-3 is-vertical">
          <logined-header v-if="logined"></logined-header>
          <original-header v-else @func="stateEmit"></original-header>
          <third-page></third-page>
          <el-footer></el-footer>
        </el-container>
      </div>
      <div class="section">
        <el-container class="back-img-4 is-vertical">
          <logined-header v-if="logined"></logined-header>
          <original-header v-else @func="stateEmit"></original-header>
          <forth-page></forth-page>
          <!-- <el-footer style="position: absolute; bottom: 0; height: 30%; width: 100%; background-color: rgba(0, 0, 0, .4)">
            <h2 style="text-align: center">copy right</h2>
          </el-footer> -->
        </el-container>
      </div>
    </full-page>
  </div>
</template>

<script>
import LoginedHeader from './headers/LoginedHeader'
import OriginalHeader from './headers/OriginalHeader'
import LoginDialog from './dialogs/LoginDialog'
import SignUpDialog from './dialogs/SignUpDialog'
import FirstPage from './Pages/HomePages/FirstPage'
import SecondPage from './Pages/HomePages/SecondPage'
import ThirdPage from './Pages/HomePages/ThirdPage'
import ForthPage from './Pages/HomePages/ForthPage'
export default {
  name: 'Home',
  components: {SignUpDialog,
    LoginDialog,
    LoginedHeader,
    OriginalHeader,
    FirstPage,
    SecondPage,
    ThirdPage,
    ForthPage},
  data () {
    return {
      logined: false,
      loginDialogVisible: false,
      signUpDialogVisible: false,
      username: '',
      pwd: '',
      pwdaga: '',
      mail: '',
      first_Father: false,
      ValuesForSecondPage: false,
      options: {
        afterRender: this.afterRender,
        afterLoad: this.afterLoad
      }
    }
  },
  mounted () {
    this.ChangeHeader()
  },
  methods: {
    ChangeHeader () {
      var key = JSON.parse(localStorage.getItem('UserInfo'))
      if (key !== null) this.logined = key.code === '0000'
    },
    stateEmit (data) {
      this.loginDialogVisible = data.loginArg
      this.signUpDialogVisible = data.signUpArg
      console.log('loginDialogVisible' + ' ' + this.loginDialogVisible)
    },
    registerInstantly (data) {
      this.signUpDialogVisible = data.signUpArg
    },
    // 注册完成后自动登陆，问题点。
    // let that = this
    // if (that.pwd !== that.pwdaga) {
    //   that.$notify.error({
    //     title: '错误',
    //     message: '两次输入的密码不一致'
    //   })
    //   that.pwdaga = ''
    //   that.pwd = ''
    // } else {
    //   let s = 'user/signUp?uemail=' + that.mail + '&pwd=' + that.pwd + '&urole=' + that.radio + '&uname=' + that.username
    //   that.axios.post(s)
    //     .then(function (res) {
    //       if (res.data === 'error') {
    //         that.$notify.error({
    //           title: '失败',
    //           message: '注册失败'
    //         })
    //         that.mail = ''
    //         that.pwd = ''
    //         that.pwdaga = ''
    //         that.username = ''
    //       } else {
    //         that.$notify.success({
    //           title: '成功',
    //           message: '注册成功'
    //         })
    //         localStorage.setItem('line', 'false')
    //         localStorage.setItem('username', that.username)
    //         localStorage.setItem('uno', res.data)
    //         localStorage.setItem('policy', that.role)
    //         that.$router.push({name: 'main'})
    //       }
    //     })
    // }
    afterLoad: function (origin, destination) {
      console.log('page' + destination.index + 'loaded')
      if (destination.index === 0) {
        this.first_Father = true
      }
      if (destination.index === 1) {
        /* this.first = false */
        this.ValuesForSecondPage = true
      }
    }
  }
}
</script>

<style scoped>
  .back-img{
    background-image: url("../assets/index-image/no3.jpg");
    background-position: 0;
    background-size: cover;
    width: 100%;
    height: 100%;
    background-color: #fff;
  }
  .back-img-2{
    background-image: url("../assets/index-image/no4.jpg");
    background-position: 0;
    background-size: cover;
    width: 100%;
    height: 100%;
    background-color: #fff;
  }
  .back-img-3{
    background-image: url("../assets/index-image/no5.png");
    background-position: 0;
    background-size: cover;
    width: 100%;
    height: 100%;
    background-color: #fff;
  }
  .back-img-4{
    background-image: url("../assets/index-image/no6.jpg");
    background-position: 0;
    background-size: cover;
    width: 100%;
    height: 100%;
    background-color: #fff;
  }
</style>

<style>
  /* 解决pc端屏幕显示设置缩放比例对页面布局的影响, 进而可以实现任何屏幕比例的自适应 */
  /* 以下代码仅针对浏览器缩放至125%进行了自适应 */
  /* 设定根元素的px值，从而将组件的px值转换为rem */
  /* 不能写在scoped中，否则会失效 */
  :root {
    font-size: 16px;
  }
  @media only screen and (max-width: 1900px){
    :root {
      font-size: 12px;
    }
  }
  @media only screen and (max-width: 1200px){
    :root {
      font-size: 10px;
    }
  }
</style>
