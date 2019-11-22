<template>
  <el-collapse-item title="折线" name="series-line">
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
<!--------------------------------------------------------------------------------------------------------------------->
      <el-form-item label="折线颜色">
        <el-color-picker v-model="option.series[0].lineStyle.color.colorStops[0].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].lineStyle.color.colorStops[1].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].lineStyle.color.colorStops[2].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].lineStyle.color.colorStops[3].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].lineStyle.color.colorStops[4].color" show-alpha></el-color-picker>
      </el-form-item>
      <el-form-item label="折线宽度">
        <el-input-number v-model="option.series[0].lineStyle.width" :min="1" :max="30"></el-input-number>
      </el-form-item>
      <el-form-item label="折线样式">
        <el-radio-group v-model="option.series[0].lineStyle.type">
          <el-radio :label="'solid'">线条</el-radio>
          <el-radio :label="'dashed'">短线</el-radio>
          <el-radio :label="'dotted'">虚线</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="折线面积">
        <el-color-picker v-model="option.series[0].areaStyle.color.colorStops[0].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].areaStyle.color.colorStops[1].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].areaStyle.color.colorStops[2].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].areaStyle.color.colorStops[3].color" show-alpha></el-color-picker>
        <el-color-picker v-model="option.series[0].areaStyle.color.colorStops[4].color" show-alpha></el-color-picker>
      </el-form-item>
      <el-form-item label="平滑折线">
        <el-switch v-model="option.series[0].smooth"></el-switch>
      </el-form-item>
<!--------------------------------------------------------------------------------------------------------------------->
      <el-form-item label="显示拐点">
        <el-switch v-model="option.series[0].showSymbol"></el-switch>
      </el-form-item>
      <el-form-item label="拐点颜色">
        <el-color-picker v-model="option.series[0].itemStyle.color" show-alpha></el-color-picker>
      </el-form-item>
      <el-form-item label="拐点形状">
        <el-radio-group v-model="option.series[0].symbol" :disabled="!option.series[0].showSymbol">
          <el-radio :label="'emptyCircle'">空心圆</el-radio>
          <el-radio :label="'circle'">实心圆</el-radio>
          <el-radio :label="'rect'">正方形</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="">
        <el-radio-group v-model="option.series[0].symbol" :disabled="!option.series[0].showSymbol">
          <el-radio :label="'triangle'">三角形</el-radio>
          <el-radio :label="'pin'">大头针</el-radio>
          <el-radio :label="'diamond'">菱形</el-radio>
        </el-radio-group>
      </el-form-item>
<!--------------------------------------------------------------------------------------------------------------------->
      <el-form-item label="显示数值">
        <el-switch v-model="option.series[0].label.show"></el-switch>
      </el-form-item>
      <el-form-item label="数值位置">
        <el-radio-group v-model="option.series[0].label.position" :disabled="!option.series[0].label.show">
          <el-radio :label="'top'">上方</el-radio>
          <el-radio :label="'left'">左边</el-radio>
          <el-radio :label="'right'">右边</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="">
        <el-radio-group v-model="option.series[0].label.position" :disabled="!option.series[0].label.show">
          <el-radio :label="'bottom'">下方</el-radio>
          <el-radio :label="'inside'">内部</el-radio>
          <el-radio :label="'insideTop'">内上</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="数值颜色">
        <el-color-picker v-model="option.series[0].label.color" show-alpha :disabled="!option.series[0].label.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="字体大小">
        <el-input-number v-model="option.series[0].label.fontSize" :min="1" :max="30" :disabled="!option.series[0].label.show"></el-input-number>
      </el-form-item>
      <el-form-item label="字体风格">
        <el-radio-group v-model="option.series[0].label.fontStyle" :disabled="!option.series[0].label.show">
          <el-radio :label="'normal'">正常</el-radio>
          <el-radio :label="'italic'">斜体</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="字体样式">
        <el-radio-group v-model="option.series[0].label.fontWeight" :disabled="!option.series[0].label.show">
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
        name: "EChartsSeriesLine",
        props: {
            option: Object
        }
    }
</script>

<style scoped>

</style>
