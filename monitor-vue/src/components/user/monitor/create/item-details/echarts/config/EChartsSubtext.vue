<template>
  <el-collapse-item title="副标题" name="subtext">
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
      <el-form-item label="标题内容">
        <el-input v-model="option.title.subtext" placeholder="请输入标题" :disabled="!option.title.show"></el-input>
      </el-form-item>
      <el-form-item label="标题颜色">
        <el-color-picker v-model="option.title.subtextStyle.color" show-alpha :disabled="!option.title.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="字体大小">
        <el-input-number v-model="option.title.subtextStyle.fontSize" :min="1" :max="30" :disabled="!option.title.show"></el-input-number>
      </el-form-item>
      <el-form-item label="字体风格">
        <el-radio-group v-model="option.title.subtextStyle.fontStyle" :disabled="!option.title.show">
          <el-radio :label="'normal'">正常</el-radio>
          <el-radio :label="'italic'">斜体</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="字体样式">
        <el-radio-group v-model="option.title.subtextStyle.fontWeight" :disabled="!option.title.show">
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
        name: "EChartsSubtext",
        props: {
            option: Object
        }
    }
</script>

<style scoped>

</style>
