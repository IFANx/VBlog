<template>
  <main class="container">
    <div class="row g-5">
      <div class="col-md-12">
        <!--  Title HERE-->
        <h2 class="pb-4 mb-4 fst-italic border-bottom">
          {{ this.article.title }}
        </h2>

        <!--    Article Area  -->
        <article class="blog-post">
          <p class="blog-post-meta">{{ this.article.publishTime }} by <a>{{ this.publisher.name }}</a></p>
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

        <!--    Comment Area    -->
        <container>
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

          <!--     Pagination NavBar     -->
          <nav aria-label="Page Navigation">
            <ul class="pagination">
              <li class="page-item" @click="toTargetPage(this.pagination.currentPage-1)"><a class="page-link">Prev
                Page</a></li>
              <template v-for="i in this.pagination.totalPages">
                <!--   use active item if it's current page   -->
                <li class="page-item active" v-if="pagination.currentPage==i">
                  <a class="page-link" @click="toTargetPage(i)">{{ i }}</a>
                </li>
                <!--   normal item if not   -->
                <li class="page-item" v-if="pagination.currentPage!=i">
                  <a class="page-link" @click="toTargetPage(i)">{{ i }}</a>
                </li>
              </template>
              <li class="page-item" @click="toTargetPage(this.pagination.currentPage+1)"><a class="page-link">Next
                Page</a></li>
            </ul>
          </nav>
        </container>

        <!--    New Comment    -->
        <div class="position-absolute buttom-0 start-50 translate-middle-x">
          <label for="description" class="form-label" style="font-size: 20px;font-weight:bolder">Add your comment
            here</label>
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

export default {
  name: 'ArticleView',
  data() {
    return {
      article: {}, // init when view loaded.
      comment: {}, // init when view loaded.
      publisher: {}, // init when view loaded.
      pagination: {
        currentPage: 1,
        pageSize: 10,
        total: 0,
        totalPages: 0
      }
    }
  },
  methods: {
    toTargetPage(pageIndex) {
      // low/upper bound check and fix.
      if (pageIndex > this.pagination.totalPages) pageIndex = this.pagination.totalPages
      if (pageIndex < 1) pageIndex = 1
      // to request paginated data.
      this.$api.comment.getCommentByArticlePaged(this.article.userId, pageIndex, this.pagination.pageSize).then(
          (response) => {
            if (response.data.code === '0000') {
              this.comment = response.data.data.list
              this.pagination.currentPage = pageIndex
            }
          }
      )
    },
    fetchArticle(id) {
      this.$api.article.getArticleById(id).then(
          (response) => {
            if (response.data.code === '0000') {
              // set article if request success.
              this.article = response.data.data
              this.fetchUserInfo(this.article.userId) // if article received, use it to access user info.
            } else {
              console.log(response.data.message)
            }
          }
      ).catch((error) => {
        Promise.reject(error)
      })
    },
    fetchUserInfo(userId) {
      this.$api.user.getUserById(userId).then(
          (response) => {
            if (response.data.code === '0000') {
              // set publisher user if request success.
              this.publisher = response.data.data
            } else {
              console.log(response.data.message)
            }
          }
      ).catch((error) => {
        Promise.reject(error)
      })
    },
    fetchComments(articleId, startPage, pageSize) {
      this.$api.comment.getCommentByArticlePaged(articleId, startPage, pageSize).then(
          (response) => {
            if (response.data.code === '0000') {
              // set comments if request success.
              this.comment = response.data.data.list
              this.pagination.total = response.data.data.total
              this.pagination.totalPages = response.data.data.pages
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
    this.fetchComments(this.$route.query.id, 1, 10) // request 1st page of comments from backend.
  }
}
</script>

<style scoped>

</style>
