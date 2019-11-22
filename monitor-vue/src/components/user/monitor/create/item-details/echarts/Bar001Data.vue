<template>
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="dataOption" size="mini">
        <el-form-item label="数据类型">
            <el-select v-model="dataOption.type" placeholder="请选择">
                <el-option
                    v-for="item in selects"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: "Bar001Data",
        data() {
            return {
                selects: [
                    {value: 'fixed',label: '固定数据'},
                    {value: 'request',label: '接口请求'},
                    {value: 'database',label: 'SQL查询'}
                    ],
                exampleData: [
                    ['key', 'value'],
                    ['A', 41.1],
                    ['B', 86.5],
                    ['C', 34.1],
                    ['D', 24.1],
                    ['E', 11.1],
                    ['F', 13.1]
                ]
            }
        },
        props: {
            dataOption: Object
        }
    }
</script>

<style scoped>

</style>
