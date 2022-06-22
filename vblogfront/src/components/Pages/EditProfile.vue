<template>
  <el-container style="margin-top: -60px;">
    <logined-header></logined-header>
    <el-main style="margin-top: 10rem;">
      <el-row type="flex" justify="center">
        <el-col :span="12">
          <el-form :label-position="labelPosition" label-width="80px" :model="UserInfo" status-icon :rules="rules">
            <el-form-item label="用户名">
              <el-input v-model="UserInfo.username" placeholder="新的昵称"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
              <el-input :disabled="disabled" v-model="UserInfo.email"></el-input>
              <span>为确保是本人操作，若要更换邮箱请</span>
              <el-link type="primary" @click="changeState">点击验证</el-link><br>
              <span>我们将向您发送一封含有验证码的邮件</span>
            </el-form-item>
            <div style="margin-top: 40px;"></div>
            <email-verify :visible.sync="VerifyDialogVisible" :disabled.sync="newEmail"></email-verify>
            <el-form-item label="新邮箱" prop="newemail">
              <el-tooltip v-if="newEmail" class="item" effect="dark" content="请完成上方验证后输入" placement="top">
                <el-input placeholder="新的邮箱" :disabled="newEmail"></el-input>
              </el-tooltip>
              <el-input v-else placeholder="新的邮箱" v-model="UserInfo.newemail"></el-input>
            </el-form-item>
            <el-form-item>
              <el-link type="primary" :disabled="verifyaga">点击验证</el-link>
            </el-form-item>
            <el-form-item>
              <el-button type="info">取消</el-button>
              <el-button type="primary">保存修改</el-button>
            </el-form-item>
          </el-form>
          <div style="margin-top:50px;"></div>
          <el-link type="primary">高级</el-link>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
import LoginedHeader from '@/components/headers/LoginedHeader'
import EmailVerify from '@/components/dialogs/EmailVerify'
export default {
  name: 'EditProfile',
  components: {LoginedHeader, EmailVerify},
  data () {
    var checkEmail = (rule, value, callback) => {
      console.log('value' + ' = ' + value)
      if (!value) {
        return callback(new Error('邮箱不能为空'))
      } else {
        // eslint-disable-next-line no-useless-escape
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/
        var isok = reg.test(value)
        if (!isok) {
          return callback(new Error('邮箱格式错误'))
        } else {
          console.log('verifyaga' + ' ' + ' = ' + this.verifyaga)
          this.verifyaga = false
        }callback()
      }
    }
    return {
      labelPosition: 'right',
      UserInfo: {
        username: '',
        email: '',
        newemail: ''
      },
      rules: {
        newemail: [
          { validator: checkEmail, trigger: 'change' }
        ]
      },
      newEmail: true,
      verifyaga: true,
      codeVerify: '',
      VerifyDialogVisible: false,
      disabled: true
    }
  },
  mounted () {
    this.getUserInfo()
  },
  methods: {
    getUserInfo () {
      var userinfo = JSON.parse(localStorage.getItem('UserInfo'))
      this.UserInfo.username = userinfo.data.uname
      this.UserInfo.email = userinfo.data.uemail
    },
    changeState () {
      this.VerifyDialogVisible = true
    }
  }
}
</script>

<style scoped>

</style>
