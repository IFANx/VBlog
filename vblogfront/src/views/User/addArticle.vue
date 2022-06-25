<template>
    <SideBars></SideBars>
    <div class="container">
        <main class="addArticle">
            <div class="py-5 text-center">
                <img v-if="this.portrait==null" class="header-img" src="../../../src/assets/img/doge.png" alt="" width="150" height="150">
                <!--                <h2>Profile</h2>-->
            </div>
            <div class="row g-5" >
                <div class="container-sm">
                    <form class="needs-validation" novalidate>
                        <div class="row g-3">
                            <div class="col-12">
                                <label for="account" class="form-label">Title</label>
                                <div class="input-group has-validation">
                                    <span class="input-group-text">#</span>
                                    <input v-model="article.title" type="text" class="form-control" id="account" placeholder="Title" required>
                                    <div class="invalid-feedback">
                                        Valid Title is required.
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="description" class="form-label">Content</label>
                                <textarea v-model="article.content" class="form-control" id="description" rows="10"></textarea>
                            </div>
<!--                            <div class="input-group">-->
<!--                                <input  @change="imgChange" type="file"  class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">-->
<!--&lt;!&ndash;                                <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">Button</button>&ndash;&gt;-->
<!--                            </div>-->
                        </div>
                        <button type="button" class="btn btn-primary" @click="add">发布</button>
                    </form>
                </div>

            </div>

        </main>

        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">&copy; vblog2022</p>
        </footer>


    </div>
</template>

<script>
  import SideBars from '../SideBars/SideBars'
  export default {
    name: 'addArticle',
    components: {SideBars},
    data () {
      return {
       article:{
         id: null,
         userId:this.$store.getters.getUserId,
         commentCount:0,
         likeCount:0,
         readCount:0,
         tag:'test',
         subscribeCount:0
       }
      }
    },methods:{
      // imgChange(e){
      //   let file = e.target.files[0]
      //   this.article.cover = file
      // },
      add (){
        console.log(this.$store.getters.getUserId)
        // console.log(this.article.cover)
        this.article.publishTime=new Date()
        this.$api.article.insertArticle(this.article).then(
          (res) => {
            if(res.data.code === '0000') {
              alert("发布成功")
            } else {
              console.log(res.data.message)
            }
          }
        ).catch((error) => {
          Promise.reject(error)
        })
      }
    }
  }
</script>

<style scoped>

</style>
