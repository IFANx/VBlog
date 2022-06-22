<template>
  <el-main>
    <div>
      <transition name="fade">
        <el-row v-if="ValuesForSecondPage" style="top: 15rem;"><h1 style="color: whitesmoke; line-height: 1.5em;
            letter-spacing: 2.5rem; font-size: 2.18rem;">
          告别传统交作业方式</h1></el-row>
      </transition>
      <el-row class="list-features" style="top: 25rem;">
        <el-col :span="6"><transition name="fade">
          <li v-if="ValuesForSecondPage" style="color: white; transition-delay: 0.2s">
            <a>
              <img src="../../../assets/index-image/analytics.png">
              <h3>快&nbsp;捷</h3>
              <p>仅需要一台可以<br/>上网的电脑</p>
            </a></li>
        </transition></el-col>
        <el-col :span="6"><transition name="fade">
          <li v-if="ValuesForSecondPage" style="color: white; transition-delay: 0.3s">
            <a>
              <img src="../../../assets/index-image/paper-plane.png">
              <h3>高&nbsp;效</h3>
              <p>点下按钮即<br/>完成作业提交</p>
            </a></li>
        </transition></el-col>
        <el-col :span="6"><transition name="fade">
          <li v-if="ValuesForSecondPage" style="color: white; transition-delay: 0.4s">
            <a>
              <img src="../../../assets/index-image/responsive.png">
              <h3>自&nbsp;由</h3>
              <p>作业可多次提交,<br/>交错了也没关系</p>
            </a></li>
        </transition></el-col>
        <el-col :span="6"><transition name="fade">
          <li v-if="ValuesForSecondPage" style="color: white; transition-delay: 0.5s">
            <a>
              <img slot="reference" src="../../../assets/index-image/alarm-clock.png">
              <h3>规&nbsp;划</h3>
              <p>根据截止时间,<br/>合理规划,<br/>尽快完成作业</p>
            </a></li>
        </transition></el-col>
      </el-row>
    </div>
  </el-main>
</template>

<script>
export default {
  name: 'SecondPage',
  props: ['ValuesForSecondPage']
}
</script>

<style scoped>
  .fade-enter-active, .fade-leave-active {
    transition: opacity 1.5s;
  }
  .fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
    opacity: 0;
  }
  li{
    list-style-type: none;
  }
</style>
