<template>
    <div>
        <el-form-item label="请求间隔(秒)">
            <el-input-number v-model="frequency" :min="0" :max="100"
                             label="描述文字"></el-input-number>
        </el-form-item>
        <el-form-item label="请求地址">
            <el-input type="textarea"
                :rows="4" placeholder="请输入地址信息" v-model="address">
            </el-input>
        </el-form-item>
        <el-form-item label="">
            <div>
                <el-button @click="validateConfig" type="primary" :loading="checking">校验配置信息</el-button>
                <label style="font-size: 13px;color: gray">配置信息只有通过校验才会生效</label>
            </div>
            <div>
                <label>{{result}}</label>
            </div>
        </el-form-item>
    </div>
</template>

<script>
    export default {
        name: "RequestData",
        data() {
            return {
                frequency: 0,
                address: '',
                result: '',
                checking: false
            }
        },
        props: {
            dataOption: Object
        },
        methods: {
            validateConfig(){
                this.checking = true;
                this.dataOption.detail.frequency = this.frequency;
                this.dataOption.detail.address = this.address;
                this.$emit('callBack');
                this.checking = false;
            }
        }
    }
</script>

<style scoped>

</style>
