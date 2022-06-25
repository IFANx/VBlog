<template>
  <main>
    <div class="container" style="border-width: medium">
      <div class="row mb-2">
        <table>
          <thead class="toast-header">
          Search Article title like {{this.$route.query.fuzzyTitle}}
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
                  <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="stretched-link">Continue reading</a>

                </div>
                <div class="col-auto d-none d-lg-block">
                  <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                </div>
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
          </ul>
        </nav>

      </div>

    </div>
  </main>
</template>

<script>
export default {
  name: 'SearchArticleByTitleView',
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
    toTargetPage(pageIndex) {
      // low/upper bound check and fix.
      if (pageIndex > this.pagination.totalPages) pageIndex = this.pagination.totalPages
      if (pageIndex < 1) pageIndex = 1
      // to request paginated data.
      this.$api.article.getArticleByFuzzyTitlePaged(this.$route.query.fuzzyTitle, pageIndex, this.pagination.pageSize).then(
          (response) => {
            if (response.data.code === '0000') {
              this.currentPageArticles = response.data.data.list
              this.pagination.currentPage = pageIndex
            }
          }
      )
    },
    fetchMatchedArticlePaged (fuzzyTitle, startPage, pageSize) {
      this.$api.article.getArticleByFuzzyTitlePaged(fuzzyTitle, startPage,pageSize).then(
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
    }
  },
  mounted() {
    this.fetchMatchedArticlePaged(this.$route.query.fuzzyTitle,1,4)
  }
}
</script>

<style scoped>
/* stylelint-disable selector-list-comma-newline-after */

.blog-header {
  line-height: 1;
  border-bottom: 1px solid #e5e5e5;
}

.blog-header-logo {
  font-family: "Playfair Display", Georgia, "Times New Roman", serif/*rtl:Amiri, Georgia, "Times New Roman", serif*/;
  font-size: 2.25rem;
}

.blog-header-logo:hover {
  text-decoration: none;
}

h1, h2, h3, h4, h5, h6 {
  font-family: "Playfair Display", Georgia, "Times New Roman", serif/*rtl:Amiri, Georgia, "Times New Roman", serif*/;
}

.display-4 {
  font-size: 2.5rem;
}
@media (min-width: 768px) {
  .display-4 {
    font-size: 3rem;
  }
}

.nav-scroller {
  position: relative;
  z-index: 2;
  height: 2.75rem;
  overflow-y: hidden;
}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}

.nav-scroller .nav-link {
  padding-top: .75rem;
  padding-bottom: .75rem;
  font-size: .875rem;
}

.card-img-right {
  height: 100%;
  border-radius: 0 3px 3px 0;
}

.flex-auto {
  flex: 0 0 auto;
}

.h-250 { height: 250px; }
@media (min-width: 768px) {
  .h-md-250 { height: 250px; }
}

/* Pagination */
.blog-pagination {
  margin-bottom: 4rem;
}
.blog-pagination > .btn {
  border-radius: 2rem;
}

/*
 * Blog posts
 */
.blog-post {
  margin-bottom: 4rem;
}
.blog-post-title {
  margin-bottom: .25rem;
  font-size: 2.5rem;
}
.blog-post-meta {
  margin-bottom: 1.25rem;
  color: #727272;
}

/*
 * Footer
 */
.blog-footer {
  padding: 2.5rem 0;
  color: #727272;
  text-align: center;
  background-color: #f9f9f9;
  border-top: .05rem solid #e5e5e5;
}
.blog-footer p:last-child {
  margin-bottom: 0;
}

</style>
