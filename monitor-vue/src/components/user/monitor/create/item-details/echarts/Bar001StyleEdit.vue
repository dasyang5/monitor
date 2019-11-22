<template>
  <el-collapse v-model="activeName" accordion>
    <!-- 标题 -->
    <e-charts-title :option="option"></e-charts-title>
    <!-- 副标题 -->
    <e-charts-subtext :option="option"></e-charts-subtext>
    <!-- 网格 -->
    <e-charts-grid :option="option"></e-charts-grid>
    <!-- x轴 -->
    <e-charts-x-ais :option="option"></e-charts-x-ais>
    <!-- y轴 -->
    <e-charts-y-ais :option="option"></e-charts-y-ais>
    <!-- 柱形 -->
    <e-charts-series-bar :option="option"></e-charts-series-bar>
  </el-collapse>
</template>

<script>
    import EChartsTitle from "./config/EChartsTitle";
    import EChartsSubtext from "./config/EChartsSubtext";
    import EChartsGrid from "./config/EChartsGrid";
    import EChartsXAis from "./config/EChartsXAis";
    import EChartsYAis from "./config/EChartsYAis";
    import EChartsSeriesBar from "./config/EChartsSeriesBar";
    export default {
        name: "Bar001StyleEdit",
        data() {
            return {
                //默认展开的配置项
                activeName: 'title'
            };
        },
        props: {
            option: Object
        },
        components: {
            EChartsTitle,EChartsSubtext,EChartsGrid,EChartsXAis,EChartsYAis,EChartsSeriesBar
        }
    }
</script>

<style scoped>

</style>
