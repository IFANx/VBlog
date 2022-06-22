<template>
  <el-dialog width="35%" title="欢迎注册" :visible="visible"
             :close-on-click-modal="clickModal"
             :close-on-press-escape="pressEscape"
             :before-close="handleClose">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm">
      <el-form-item prop="email">
        <el-input :disabled="disabledAfter" class="el-input" placeholder="请输入邮箱" v-model="ruleForm.email" type="email"></el-input><br>
      </el-form-item>
      <el-form-item prop="username">
        <el-input :disabled="disabledAfter" class="el-input" placeholder="请输入昵称" v-model="ruleForm.username"></el-input><br>
      </el-form-item>
      <el-form-item prop="pass">
        <el-input :disabled="disabledAfter" class="el-input" placeholder="请输入密码" show-password v-model="ruleForm.pass"></el-input><br>
      </el-form-item>
      <el-form-item prop="checkPass">
        <el-input :disabled="disabledAfter" class="el-input" placeholder="再次确认密码" show-password v-model="ruleForm.checkPass"></el-input><br>
      </el-form-item>
      <el-form-item prop="MailCode">
        <el-input placeholder="请输入验证码" class="code-verify" :disabled="disableCode" maxlength="6" v-model="ruleForm.MailCode" @input="activeButton"></el-input>
        <el-button class="VerifyButton" type="primary" content="content" :disabled="IsTimeOver" @click="submitForm('ruleForm')">{{content}}</el-button>
      </el-form-item>
    <div style="margin-top: 20px">
      <el-radio v-model="radio" label="0">学生</el-radio>
      <el-radio v-model="radio" label="1">班长</el-radio>
    </div>
    <el-button type="primary" plain @click="signs" :disabled="disabled" style="margin-top: 20px; width: 300px; margin-bottom: 20px">注册</el-button>
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  name: 'SignUpDialog',
  props: ['visible'],
  data () {
    var checkEmail = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('邮箱不能为空'))
      } else {
        // eslint-disable-next-line no-useless-escape
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/
        var isok = reg.test(value)
        if (!isok) {
          return callback(new Error('邮箱格式错误'))
        }callback()
      }
    }
    var checkName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('用户名不能为空'))
      } else {
        callback()
      }
    }
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      ruleForm: {
        email: '',
        username: '',
        pass: '',
        checkPass: '',
        MailCode: ''
      },
      rules: {
        email: [
          { validator: checkEmail, trigger: 'blur' }
        ],
        username: [
          { validator: checkName, trigger: 'blur' }
        ],
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      },
      content: '获取验证码',
      radio: '0',
      disabled: true,
      disabledAfter: false,
      IsTimeOver: false,
      TimeTotal: 10,
      clickModal: false,
      pressEscape: false,
      disableCode: true
    }
  },
  methods: {
    /* 提交表单，发送验证码 */
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.disabledAfter = true
          this.IsTimeOver = true
          this.axios.post('/user/send?uemail=' + this.ruleForm.email).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: res.data.msg,
                type: 'success'
              })
              this.disableCode = false
            } else {
              this.$message.error('发送失败，请重试')
            }
          }).catch(error => {
            console.log(error)
            this.$message.error('发送失败，请检查网络')
          })
          this.content = this.TimeTotal + 's后重试'
          let clock = window.setInterval(() => {
            this.TimeTotal--
            this.content = this.TimeTotal + 's后重试'
            if (this.TimeTotal < 0) {
              window.clearInterval(clock)
              this.content = '获取验证码'
              this.TimeTotal = 10
              this.IsTimeOver = false // 这里重新开启
            }
          }, 1000)
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    activeButton (value) {
      this.disabled = value.length !== 6
    },
    handleClose (done) {
      this.disabledAfter = false
      this.$confirm('离成功就差一步啦，确认关闭？')
        .then(_ => {
          this.$emit('update:visible', false)
          /* 关闭弹窗清除表单信息 */
          this.$refs.ruleForm.clearValidate()
          this.$refs.ruleForm.resetFields()
          done()
        })
        .catch(_ => {})
    },
    signs () {
      this.axios.post('/user/signUp?uemail=' + this.ruleForm.email + '&uname=' + this.ruleForm.username + '&pwd=' + this.ruleForm.pass + '&urole=' +
        this.radio + '&code=' + this.ruleForm.MailCode).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '注册成功, 请登录',
            type: 'success'
          })
          this.$router.go(0)
        } else if (res.data.code === '4100') {
          this.$message.error('验证码错误或过期')
        } else if (res.data.code === '4300') {
          this.$message.error('新增用户失败')
        }
      }).catch(error => {
        console.log(error)
        this.$message.error('注册失败，请检查网络是否正常，请勿使用同一邮箱注册多个账号')
      })
    }
  }
}
</script>

<style scoped>
  .el-input {
    margin-top: 10px;
  }
  .code-verify{
    margin-top: 10px;
    width: 150px;
  }
  .VerifyButton{
    width: 120px;
    margin-left: 25px;
  }
</style>
