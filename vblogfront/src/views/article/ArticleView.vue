<template>
  <main class="container">
    <div class="row g-5">
      <div class="col-md-12">
        <h2 class="pb-4 mb-4 fst-italic border-bottom">
          Current Article id = {{ this.$route.query.id }}
          {{ this.article.title }}
        </h2>

        <article class="blog-post">
          <p class="blog-post-meta">{{ this.article.publishTime }} by <a href="#">uid={{ this.article.userId }}</a></p>
          <p class="blog-post-meta">
            comment count = {{ this.article.commentCount }}
            like count = {{ this.article.likeCount }}
            read count = {{ this.article.readCount }}
          </p>

          <hr>
          <p>{{ this.article.content }}</p>
          <img v-if="article.image==null" src="../../../src/assets/img/3.png">
          <!--          <img v-if="article.image!=null" src="">-->
        </article>

        <div class="table table-borderless">

          <table class="table align-middle">
            <thead class="toast-header">
            Comment
            </thead>

            <tbody>
            <tr v-for="item in comment" v-bind:key="item.user">
              <td>commenter id = {{ item.commenterId }}</td>
              <td>comment time = {{ item.commentTime }}</td>
              <td>comment content = {{ item.content }}</td>
            </tr>
            </tbody>
          </table>
        </div>

        <div class="position-absolute buttom-0 start-50 translate-middle-x">
          <label for="description" class="form-label" style="font-size: 20px;font-weight:bolder">评论框</label>
          <textarea style="width:1000px" v-model="description" class="form-control" id="description"
                    rows="2"></textarea>
          <button class="btn btn-outline-primary" href="#">提交</button>
        </div>
        <!--            <nav class="blog-pagination" aria-label="Pagination">-->
        <!--                -->
        <!--            </nav>-->

      </div>

    </div>
  </main>
</template>

<script>
import comment from "@/service/comment";

export default {
  name: 'ArticleView',
  data() {
    return {
      article: {}, // init when view loaded.
      comment: {}, // init when view loaded.
      publisher: {}, // init when view loaded.
    }
  },
  methods: {
    fetchArticle(id) {
      this.$api.article.getArticleById(id).then(
          (response) => {
            if (response.data.code === '0000') {
              // set article if request success.
              this.article = response.data.data
            } else {
              console.log(response.data.message)
            }
          }
      ).catch((error) => {
        Promise.reject(error)
      })
    },
    fetchUserInfo(userId) {
      //TODO
    },
    fetchComments(articleId, startPage, pageSize) {
      this.$api.comment.getCommentByArticlePaged(articleId, startPage, pageSize).then(
          (response) => {
            if (response.data.code === '0000') {
              // set comments if request success.
              this.comment = response.data.data.list
              console.log(this.comment)
            } else {
              console.log(response.data.message)
            }
          }
      ).catch((error) => {
        Promise.reject(error)
      })
    }
  },
  mounted() {
    // execute this method when current view loaded.
    this.fetchArticle(this.$route.query.id) // request article model from backend.
    this.fetchComments(this.$route.query.id, 1, 5) // request 1st page of comments from backend.
  }
}
</script>

<style scoped>

</style>
