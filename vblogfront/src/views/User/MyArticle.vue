<template>
    <SideBars></SideBars>
    <main>
        <div class="container" style="border-width: medium">
            <div class="row mb-2">
                <table>
                    <thead class="toast-header">
                   My Articles {{this.$store.getters.getUserId}}
                    </thead>
                    <tbody>
                    <tr v-for="item in currentPageArticles" v-bind:key="item.id">
                        <div class="col-md-12">
                            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                                <div class="col p-4 d-flex flex-column position-static">
                                    <!--                    <strong class="d-inline-block mb-2 text-primary">World</strong>-->
                                    <h3 class="mb-0">{{item.title}}</h3>
                                    <div class="mb-1 text-muted">{{item.publishTime}}</div>
                                    <div class="mb-1 text-muted">{{item.content}}</div>
                                    <a class="stretched-link" @click="jumpToArticlePage(item.id)">Continue reading</a>

                                </div>
<!--                                <div class="col-auto d-none d-lg-block">-->
<!--&lt;!&ndash;                                    <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>&ndash;&gt;-->
<!--                                </div>-->
                            </div>
                        </div>
                    </tr>
                    </tbody>
                </table>

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
                        <button type="button" class="btn btn-primary" @click="add">发布</button>
                    </ul>
                </nav>

            </div>

        </div>
    </main>
</template>

<script>
  import SideBars from '../SideBars/SideBars'
  export default {
    name: 'MyArticle',
    components: {SideBars},
    data () {
      return {
        currentPageArticles: {},
        pagination: {
          currentPage: 1,
          pageSize: 4,
          total: 0,
          totalPages: 0
        }
      }
    },
    methods: {
      jumpToArticlePage(articleId) {
        this.$router.push('/article?id=' + articleId)
      },
      toTargetPage(pageIndex) {
        // low/upper bound check and fix.
        if (pageIndex > this.pagination.totalPages) pageIndex = this.pagination.totalPages
        if (pageIndex < 1) pageIndex = 1
        // to request paginated data.
        this.$api.article.getArticlesByUserIdPaged(this.$store.getters.getUserId, pageIndex, this.pagination.pageSize).then(
          (response) => {
            if (response.data.code === '0000') {
              this.currentPageArticles = response.data.data.list
              this.pagination.currentPage = pageIndex
            }
          }
        )
      },
      fetchMatchedArticlePaged (id, startPage, pageSize) {
        this.$api.article.getArticlesByUserIdPaged(this.$store.getters.getUserId, startPage,pageSize).then(
          (response) => {
            console.log(response) // debug output
            if (response.data.code === '0000') {
              this.currentPageArticles = response.data.data.list
              this.pagination.total = response.data.data.total
              this.pagination.totalPages = response.data.data.pages
            } else {
              console.log(response.data.message)
            }
          }
        ).catch((error) => {
          Promise.reject(error)
        })
      },
      add(){
        this.$router.push('/addarticle')
      }
    },
    mounted() {
      this.fetchMatchedArticlePaged(this.$store.getters.getUserId,1,4)
    }
  }
</script>

<style scoped>
    html,
    body {
        height: 100%;
    }

    body {
        display: flex;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
    }

    .userprofile {
        width: 100%;
        max-width: 430px;
        padding: 10px;
        margin: auto;
    }

    .form-signin .checkbox {
        font-weight: 400;
    }
    .header-img{
        object-fit: cover;/*图片完全填充*/
        /*object-position: center;*//*设置头像选取照片的哪个区域object-position: x y*/
        border-radius: 50%;/*头像框圆形设置*/
    }
</style>
