<template>
  <el-collapse-item title="X轴" name="xAxis">
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
      <el-form-item label="显示X轴">
        <el-switch v-model="option.xAxis.show"></el-switch>
      </el-form-item>
      <el-form-item label="显示网格">
        <el-switch v-model="option.xAxis.splitLine.show" :disabled="!option.xAxis.show"></el-switch>
      </el-form-item>
      <el-form-item label="显示轴线">
        <el-switch v-model="option.xAxis.axisLine.show" :disabled="!option.xAxis.show"></el-switch>
      </el-form-item>
      <el-form-item label="X轴位置">
        <el-radio-group v-model="option.xAxis.position" :disabled="!option.xAxis.show">
          <el-radio :label="'bottom'">下方</el-radio>
          <el-radio :label="'top'">上方</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="X轴名称">
        <el-input v-model="option.xAxis.name" placeholder="请输入标题" :disabled="!option.xAxis.show"></el-input>
      </el-form-item>
      <el-form-item label="名称位置">
        <el-radio-group v-model="option.xAxis.nameLocation" :disabled="!option.xAxis.show">
          <el-radio :label="'start'">起点</el-radio>
          <el-radio :label="'middle'">中间</el-radio>
          <el-radio :label="'end'">终点</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="X轴颜色">
        <el-color-picker v-model="option.xAxis.axisLine.lineStyle.color" show-alpha :disabled="!option.xAxis.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="X轴线宽">
        <el-input-number v-model="option.xAxis.axisLine.lineStyle.width" :min="0" :max="100"></el-input-number>
      </el-form-item>
    </el-form>
  </el-collapse-item>
</template>

<script>
    export default {
        name: "EChartsXAis",
        props: {
            option: Object
        }
    }
</script>

<style scoped>

</style>
