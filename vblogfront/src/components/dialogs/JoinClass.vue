<template>
  <el-dialog title="加入班级" :visible="visible" :before-close="handleClose">
    <el-dialog width="35%" title="加入班级" :visible.sync="innerVisible" append-to-body>
      <el-form :model="joinClass" status-icon :rules="rules" ref="joinClass">
        <el-form-item prop="classNo" v-model="joinClass.classNo">
          <el-input placeholder="请输入班级编码"></el-input>
        </el-form-item>
        <el-form-item prop="classNo" v-model="joinClass.classPass">
          <el-input placeholder="请输入班级密码"></el-input>
        </el-form-item>
        <el-form-item style="text-align: center">
          <el-button type="primary" round  @click="submitForm('joinClass')">加入</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-form ref="classList" :model="classList" :inline="true">
      <el-form-item>
        <el-select v-model="classList.list" placeholder="请选择班级">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item><el-button type="primary">加入</el-button></el-form-item>
    </el-form>
    <div slot="footer"><el-link type="primary" @click="innerVisible = true">未找到班级？请使用精准查询</el-link></div>
  </el-dialog>
</template>

<script>
export default {
  name: 'JoinClass',
  props: ['visible'],
  data () {
    var checkClassCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('班级编码不能为空'))
      } else {
        callback()
      }
    }
    var classPass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('班级密码不能为空'))
      } else {
        callback()
      }
    }
    return {
      innerVisible: false,
      classList: {
        list: ''
      },
      joinClass: {
        classNo: '',
        classPass: ''
      },
      rules: {
        classNo: [
          { validator: checkClassCode, trigger: 'blur' }
        ],
        classPass: [
          { validator: classPass, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
        }
      })
    },
    handleClose (done) {
      this.$emit('update:visible', false)
      this.$refs.joinClass.clearValidate()
      this.$refs.joinClass.resetFields()
      done()
    }
  }
}
</script>

<style scoped>

</style>
