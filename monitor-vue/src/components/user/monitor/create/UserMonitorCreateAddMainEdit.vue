<template>
    <el-dialog :visible.sync="dialogTableVisible">
        <el-main>
            <el-row>
                <el-form ref="form" :model="option" :label-position="this.$root.$labelPosition"
                         :label-width="this.$root.$labelWidth" :size="'small'">
                    <el-form-item label="背景颜色">
                        <el-color-picker v-model="option.backStyle.backgroundColor" show-alpha></el-color-picker>
                    </el-form-item>
                </el-form>
                <el-col :span="24">
                </el-col>
            </el-row>
        </el-main>
        <span slot="footer" class="dialog-footer">
      <el-button @click="closeDialog">取 消</el-button>
      <el-button type="primary" @click="finish">确 定</el-button>
    </span>
    </el-dialog>

</template>

<script>
    export default {
        name: "UserMonitorCreateAddMainEdit",
        data() {
            return {
                dialogTableVisible: false
            }
        },
        props: {
            option: Object
        },
        methods: {
            show() {
                this.dialogTableVisible = true;
            },
            closeDialog() {
                this.dialogTableVisible = false;
            },
            finish() {
                this.dialogTableVisible = false;
            }
        }
    }
</script>

<style scoped>

</style>
