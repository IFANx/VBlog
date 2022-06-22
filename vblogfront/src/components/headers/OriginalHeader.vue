<template>
  <el-header style="position:fixed; width: 100%">
    <el-row>
      <el-col :span="12"><img style="width: 180px; height: 70px; position: absolute; left: 10px; top: 50%; transform: translateY(-50%)" src="../../assets/logo.png"></el-col>
      <el-col :span="12" style="height: 5rem">
        <div style="position: absolute;right: 10px; top: 50%; transform: translateY(-50%)">
          <el-button plain @click="clickLogin" style="margin-right: 10px; border-width: 0; width: 75px; height: 40px">登录</el-button>
          <el-button plain style="background-color: transparent; color: whitesmoke; width: 75px; height: 40px" @click="clickSignUp">注册</el-button>
        </div>
      </el-col>
    </el-row>
  </el-header>
</template>

<script>
export default {
  name: 'OriginalHeader',
  data () {
    return {
    }
  },
  methods: {
    clickSignUp () {
      this.$emit('func', {signUpArg: true, loginArg: false})
    },
    clickLogin () {
      this.$emit('func', {signUpArg: false, loginArg: true})
    }
  }
}
</script>

<style scoped>
  li.el-menu-item:hover {
    background-color: transparent!important;
  }
</style>
