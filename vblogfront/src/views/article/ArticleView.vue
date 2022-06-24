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
          <p class="blog-post-meta">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4" viewBox="0 0 16 16">
              <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>
            </svg>
            {{ this.$api.utils.parseTimeToDate(this.article.publishTime) }}
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                 class="bi bi-person-lines-fill" viewBox="0 0 16 16">
              <path
                  d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
            </svg>
            {{ this.publisher.name }}
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                 class="bi bi-chat-square-text-fill" viewBox="0 0 16 16">
              <path
                  d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-2.5a1 1 0 0 0-.8.4l-1.9 2.533a1 1 0 0 1-1.6 0L5.3 12.4a1 1 0 0 0-.8-.4H2a2 2 0 0 1-2-2V2zm3.5 1a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1h-9zm0 2.5a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1h-9zm0 2.5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5z"/>
            </svg>
            {{ this.article.commentCount }}
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill"
                 viewBox="0 0 16 16">
              <path
                  d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
            </svg>
            {{ this.article.likeCount }}
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill"
                 viewBox="0 0 16 16">
              <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
              <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
            </svg>
            {{ this.article.readCount }}
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
