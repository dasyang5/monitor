<template>
  <el-collapse-item title="Y轴" name="yAxis">
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
      <el-form-item label="显示Y轴">
        <el-switch v-model="option.yAxis.show"></el-switch>
      </el-form-item>
      <el-form-item label="显示网格">
        <el-switch v-model="option.yAxis.splitLine.show" :disabled="!option.yAxis.show"></el-switch>
      </el-form-item>
      <el-form-item label="显示轴线">
        <el-switch v-model="option.yAxis.axisLine.show" :disabled="!option.yAxis.show"></el-switch>
      </el-form-item>
      <el-form-item label="Y轴位置">
        <el-radio-group v-model="option.yAxis.position" :disabled="!option.yAxis.show">
          <el-radio :label="'left'">左侧</el-radio>
          <el-radio :label="'right'">右侧</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="Y轴名称">
        <el-input v-model="option.yAxis.name" placeholder="请输入标题" :disabled="!option.yAxis.show"></el-input>
      </el-form-item>
      <el-form-item label="名称位置">
        <el-radio-group v-model="option.yAxis.nameLocation" :disabled="!option.yAxis.show">
          <el-radio :label="'start'">起点</el-radio>
          <el-radio :label="'middle'">中间</el-radio>
          <el-radio :label="'end'">终点</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="Y轴颜色">
        <el-color-picker v-model="option.yAxis.axisLine.lineStyle.color" show-alpha :disabled="!option.yAxis.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="Y轴线宽">
        <el-input-number v-model="option.yAxis.axisLine.lineStyle.width" :min="0" :max="100"></el-input-number>
      </el-form-item>
    </el-form>
  </el-collapse-item>
</template>

<script>
    export default {
        name: "EChartsYAis",
        props: {
            option: Object
        }
    }
</script>

<style scoped>

</style>
