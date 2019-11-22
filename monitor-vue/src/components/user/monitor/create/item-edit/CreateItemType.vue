<template>
  <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
    <el-form-item label="组件类型">
      <el-cascader
        expand-trigger="hover"
        :options="items"
        v-model="option.type"
        @change="handleChange">
      </el-cascader>
    </el-form-item>
    <el-form-item label="边框大小">
      <el-input-number v-model="borderWidth" :min="0" :max="20"></el-input-number>
    </el-form-item>
    <el-form-item label="边框样式">
      <el-radio-group v-model="option.style.borderStyle">
        <el-radio :label="'solid'">线条</el-radio>
        <el-radio :label="'dashed'">短线</el-radio>
        <el-radio :label="'dotted'">虚线</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="边框颜色">
      <el-color-picker v-model="option.style.borderColor" show-alpha></el-color-picker>
    </el-form-item>
    <el-form-item label="边框圆角">
      <el-input-number v-model="borderRadius" :min="0" :max="40"></el-input-number>
    </el-form-item>
    <el-form-item label="背景颜色">
      <el-color-picker v-model="option.style.backgroundColor" show-alpha></el-color-picker>
    </el-form-item>
      <el-form-item label="内边距">
          <el-input-number v-model="padding" :min="0" :max="100"></el-input-number>
      </el-form-item>
  </el-form>
</template>

<script>
    export default {
        name: "CreateItemType",
        data() {
            return {
                items: [
                    {
                    value: 'chart',
                    label: '图表',
                    children: [
                        {
                            value: 'bar',
                            label: '柱状图',
                            children: [{
                                value: 'bar-1',
                                label: '柱状图-1'
                            }, {
                                value: 'bar-2',
                                label: '柱状图-2'
                            }]
                        },
                        {
                            value: 'pie',
                            label: '饼图',
                            children: [{
                                value: 'pie-1',
                                label: '饼图-1'
                            }]
                        }
                        ,
                        {
                            value: 'line',
                            label: '折线图',
                            children: [{
                                value: 'line-1',
                                label: '折线图-1'
                            }]
                        }]
                },
                    {
                    value: 'title',
                    label: '标题',
                    children: [{
                        value: 'title-1',
                        label: '标题1'
                    }, {
                        value: 'title-2',
                        label: '标题2'
                    }, {
                        value: 'title-3',
                        label: '标题3'
                    }]
                }
                ]
            };
        },
        props: {
            option: {}
        },
        methods: {
            handleChange(value) {
                this.$root.monitorOption.isEdit = false;
            }
        },
        computed: {
            borderWidth: {
                get(){
                    try {
                        return parseFloat(this.option.style.borderWidth.slice(0, -1));
                    }catch (e) {
                        return 0
                    }
                },
                set(val){
                    this.option.style.borderWidth = val + 'px';
                }
            },
            borderRadius: {
                get(){
                    try {
                        return parseFloat(this.option.style.borderRadius.slice(0, -1));
                    }catch (e) {
                        return 0
                    }
                },
                set(val){
                    this.option.style.borderRadius = val + 'px';
                }
            },
            padding: {
                get() {
                    try {
                        return parseFloat(this.option.outStyle.padding.slice(0, -2));
                    } catch (e) {
                        return 1;
                    }
                },
                set(val) {
                    this.option.outStyle.padding = val + "px";
                }
            }
        }
    };
</script>

<style scoped>

</style>
