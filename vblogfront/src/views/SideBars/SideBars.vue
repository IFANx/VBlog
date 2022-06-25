<template>
        <main style="float:left">
            <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 240px;">
                <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
                    <span class="fs-4">Vblog</span>
                </a>
                <hr>
                <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item">
                        <a href="#" class="nav-link active" aria-current="page">
<!--                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"/></svg>-->
                            主页
                        </a>
                    </li>
                    <li>
                        <a class="nav-link text-white" @click="profile">
                                个人信息
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link text-white">
                            我的文章
                        </a>
                    </li>
                    <li>
                        <a class="nav-link text-white" @click="like">
                            我的点赞
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link text-white">
                            我的收藏
                        </a>
                    </li>
                </ul>
                <hr>
<!--                <div class="dropdown">-->
<!--                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">-->
<!--                        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">-->
<!--                        <strong>mdo</strong>-->
<!--                    </a>-->
<!--                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">-->
<!--                        <li><a class="dropdown-item" href="#">New project...</a></li>-->
<!--                        <li><a class="dropdown-item" href="#">Settings</a></li>-->
<!--                        <li><a class="dropdown-item" href="#">Profile</a></li>-->
<!--                        <li><hr class="dropdown-divider"></li>-->
<!--                        <li><a class="dropdown-item" href="#">Sign out</a></li>-->
<!--                    </ul>-->
<!--                </div>-->
            </div>
        </main>
</template>

<script>
  export default {
    name: 'SideBars',
    data () {
      return {
        likeArticle: {}
      }
    },
    methods: {
      profile() {
        console.log(this.$store.getters.getUserId)
          this.$api.user.getUserById(this.$store.getters.getUserId).then(
            (response) => {
              console.log(response) // debug output
              if (response.data.code === '0000') {
                let data = response.data.data
                // set article if request success.
                this.user = response.data.data
                this.account = data.account
                this.name = data.name
                this.password = data.password
                this.email = data.email
                this.gender = data.gender
                this.birthday = data.birthday.substr(0, 10)
                this.description = data.description
                this.portrait = data.portrait
                this.$router.push('/userprofile?id='+this.$store.getters.getUserId)
              } else {
                console.log(response.data.message)
              }
            }
          ).catch((error) => {
            Promise.reject(error)
          })
        },
         like() {
        console.log(this.$store.getters.getUserId)
        this.$api.like.getLikeListByUserId(this.$store.getters.getUserId).then(
          (response) => {
            console.log(response) // debug output
            if (response.data.code === '0000') {
              this.likeArticle = response.data.data
              this.$router.push('/like?id='+this.$store.getters.getUserId)
              console.log(this.likeArticle)
            } else {
              console.log(response.data.message)
            }
          }
        ).catch((error) => {
          Promise.reject(error)
        })
      }
    },
    // mounted() {
    //   this.getLikeListByUserId(this.$route.query.id)
    // }
      }


</script>

<style scoped>
    main {
        display: flex;
        flex-wrap: nowrap;
        height: 100vh;
        /*height: -webkit-fill-available;*/
        max-height: 100vh;
        overflow-x: auto;
        overflow-y: hidden;
    }

    .b-example-divider {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
    }

    .bi {
        vertical-align: -.125em;
        pointer-events: none;
        fill: currentColor;
    }

    .dropdown-toggle { outline: 0; }

    .nav-flush .nav-link {
        border-radius: 0;
    }

    .btn-toggle {
        display: inline-flex;
        align-items: center;
        padding: .25rem .5rem;
        font-weight: 600;
        color: rgba(0, 0, 0, .65);
        background-color: transparent;
        border: 0;
    }
    .btn-toggle:hover,
    .btn-toggle:focus {
        color: rgba(0, 0, 0, .85);
        background-color: #d2f4ea;
    }

    .btn-toggle::before {
        width: 1.25em;
        line-height: 0;
        content: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='rgba%280,0,0,.5%29' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M5 14l6-6-6-6'/%3e%3c/svg%3e");
        transition: transform .35s ease;
        transform-origin: .5em 50%;
    }

    .btn-toggle[aria-expanded="true"] {
        color: rgba(0, 0, 0, .85);
    }
    .btn-toggle[aria-expanded="true"]::before {
        transform: rotate(90deg);
    }

    .btn-toggle-nav a {
        display: inline-flex;
        padding: .1875rem .5rem;
        margin-top: .125rem;
        margin-left: 1.25rem;
        text-decoration: none;
    }
    .btn-toggle-nav a:hover,
    .btn-toggle-nav a:focus {
        background-color: #d2f4ea;
    }

    .scrollarea {
        overflow-y: auto;
    }

    .fw-semibold { font-weight: 600; }
    .lh-tight { line-height: 1.25; }

</style>
