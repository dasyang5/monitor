<template>
    <div>
        <el-form-item label="组件数据">
            <el-input
                type="textarea"
                :rows="4"
                placeholder="请输入数据内容"
                v-model="text">
            </el-input>
        </el-form-item>
        <el-form-item label="">
            <div>
                <el-button @click="validateConfig" type="primary" :loading="checking">校验配置信息</el-button>
                <label style="font-size: 13px;color: gray">配置信息只有通过校验才会生效</label>
            </div>
            <div>
                <label>{{error}}</label>
            </div>
        </el-form-item>
    </div>
</template>

<script>
    export default {
        name: "FixedData",
        data() {
            return {
                text: JSON.stringify(this.dataOption.example),
                error: '',
                checking: false
            }
        },
        props: {
            dataOption: Object
        },
        methods: {
            validateConfig(){
                this.checking = true;
                try {
                    this.error = '';
                    this.dataOption.detail.data = JSON.parse(this.text);
                    this.$emit('callBack');
                }catch (e) {
                    this.error = '请输入正确的数据格式。'
                }
                this.checking = false;
            }
        }
    }
</script>

<style scoped>

</style>
