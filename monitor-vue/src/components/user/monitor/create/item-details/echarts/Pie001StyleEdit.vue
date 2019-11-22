<template>
  <el-collapse v-model="activeName" accordion>
    <!-- 标题 -->
    <e-charts-title :option="option"></e-charts-title>
    <!-- 副标题 -->
    <e-charts-subtext :option="option"></e-charts-subtext>
    <!-- 扇形 -->
    <e-charts-series-pie :option="option"></e-charts-series-pie>
  </el-collapse>
</template>

<script>
    import EChartsTitle from "./config/EChartsTitle";
    import EChartsSubtext from "./config/EChartsSubtext";
    import EChartsSeriesPie from "./config/EChartsSeriesPie";
    export default {
        name: "Pie001StyleEdit",
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
            EChartsTitle,EChartsSubtext,EChartsSeriesPie
        }
    }
</script>

<style scoped>

</style>
