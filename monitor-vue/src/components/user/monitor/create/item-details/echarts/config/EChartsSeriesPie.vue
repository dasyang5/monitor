<template>
  <el-collapse-item title="扇形" name="series-pie">
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
      <el-form-item label="饼图半径">
        <el-input-number v-model="radius" :min="0" :max="100"></el-input-number>
      </el-form-item>
      <el-form-item label="显示标签">
        <el-switch v-model="option.series[0].label.show"></el-switch>
      </el-form-item>
      <el-form-item label="标签位置">
        <el-radio-group v-model="option.series[0].label.position" :disabled="!option.series[0].label.show">
          <el-radio :label="'outside'">内部</el-radio>
          <el-radio :label="'inside'">外部</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="标签颜色">
        <el-color-picker v-model="option.series[0].label.color" show-alpha
                         :disabled="!option.series[0].label.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="标签大小">
        <el-input-number v-model="option.series[0].label.fontSize" :min="1" :max="30"
                         :disabled="!option.series[0].label.show"></el-input-number>
      </el-form-item>
      <el-form-item label="标签风格">
        <el-radio-group v-model="option.series[0].label.fontStyle" :disabled="!option.series[0].label.show">
          <el-radio :label="'normal'">正常</el-radio>
          <el-radio :label="'italic'">斜体</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="标签样式">
        <el-radio-group v-model="option.series[0].label.fontWeight" :disabled="!option.series[0].label.show">
          <el-radio :label="'lighter'">变细</el-radio>
          <el-radio :label="'normal'">正常</el-radio>
          <el-radio :label="'bold'">加粗</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="标签引线">
        <el-switch v-model="option.series[0].labelLine.show"></el-switch>
      </el-form-item>
      <el-form-item label="引线长度">
        <el-input-number v-model="option.series[0].labelLine.length" :min="1" :max="30"
                         :disabled="!option.series[0].labelLine.show"></el-input-number>
      </el-form-item>
      <el-form-item label="">
        <el-input-number v-model="option.series[0].labelLine.length2" :min="1" :max="30"
                         :disabled="!option.series[0].labelLine.show"></el-input-number>
      </el-form-item>
      <el-form-item label="引线颜色">
        <el-color-picker v-model="option.series[0].labelLine.lineStyle.color" show-alpha
                         :disabled="!option.series[0].labelLine.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="引线宽度">
        <el-input-number v-model="option.series[0].labelLine.lineStyle.width" :min="1" :max="30"
                         :disabled="!option.series[0].labelLine.show"></el-input-number>
      </el-form-item>
      <el-form-item label="引线样式">
        <el-radio-group v-model="option.series[0].labelLine.lineStyle.type"
                        :disabled="!option.series[0].labelLine.show">
          <el-radio :label="'solid'">线条</el-radio>
          <el-radio :label="'dashed'">短线</el-radio>
          <el-radio :label="'dotted'">虚线</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="边框颜色">
        <el-color-picker v-model="option.series[0].itemStyle.borderColor" show-alpha></el-color-picker>
      </el-form-item>
      <el-form-item label="边框宽度">
        <el-input-number v-model="option.series[0].itemStyle.borderWidth" :min="0" :max="30"></el-input-number>
      </el-form-item>
    </el-form>
  </el-collapse-item>
</template>

<script>
    export default {
        name: "EChartsSeriesPie",
        props: {
            option: Object
        },
        computed: {
            radius: {
                get () {
                    try {
                        return parseFloat(this.option.series[0].radius.slice(0, -1));
                    }catch (e) {
                        return 1;
                    }
                },
                set (val) {
                    this.option.series[0].radius = val + "%";
                }
            }
        }
    }
</script>

<style scoped>

</style>
