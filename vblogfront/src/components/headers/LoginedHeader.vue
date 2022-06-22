<template>
  <el-header class="LoginedHeader">
    <el-row>
      <el-col :span="8"><img style="width: 180px; float: left" src="../../assets/logo.png"></el-col>
      <el-col :span="8">
        <el-menu mode="horizontal" background-color="transparent" style="border-bottom: none;">
          <el-menu-item style="cursor:default; color:#33ffff;"><router-link style="text-decoration: none" to="/">首页</router-link></el-menu-item>
          <el-submenu style="cursor:default;" index="1">
            <template slot="title">班级</template>
            <el-menu-item index="1-1">加入班级</el-menu-item>
            <el-menu-item index="1-2">查看班级</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-col>
      <el-col :span="8">
        <div style="position: absolute;
                    top: 50%;
                    right: 70px;
                    transform: translateY(-50%);
                    color: #33ffff;">
          <h3 style="float: left">欢迎，{{username}}</h3>
        </div>
        <el-dropdown style="position: absolute; top: 50%; right: 10px; transform: translateY(-50%)">
          <el-avatar class="el-dropdown-link" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item><i class="el-icon-setting"></i>编辑资料</el-dropdown-item>
            <el-dropdown-item divided @click.native="LogOut"><i class="el-icon-back"></i>退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-col>
    </el-row>
  </el-header>
</template>

<script>
export default {
  name: 'LoginedHeader',
  data () {
    return {
      username: ''
    }
  },
  mounted () {
    this.ShowUserInfo()
  },
  methods: {
    ShowUserInfo () {
      let data = JSON.parse(localStorage.getItem('UserInfo'))
      this.username = data.data.uname
    },
    LogOut () {
      localStorage.removeItem('UserInfo')
      this.$router.push({name: 'Home'})
    }
  }
}
</script>

<style scoped>
.LoginedHeader{
  background-color: #171a21;
  position:fixed;
  width: 100%;
}
.el-menu-item:hover{
  color: #ffffff !important;
  background-color: #171a21 !important;
}
</style>
<style>
  .el-submenu__title{
    color: #33ffff !important;
  }
  .el-menu--horizontal>.el-submenu:hover .el-submenu__title{
    background-color: #171a21 !important;
  }
</style>
