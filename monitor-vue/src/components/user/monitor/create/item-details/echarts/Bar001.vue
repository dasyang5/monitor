<template>
  <div :id="'chart' + option.index" style="width: 100%;height: 100%;"></div>
</template>

<script>
    export default {
        name: "Bar001",
        data(){
            return{
                myChart: null
            }
        },
        props: {
            option: {}
        },
        methods: {
            resize(){
                if (this.myChart != null) {
                    this.myChart.resize();
                }
            },
            initOption(){
                //如果没有被编辑过，加入初始值
                if (!this.option.isEdit) {
                    this.option.itemOption = {
                        dataset: {
                            source: [
                                ['key', 'value'],
                                ['A', 41.1],
                                ['B', 86.5],
                                ['C', 34.1],
                                ['D', 24.1],
                                ['E', 11.1],
                                ['F', 13.1]
                            ]
                        },
                        title: {
                            show: true,
                            text: "Bar",
                            textStyle: {
                                color: '#000000',
                                fontStyle: 'normal',
                                fontWeight: 'normal',
                                fontSize: '22'
                            },
                            subtext: 'subText',
                            subtextStyle: {
                                color: '#000000',
                                fontStyle: 'normal',
                                fontWeight: 'normal',
                                fontSize: '12'
                            },
                            x: 'left'
                        },
                        grid: {
                            show: false,
                            backgroundColor: "rgba(0,0,0,0)",
                            borderColor: "#c0c0c0",
                            left: '10%',
                            top: '20%',
                            right: '10%',
                            bottom: '10%'
                        },
                        xAxis: {
                            type: 'category',
                            show: true,
                            splitLine: {
                                show: false
                            },
                            position: 'bottom',
                            name: '',
                            nameLocation: 'end',
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: "#000000",
                                    width: 1
                                }
                            }
                        },
                        yAxis: {
                            show: true,
                            splitLine: {
                                show: true
                            },
                            position: 'left',
                            name: '',
                            nameLocation: 'end',
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: "#000000",
                                    width: 1
                                }
                            }
                        },
                        series: [{
                            type: 'bar',
                            label: {
                                show: false,
                                position: 'top',
                                color: 'auto'
                            },
                            itemStyle: {
                                normal: {
                                    color: new this.$eCharts.graphic.LinearGradient(
                                        0, 0, 0, 1,
                                        [
                                            {offset: 0, color: 'rgba(14, 121, 222, 1)'},
                                            {offset: 0.25, color: 'rgba(14, 121, 222, 1)'},
                                            {offset: 0.5, color: 'rgba(14, 121, 222, 1)'},
                                            {offset: 0.75, color: 'rgba(14, 121, 222, 1)'},
                                            {offset: 1, color: 'rgba(14, 121, 222, 1)'}
                                        ]
                                    )
                                }
                            },
                            barWidth: "80%",
                            barMaxWidth: "100%",
                            barMinWidth: "1%"
                        }]
                    };
                }
            }
        },
        mounted() {
            this.option.mainOption.editType = 'bar-1';
            if (this.myChart != null) {
                this.myChart.dispose();
            }
            this.initOption();
            this.myChart = this.$eCharts.init(document.getElementById("chart" + this.option.index));
            this.myChart.setOption(this.option.itemOption);
        },
        watch: {
            option: {
                immediate:true,
                deep: true,
                handler(val){
                    if (this.myChart != null) {
                        this.myChart.setOption(this.option.itemOption);
                    }
                }
            }
        }
    }
</script>

<style scoped>

</style>
