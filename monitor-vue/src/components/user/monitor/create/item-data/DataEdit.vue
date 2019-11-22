<template>
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="dataOption" size="mini">
        <el-form-item label="数据类型">
            <el-select v-model="dataOption.type" placeholder="请选择" @change="initDataOption">
                <el-option
                    v-for="item in selects"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
        </el-form-item>
        <component :is="dataComponents[dataOption.type]" :dataOption="dataOption" @callBack="callBack"></component>
    </el-form>
</template>

<script>
    import FixedData from "./fixed/FixedData";
    import RequestData from "./request/RequestData";
    export default {
        name: "DataEdit",
        data() {
            return {
                selects: [
                    {value: 'fixed',label: '固定数据'},
                    {value: 'request',label: '接口请求'},
                    {value: 'database',label: 'SQL查询'}
                ],
                dataComponents: {
                    'fixed': FixedData,
                    'request': RequestData
                }
            }
        },
        props: {
            dataOption: Object
        },
        methods: {
            initDataOption() {
                this.dataOption.detail = {};
            },
            callBack(){
                this.$emit('calLBack');
            }
        }
    }
</script>

<style scoped>

</style>
