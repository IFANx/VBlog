<template>
  <el-main style="margin-top: 10rem">
    <el-row type="flex" justify="center" class="icons">
      <el-col :span="4">
        <li>
          <a><img class="list-func" src="../../../assets/MainPage/plus.png" alt="创建班级"></a>
        </li>
        <p>创建班级</p>
      </el-col>
      <el-col :span="4">
        <li>
          <a><img class="list-func" src="../../../assets/MainPage/zoom-in.png" alt="查看班级"></a>
        </li>
        <p>查看你创建的班级</p>
      </el-col>
      <el-col :span="4">
        <li>
          <a><img class="list-func" src="../../../assets/MainPage/calendar.png" alt="收取作业"></a>
        </li>
        <p>收取作业</p>
      </el-col>
      <el-col :span="4">
        <li>
          <a><img class="list-func" src="../../../assets/MainPage/user.png" alt="编辑资料"></a>
        </li>
        <p>编辑资料</p>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
export default {
  name: 'MainTeacher'
}
</script>

<style scoped>
.list-func{
  cursor:pointer;
}
</style>
