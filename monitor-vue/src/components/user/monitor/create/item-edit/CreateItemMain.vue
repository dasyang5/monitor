<template>
    <el-dialog :visible.sync="dialogVisible" width="60%" :before-close="closeDialog">
        <el-row>
            <el-col :span="13">
                <el-tabs v-model="activeName">
                    <el-tab-pane label="组件类型" name="first">
                        <create-item-type :option="option.mainOption"/>
                    </el-tab-pane>
                    <el-tab-pane label="组件样式" name="second">
                        <component :is="styleEdits[option.mainOption.editType]"
                                   :option="option.itemOption" style="height: 330px;overflow: auto"></component>
                    </el-tab-pane>
                    <el-tab-pane label="数据绑定" name="third">
                        <component :is="dataEdits[option.mainOption.editType]"
                                   :option="option"></component>
                    </el-tab-pane>
                    <el-tab-pane label="触发器" name="fourth">定时任务补偿</el-tab-pane>
                </el-tabs>
            </el-col>
            <el-col :span="11" style="margin-top: 10%;padding-left: 20px;">
                <!-- 编辑展示区域 -->
                <item-show :option="option" ref="itemShow" style="height: 300px;width: 100%;"/>
            </el-col>
        </el-row>
        <span slot="footer" class="dialog-footer">
      <el-button @click="closeDialog">取 消</el-button>
      <el-button type="primary" @click="finish">确 定</el-button>
    </span>
    </el-dialog>
</template>

<script>
    import CreateItemType from "./CreateItemType";
    import ItemShow from "../item-details/ItemShow";

    import Bar001StyleEdit from "../item-details/echarts/Bar001StyleEdit";
    import Bar002StyleEdit from "../item-details/echarts/Bar002StyleEdit";
    import Pie001StyleEdit from "../item-details/echarts/Pie001StyleEdit";
    import Line001StyleEdit from "../item-details/echarts/Line001StyleEdit";
    import Title001StyleEdit from "../item-details/title/Title001StyleEdit";

    import Bar001Data from "../item-details/echarts/Bar001Data";

    export default {
        name: "CreateItemEdit",
        data() {
            return {
                styleEdits: {
                    'bar-1': Bar001StyleEdit,
                    'bar-2': Bar002StyleEdit,
                    'pie-1': Pie001StyleEdit,
                    'line-1': Line001StyleEdit,
                    'title-1': Title001StyleEdit
                },
                dataEdits: {
                    'bar-1': Bar001Data
                },
                activeName: 'first',
                dialogVisible: false,
                option: {
                    mainOption: {
                        editType: ""
                    }
                }
            }
        },
        methods: {
            show() {
                this.option = this.$root.monitorOption;//避免直接使用引用，拷贝后再进行修改
                this.option.index = "item-show";//此处index不能和拉拽页面的index重复
                this.dialogVisible = true;
            },
            finish() {
                this.dialogVisible = false;
                this.$eventBus.$emit('name');
            },
            closeDialog() {
                this.dialogVisible = false;
                this.$eventBus.$off('name');
            }
        },
        components: {
            CreateItemType,
            ItemShow
        },
        computed: {
            itemType() {
                try {
                    return this.option.mainOption.editType;
                } catch (e) {
                    return null;
                }
            }
        },
        watch: {
            dialogVisible() {
                if (!this.dialogVisible) {
                    //窗口隐藏时，切换到第一页
                    this.activeName = 'first';
                }
            }
        }
    }
</script>

<style>
    .el-dialog__header {
        display: none;
    }
</style>
