<template>
    <div class="block" @click="resizeItem" @mouseenter="mouseEnter" @mouseleave="mouseLeave">
        <!-- 顶部工具栏 -->
        <div :style="toolBarStyle" class="top-bar">
            <!-- 编辑 -->
            <i class="el-icon-edit icon-btn" @click="editItem"></i>
            <!-- 删除 -->
            <i class="el-icon-delete icon-btn" @click="deleteItem"></i>
        </div>
        <!-- 组件内容展示 -->
        <item-show ref="itemShow" :option="option" :w="w" :h="h" :style="option.mainOption.outStyle"/>
    </div>
</template>

<script>
    import ItemShow from "./item-details/ItemShow";

    export default {
        name: "CreateToolBar",
        components: {ItemShow},
        data() {
            return {
                toolBarStyle: {
                    display: 'none'
                },
                option: {
                    //组件id
                    index: this.index,
                    //标记option是否被编辑过，没有被编辑过则内容应当是空的。
                    isEdit: false,
                    //组件类型配置信息
                    mainOption: {
                        //组件类型
                        type: null,
                        editType: "",
                        style: {
                            borderWidth: '1px',
                            borderStyle: 'solid',
                            borderColor: 'rgba(137,255,253,0.44)',
                            borderRadius: '5px',
                            backgroundColor: 'rgba(139,255,253,0.15)'
                        },
                        outStyle: {
                            padding: '5px'
                        }
                    },
                    //组件样式配置信息
                    itemOption: {},
                    //数据配置信息
                    dataOption: {
                        type: '' //数据绑定的类型
                    },
                    //触发器配置信息
                    triggerOption: {}
                }
            }
        },
        props: {
            index: String,
            h: Number,
            w: Number,
            showToolBar: {
                type: Boolean,
                default: true
            }
        },
        methods: {
            editItem() {
                this.$root.monitorOption = JSON.parse(JSON.stringify(this.option));
                this.$root.monitorEditItem.show();//通过获取全局变量实例，显示编辑菜单。
                //编辑完成后回调
                this.$eventBus.$on('name', () => {
                    this.option.isEdit = true;
                    //拷贝值
                    this.option.mainOption = this.$root.monitorOption.mainOption;
                    this.option.itemOption = this.$root.monitorOption.itemOption;
                    this.option.dataOption = this.$root.monitorOption.dataOption;
                    this.option.triggerOption = this.$root.monitorOption.triggerOption;
                    //置空
                    this.$root.monitorOption = null;
                    this.$eventBus.$off('name');
                })
            },
            deleteItem() {
                this.$emit("deleteItem", this.index);
            },
            mouseEnter() {
                if (this.showToolBar) {
                    this.toolBarStyle.display = 'block';
                }
            },
            mouseLeave() {
                if (this.showToolBar) {
                    this.toolBarStyle.display = 'none';
                }
            },
            resizeItem() {
                if (this.$refs.itemShow != null) {
                    this.$refs.itemShow.resizeItem();
                }
            }
        }
    }
</script>

<style scoped>
    .block {
        height: 100%;
        width: 100%;
    }

    .top-bar {
        cursor: default;
        width: 100%;
        position: fixed;
        top: 0;
        background-color: rgba(223, 223, 223, 0.24);
        text-align: right;
        z-index: 999;
    }

    .icon-btn {
        border: 1px solid rgba(208, 208, 208, 0.67);
        border-radius: 5px;
        padding: 1px;
        margin: 2px 1px;
        background-color: white;
        text-align: center;
        width: 25px;
        color: #7fcdff;
    }

    .icon-btn:hover {
        color: #7689ff;
    }

</style>
