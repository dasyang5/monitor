<template>
  <el-collapse-item title="柱形" name="series-bar">
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
      <el-form-item label="柱形宽度">
        <el-input-number v-model="barWidth" :min="1" :max="100"></el-input-number>
      </el-form-item>
      <el-form-item label="最大宽度">
        <el-input-number v-model="barMaxWidth" :min="1" :max="100"></el-input-number>
      </el-form-item>
      <el-form-item label="最小宽度">
        <el-input-number v-model="barMinWidth" :min="1" :max="100"></el-input-number>
      </el-form-item>
      <el-form-item label="柱形颜色">
        <el-color-picker v-model="option.series[0].itemStyle.normal.color.colorStops[0].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].itemStyle.normal.color.colorStops[1].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].itemStyle.normal.color.colorStops[2].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].itemStyle.normal.color.colorStops[3].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].itemStyle.normal.color.colorStops[4].color" show-alpha></el-color-picker>
      </el-form-item>
      <el-form-item label="显示数值">
        <el-switch v-model="option.series[0].label.show"></el-switch>
      </el-form-item>
      <el-form-item label="数值位置">
        <el-radio-group v-model="option.series[0].label.position" :disabled="!option.series[0].label.show">
          <el-radio :label="'top'">上方</el-radio>
          <el-radio :label="'insideTop'">内上</el-radio>
          <el-radio :label="'bottom'">下方</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="">
        <el-radio-group v-model="option.series[0].label.position" :disabled="!option.series[0].label.show">
          <el-radio :label="'left'">左方</el-radio>
          <el-radio :label="'inside'">内部</el-radio>
          <el-radio :label="'right'">右方</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="数值颜色">
        <el-color-picker v-model="option.series[0].label.color" show-alpha :disabled="!option.series[0].label.show"></el-color-picker>
      </el-form-item>
    </el-form>
  </el-collapse-item>
</template>

<script>
    export default {
        name: "EChartsSeriesBar",
        props: {
            option: Object
        },
        computed: {
            barWidth:{
                get () {
                    try {
                        return parseFloat(this.option.series[0].barWidth.slice(0, -1));
                    }catch (e) {
                        return 1;
                    }
                },
                set (val) {
                    this.option.series[0].barWidth = val + "%";
                }
            },
            barMaxWidth:{
                get () {
                    try {
                        return parseFloat(this.option.series[0].barMaxWidth.slice(0, -1));
                    }catch (e) {
                        return 1;
                    }
                },
                set (val) {
                    this.option.series[0].barMaxWidth = val + "%";
                }
            },
            barMinWidth:{
                get () {
                    try {
                        return parseFloat(this.option.series[0].barMinWidth.slice(0, -1));
                    }catch (e) {
                        return 1;
                    }
                },
                set (val) {
                    this.option.series[0].barMinWidth = val + "%";
                }
            }
        }
    }
</script>

<style scoped>

</style>
