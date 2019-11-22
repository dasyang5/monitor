<template>
  <div :id="'chart' + option.index" style="width: 100%;height: 100%;"></div>
</template>

<script>
    export default {
        name: "Pie001",
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
                        color: ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83', '#ca8622', '#bda29a','#6e7074', '#546570', '#c4ccd3'],
                        title: {
                            show: true,
                            text: "Pie",
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
                        series: [{
                            type: 'pie',
                            center: ['50%','50%'],
                            radius: '55%',
                            label: {
                                show: true,
                                position: 'outside',
                                color: '#000000',
                                fontStyle: 'normal',
                                fontWeight: 'normal',
                                fontSize: 12
                            },
                            labelLine: {
                                show: true,
                                length: 10,
                                length2: 10,
                                lineStyle: {
                                    color: '#000000',
                                    width: 1,
                                    type: 'solid'
                                }
                            },
                            itemStyle: {
                                borderColor: 'rgba(0,0,0,0)',
                                borderWidth: 0
                            }
                        }]
                    };
                }
            }
        },
        mounted() {
            this.option.mainOption.editType = 'pie-1';
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
