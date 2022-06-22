<template>
  <el-main style="margin-top: 3.75rem;">
    <el-row>
      <h1 style="color: palegoldenrod; line-height: 1.5em; font-size: 2rem;">Core contributors</h1>
      <ul id="profilepic" style="list-style-type:none; display: flex;
            left: 8rem;
            right: 8rem;
            flex-flow: row nowrap;
            justify-content: center;
            padding-inline-start: 0;">
        <li style="position: relative;">
          <img class="profile_style" src="../../../assets/index-image/profilepicture/ran.jpg"
               @click="open_ran()">
          <span class="title">ran.</span></li>
        <li style="position: relative;">
          <img class="profile_style" src="../../../assets/index-image/profilepicture/xuewen.jpg"
               @click="open_xuewen()">
          <span class="title">xuewen</span></li>
        <li style="position: relative;">
          <img class="profile_style" src="../../../assets/index-image/profilepicture/pivot.jpg"
               @click="open_pivot()">
          <span class="title">pivot</span></li>
        <li style="position: relative;">
          <img class="profile_style" src="../../../assets/index-image/profilepicture/lee.jpg"
               @click="open_lhyUnited()">
          <span class="title">lhyUnited</span></li>
      </ul>
    </el-row>
  </el-main>
</template>

<script>
export default {
  name: 'ForthPage',
  data () {
    return {}
  },
  methods: {
    open_ran () {
      window.open('http://www.tonightac.club')
    },
    open_xuewen () {
      window.open('https://blog.xuewen.me')
    },
    open_pivot () {
      window.open('https://blog.csdn.net/h_18_messi')
    },
    open_lhyUnited () {
      window.open('https://www.tomluvjerry.cn')
    }
  }
}
</script>

<style scoped>
  .profile_style {
    width: 12.5rem;
    height: 12.5rem;
    border-radius: 100%;
    margin-right: 6.25rem;
    margin-left: 6.25rem;
    cursor: pointer;
    transition: all 0.8s; /* 定义动画持续时长 */
  }
  .profile_style:hover{
    transform:scale(1.2); /* 头像放大 */
    opacity: 0.5;
  }
  .profile_style:hover + .title{
    transition: all 0.8s;
    opacity: 1;
  }
  .title{
    position: absolute;
    top: 0rem;
    left: 0;
    right: 0;
    font-weight: 700;
    font-size: 2rem;
    color: gold;
    cursor: default;
    opacity: 0;
  }
</style>
