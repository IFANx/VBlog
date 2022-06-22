<template>
  <div>
    <el-container style="margin-top: -60px">
      <join-class :visible.sync="JoinClass"></join-class>
      <logined-header></logined-header>
      <main-student v-if="student"  @func="showDialog"></main-student>
      <main-teacher v-else></main-teacher>
    </el-container>
  </div>
</template>

<script>
import LoginedHeader from '@/components/headers/LoginedHeader'
import MainStudent from '@/components/Pages/MainPages/MainStudent'
import MainTeacher from '@/components/Pages/MainPages/MainTeacher'
import JoinClass from '@/components/dialogs/JoinClass'
export default {
  name: 'MainPage',
  components: {JoinClass, LoginedHeader, MainStudent, MainTeacher},
  data () {
    return {
      student: false,
      JoinClass: false
    }
  },
  mounted () {
    this.judgeRole()
  },
  methods: {
    judgeRole () {
      var userInfo = JSON.parse(localStorage.getItem('UserInfo'))
      var role = userInfo.data.urole
      if (role === 0) {
        this.student = true
      }
    },
    showDialog (data) {
      this.JoinClass = data.JoinArg
    }
  }
}
</script>

<style scoped>

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
  li{
    list-style: none;
  }
</style>
