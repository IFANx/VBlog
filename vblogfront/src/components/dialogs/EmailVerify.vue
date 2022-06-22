<template>
  <el-dialog title="验证邮箱" :visible="visible" :before-close="handleClose">
    <el-form :model="VerifyForm" ref="VerifyForm">
      <el-form-item prop="verifyCode">
        <el-input style="width: 200px;" placeholder="请输入邮件内包含的验证码" maxlength="6" v-model="VerifyForm.verifyCode" @input="activeButton"></el-input>
        <el-button type="primary"  :disabled="VerifyForm.disableCheck" @click="submitForm()">验证</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  name: 'EmailVerify',
  props: ['visible', 'disabled'],
  data () {
    return {
      VerifyForm: {
        verifyCode: '',
        disableCheck: true
      },
      labelPosition: 'right'
    }
  },
  methods: {
    handleClose (done) {
      this.$emit('update:visible', false)
      this.$refs.VerifyForm.resetFields()
      done()
    },
    activeButton (value) {
      this.VerifyForm.disableCheck = value.length !== 6
    },
    submitForm () {
      if (this.VerifyForm.verifyCode === '123456') {
        this.$message({
          message: '验证通过',
          type: 'success'
        })
        this.$emit('update:visible', false)
        this.$emit('update:disabled', false)
      }
    }
  }
}
</script>

<style scoped>

</style>
