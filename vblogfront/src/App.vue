<template>
  <div id="app">
    <!--<img src="./assets/logo.png">-->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  body{
    margin:0;
    padding:0 !important; /* 解决弹窗对页面整体的影响 */
  }
#app {
  font-family:  Helvetica Neue,Helvetica,Arial,Hiragino Sans GB,Hiragino Sans GB W3,WenQuanYi Micro Hei,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
