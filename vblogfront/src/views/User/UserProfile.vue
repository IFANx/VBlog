<template>
    <SideBars></SideBars>
    <div class="container">
        <main class="userprofile">
            <div class="py-5 text-center">
                <img class="header-img" src="../../../src/assets/img/doge.png" alt="" width="150" height="150">
<!--                <h2>Profile</h2>-->
            </div>
            <div class="row g-5" >
                <div class="container-sm">
                    <form class="needs-validation" novalidate>
                        <div class="row g-3">
                            <div class="col-12">
                                <label for="account" class="form-label">Account</label>
                                <div class="input-group has-validation">
                                    <span class="input-group-text">#</span>
                                <input v-model="account" type="text" class="form-control" id="account" placeholder="account" disabled>
                                <div class="invalid-feedback">
                                    Valid Account is required.
                                </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="name" class="form-label">Username</label>
                                <div class="input-group has-validation">
                                    <span class="input-group-text">#</span>
                                    <input v-model="name" type="text" class="form-control" id="name" placeholder="Name" required>
                                    <div class="invalid-feedback">
                                        Your username is required.
                                    </div>
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="password" class="form-label">Password</label>
                                <div class="input-group has-validation">
                                    <span class="input-group-text">#</span>
                                    <input v-model="password" type="password" class="form-control" id="password" placeholder="password" required>
                                    <div class="invalid-feedback">
                                        Valid password is required.
                                    </div>
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="email" class="form-label">Email <span class="text-muted">(Optional)</span></label>
                                <input v-model="email" type="email" class="form-control" id="email" placeholder="you@example.com">
                                <div class="invalid-feedback">
                                    Please enter a valid email address for shipping updates.
                                </div>
                            </div>

                            <div class="col-md-6">
                                <label for="gender" class="form-label">gender</label>
                                <select v-model="gender" class="form-select" id="gender" required>
                                    <option value="">Choose...</option>
                                    <option>male</option>
                                    <option>female</option>
                                </select>
                                <div class="invalid-feedback">
                                    Please select a valid gender.
                                </div>
                            </div>

                            <div class="col-md-6">
                                <label for="birthday" class="form-label">birthday</label>
                                <select v-model="birthday" class="form-select" id="birthday" required>
                                    <option value="">Choose...</option>
                                    <option>2022-06-21</option>
                                </select>
                                <div class="invalid-feedback">
                                    Please provide a valid birthday.
                                </div>
                            </div>

                            <div class="mb-3">
                                <label for="description" class="form-label">Personal Description</label>
                                <textarea v-model="description" class="form-control" id="description" rows="3"></textarea>
                            </div>
                        </div>
                        <button class="w-100 btn btn-primary btn-lg" type="submit" @click="update">提交个人信息</button>
                    </form>
                </div>

            </div>

        </main>

        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">&copy; 2017–2021 Company Name</p>
        </footer>


    </div>

</template>

<script>
  import SideBars from '../SideBars/SideBars'
  export default {
    name: 'UserProfile',
    components: {SideBars},
    data () {
      return {
        id: '',
        account: '',
        password:'',
        name: '',
        email:'',
        gender:'',
        birthday:'',
        description:'',
      }
    },
    methods:{
      getuser(id) {
        this.$api.user.getUserById(id).then(
          (response) => {
            console.log(response) // debug output
            if (response.data.code === '0000') {
              let data=response.data.data
              // set article if request success.
              this.user = response.data.data
              this.account=data.account
              this.name=data.name
              this.password=data.password
              this.email=data.email
              this.gender=data.gender
              this.birthday=data.birthday.substr(0,10)
              this.description=data.description
            } else {
              console.log(response.data.message)
            }
          }
        ).catch((error) => {
          Promise.reject(error)
        })
      },
      update(){
        console.log(this.$store.getters.getUserId)
        this.$api.user.update(this.id=this.$store.getters.getUserId, this.password,this.name,this.email,this.gender,this.birthday,this.description).then(
          (res) => {
            if(res.data.code === '0000') {
              this.$router.push('/userprofile?id=',this.$store.getters.getUserId)
            } else {
              console.log(res.data.message)
            }
          }
        ).catch((error) => {
          Promise.reject(error)
        })
      }
    },
    mounted() {
      this.getuser(this.$route.query.id)
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
