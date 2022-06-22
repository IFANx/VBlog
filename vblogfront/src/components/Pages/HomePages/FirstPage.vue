<template>
  <el-main class="section-content">
    <!-- beforeEnter等仅作测试用 -->
    <transition v-on:before-enter="beforeEnter" v-on:enter="enter" name="fade">
      <!-- 在网页元素加载完毕后延时0.5秒加载动画 -->
      <el-row v-if="show_first" style="top: 20rem; transition-delay: 0.5s">
        <h1 style="color: #E4E7ED; font-size: 2rem">Home-WorkOut</h1>
        <p style="color: white; font-family: 黑体; font-size: 1.8rem;">一个能让你在家、寝室就能在线提交作业的平台</p>
        <el-button v-if="ChangeBtn" round style="background-color: transparent; color: white; margin-top: 7.5rem;
                font-size: 1rem;"
                   @click="MoveToHomePage">现在体验</el-button>
        <el-button v-else round style="background-color: transparent; color: white; margin-top: 7.5rem;
                font-size: 1rem;"
                   @click="registerUser">立即注册</el-button>
      </el-row>
    </transition>
  </el-main>
</template>

<script>
export default {
  name: 'FirstPage',
  props: ['show_first', 'ChangeBtn'],
  methods: {
    beforeEnter: function (el) {
      console.log('first preloading')
    },
    enter: function () {
      console.log('first loaded')
    },
    registerUser () {
      this.$emit('RegisterInstantly', {loginArg: false, signUpArg: true})
    },
    MoveToHomePage () {
      this.$router.push({name: 'mainpage'})
    }
  }
}
</script>

<style scoped>
  .fade-enter-active, .fade-leave-active {
    transition: opacity 2.0s;
  }
  .fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
    opacity: 0;
  }
</style>
