<template>
    <SideBars></SideBars>
    <main>
    <div class="container" style="border-width: medium">
        <div class="row mb-2">
            <table>
                <thead class="toast-header">
                Like Articles
                </thead>
                <tbody>
                <tr v-for="item in likeArticle" v-bind:key="item.id">
                    <div class="col-md-12">
                        <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                            <div class="col p-4 d-flex flex-column position-static">
                                <!--                    <strong class="d-inline-block mb-2 text-primary">World</strong>-->
                                <h3 class="mb-0">{{item.title}}</h3>
                                <div class="mb-1 text-muted">{{item.publishTime}}</div>
                                <div class="mb-1 text-muted">{{item.content}}</div>
                                <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                                <a class="stretched-link">Continue reading</a>

                            </div>
                            <div class="col-auto d-none d-lg-block">
                                <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                            </div>
                        </div>
                    </div>
                </tr>
                </tbody>
            </table>


        </div>

    </div>
    </main>
</template>

<script>
  import SideBars from '../SideBars/SideBars'
  export default {
    name: 'Like',
    components: {SideBars},
    data () {
      return {
        likeArticle: {}
      }
    },
    methods: {
      getLikeListByUserId (id) {
        this.$api.like.getLikeListByUserId(id).then(
          (response) => {
            console.log(response) // debug output
            if (response.data.code === '0000') {
              this.likeArticle = response.data.data
              console.log(this.likeArticle)
            } else {
              console.log(response.data.message)
            }
          }
        ).catch((error) => {
          Promise.reject(error)
        })
      }
    }
    // mounted() {
    //   this.getLikeListByUserId(this.$route.query.id)
    // }
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
