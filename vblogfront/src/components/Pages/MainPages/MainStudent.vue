<template>
  <el-main style="margin-top: 10rem">
    <el-row type="flex" justify="center" class="icons">
      <el-col :span="4">
        <li>
          <a><img class="list-func" @click="JoinClassDialog" src="../../../assets/MainPage/plus.png" alt="加入班级"></a>
        </li>
        <p>加入班级</p>
      </el-col>
      <el-col :span="4">
        <li>
          <a><img class="list-func" src="../../../assets/MainPage/zoom-in.png" alt="查看班级"></a>
        </li>
        <p>查看你所在的班级</p>
      </el-col>
      <el-col :span="4">
        <li>
          <a><img class="list-func" src="../../../assets/MainPage/calendar.png" alt="提交作业"></a>
        </li>
        <p>提交作业</p>
      </el-col>
      <el-col :span="4">
        <li>
          <a><img class="list-func" @click="EditProfile" src="../../../assets/MainPage/user.png" alt="编辑资料"></a>
        </li>
        <p>编辑资料</p>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
import JoinClass from '@/components/dialogs/JoinClass'
export default {
  name: 'MainStudent',
  components: {JoinClass},
  data () {
    return {
      show: false
    }
  },
  methods: {
    JoinClassDialog () {
      this.$emit('func', {JoinArg: true})
    },
    EditProfile () {
      this.$router.push({name: 'editprofile'})
    }
  }
}
</script>

<style scoped>
.list-func{
  cursor:pointer ;
}
</style>
