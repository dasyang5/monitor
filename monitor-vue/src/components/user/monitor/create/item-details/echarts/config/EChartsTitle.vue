<template>
  <el-collapse-item title="标题" name="title">
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
      <el-form-item label="显示标题">
        <el-switch v-model="option.title.show"></el-switch>
      </el-form-item>
      <el-form-item label="标题内容">
        <el-input v-model="option.title.text" placeholder="请输入标题" :disabled="!option.title.show"></el-input>
      </el-form-item>
      <el-form-item label="标题位置">
        <el-radio-group v-model="option.title.x" :disabled="!option.title.show">
          <el-radio :label="'left'">靠左</el-radio>
          <el-radio :label="'center'">中间</el-radio>
          <el-radio :label="'right'">靠右</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="标题颜色">
        <el-color-picker v-model="option.title.textStyle.color" show-alpha :disabled="!option.title.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="字体大小">
        <el-input-number v-model="option.title.textStyle.fontSize" :min="1" :max="30" :disabled="!option.title.show"></el-input-number>
      </el-form-item>
      <el-form-item label="字体风格">
        <el-radio-group v-model="option.title.textStyle.fontStyle" :disabled="!option.title.show">
          <el-radio :label="'normal'">正常</el-radio>
          <el-radio :label="'italic'">斜体</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="字体样式">
        <el-radio-group v-model="option.title.textStyle.fontWeight" :disabled="!option.title.show">
          <el-radio :label="'lighter'">变细</el-radio>
          <el-radio :label="'normal'">正常</el-radio>
          <el-radio :label="'bold'">加粗</el-radio>
        </el-radio-group>
      </el-form-item>
    </el-form>
  </el-collapse-item>
</template>

<script>
    export default {
        name: "EChartsTitle",
        props: {
            option: Object
        }
    }
</script>

<style scoped>

</style>
