<template>
  <el-main style="margin-top: 7.5rem;">
    <el-row>
      <el-col :xl="10" :lg="8" @click.native="teacher_enter">
        <el-row type="flex" justify="center">
          <el-col :xl="20" :lg="16">
            <img id="t_logo" :class="{'default':t_play, 'filterOption':display}" src="../../../assets/index-image/teacher.png"><br>
            <img style="margin-top: 2.5rem;"
                 :class="{'default':t_play, 'filterOption':display}"
                 src="../../../assets/index-image/books_logo.png">
          </el-col>
          <el-col :xl="4" :lg="8"><a id="arrow_left" class="is-vertical"></a></el-col>
        </el-row>
      </el-col>
      <el-col :xl="4" :lg="8" class="infoByRole">
        <el-row><h2 style="color: whitesmoke;">&nbsp;&nbsp;&nbsp;如何使用HomeWorkOut</h2></el-row>
        <el-row  v-if="role_teacher">
          <p style="color: whitesmoke;">班长: </p>
          <el-row type="flex" justify="center" style="height: 25.25rem;">
            <el-steps direction="vertical" :active="active_teacher" finish-status="success">
              <el-step title="注册/登录"></el-step>
              <el-step title="创建班级"></el-step>
              <el-step title="发布作业"></el-step>
              <el-step title="打包下载"></el-step>
            </el-steps>
          </el-row><br><br>
          <el-button @click="next_teacher">下一步</el-button><br><br>
        </el-row>
        <el-row v-if="role_student">
          <p style="color: whitesmoke;">学生: </p>
          <el-row type="flex" justify="center" style="height: 25.25rem;">
            <el-steps direction="vertical" :active="active_student" finish-status="success">
              <el-step title="注册/登录"></el-step>
              <el-step title="加入班级"></el-step>
              <el-step title="选择作业"></el-step>
              <el-step title="提交作业"></el-step>
            </el-steps>
          </el-row><br><br>
          <el-button @click="next_student">下一步</el-button><br><br>
        </el-row>
      </el-col>
      <el-col :xl="10" :lg="8" @click.native="student_enter">
        <el-row>
          <el-col :xl="4" :lg="4" style="height: 1px;"><a id="arrow_right" class="is-vertical"></a></el-col>
          <el-col :xl="20" :lg="20">
            <img id="s_logo" :class="{'default':s_play, 'filterOption':display}" src="../../../assets/index-image/student.png"><br>
            <img style="margin-top: 2.5rem;"
               :class="{'default':s_play, 'filterOption':display}"
               src="../../../assets/index-image/glasses_logo.png">
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
export default {
  name: 'ThirdPage',
  data () {
    return {
      role_teacher: false,
      role_student: false,
      active_teacher: 0,
      active_student: 0,
      t_play: true,
      s_play: true,
      display: false
    }
  },
  methods: {
    next_teacher () {
      if (this.active_teacher === -1) this.active_teacher++
      if (this.active_teacher++ === 4) this.active_teacher = 0
      console.log('班长：' + this.active_teacher)
    },
    next_student () {
      if (this.active_student === -1) this.active_student++
      if (this.active_student++ === 4) this.active_student = 0
      console.log('学生' + this.active_student)
    },
    teacher_enter () {
      console.log('hello1')
      this.s_play = true
      this.t_play = false
      this.role_teacher = true
      this.role_student = false
    },
    student_enter () {
      this.t_play = true
      this.s_play = false
      this.role_teacher = false
      this.role_student = true
    }
  }
}
</script>

<style scoped>
  @media only screen and (max-width: 1900px) {
    #t_logo{
      width: 32rem;
      height: 32rem;
    }
    #s_logo{
      width: 32rem;
      height: 32rem;
    }
  }
  .default{
    filter: grayscale(40%);
    opacity: 0.6;
  }
  .default:hover{
    cursor:pointer
  }
  filterOption{
    filter:none;
    opacity: 1;
  }
  #arrow_left{
    cursor: pointer;
    width: 2.2rem;
    height: 2.2rem;
    -webkit-transform: rotate(135deg);
    -ms-transform: rotate(135deg);
    transform: rotate(135deg);
    border-bottom: 4px solid rgb(255, 255, 255);
    border-right: 4px solid rgb(255, 255, 255);
    position: absolute;
    -webkit-animation: arrow_left .5s ease-in-out alternate infinite;
    animation: arrow_left .5s ease-in-out alternate infinite;
    top: 12.5rem;
    cursor: pointer;
    opacity: 0.5;
    -webkit-transition: opacity .2s ease-in-out, transform .5s ease-in-out .2s;
    transition: opacity .2s ease-in-out, transform .5s ease-in-out .2s;
  }
  @-webkit-keyframes arrow_left {
    100% {
      top: 12.8rem
    }
  }
  @keyframes arrow_left {
    100% {
      top: 12.8rem
    }
  }
  #arrow_right{
    cursor: pointer;
    width: 2.2rem;
    height: 2.2rem;
    -webkit-transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    transform: rotate(-45deg);
    border-bottom: 4px solid rgb(255, 255, 255);
    border-right: 4px solid rgb(255, 255, 255);
    position: absolute;
    -webkit-animation: arrow_left .5s ease-in-out alternate infinite;
    animation: arrow_left .5s ease-in-out alternate infinite;
    top: 12.5rem;
    cursor: pointer;
    opacity: 0.5;
    -webkit-transition: opacity .2s ease-in-out, transform .5s ease-in-out .2s;
    transition: opacity .2s ease-in-out, transform .5s ease-in-out .2s;
  }
  @-webkit-keyframes arrow_right {
    100% {
      top: 12.8rem
    }
  }
  @keyframes arrow_right {
    100% {
      top: 12.8rem
    }
  }
</style>
