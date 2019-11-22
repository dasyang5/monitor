<template>
    <el-container style="height: 100%;width: 100%;padding-top: 0">
        <el-main style="height: 100%;width: 100%;">
            <div ref="monitor" style="height: 100%;width: 100%;" @contextmenu.prevent="">
                <!-- 布局主体 -->
                <grid-layout :style="result.style.backStyle" id="grid-layout"
                             style="height: 100%;width: 100%;border: 1px solid rgba(128,128,128,0.43);border-radius: 5px"
                             :layout.sync="result.layouts" :col-num="24" :maxRows="40"
                             :row-height="rowHeight" :is-draggable="true" :is-resizable="true" :is-mirrored="false"
                             :vertical-compact="true" :margin="blockMargin" :use-css-transforms="true">
                    <!--  菜单  -->
                    <user-monitor-create-add-tool-bar @addItem="addItem" @finish="finish"/>
                    <!-- 组件 -->
                    <grid-item v-for="item in result.layouts" @resize="itemResize" @resized="itemResized" style="border: 1px solid rgba(136,136,136,0.53)"
                               :minH="2" :minW="2" :x="item.x" :y="item.y" :w="item.w" :h="item.h" :i="item.i"
                               :key="item.i">
                        <!-- 组件明细 -->
                        <user-monitor-create-add-item style="height: 100%;width: 100%;" :index="item.i" :w="item.w"
                                                      :h="item.h" ref="addItem" @deleteItem="deleteItem"/>
                    </grid-item>
                </grid-layout>
            </div>
        </el-main>
        <!-- 组件编辑菜单 -->
        <create-item-main ref="itemEditMenu"></create-item-main>
        <!-- 主体背景编辑菜单 -->
        <user-monitor-create-add-main-edit ref="mainEdit"
                                           :option="result.style"></user-monitor-create-add-main-edit>
    </el-container>
</template>

<script>
    import VueGridLayout from 'vue-grid-layout';
    import UserMonitorCreateAddItem from "./UserMonitorCreateAddItem";
    import UserMonitorCreateAddToolBar from "./UserMonitorCreateAddToolBar";
    import CreateItemMain from "./item-edit/CreateItemMain";
    import UserMonitorCreateAddMainEdit from "./UserMonitorCreateAddMainEdit";
    import qs from 'qs'

    export default {
        name: "UserMonitorAdd",
        data() {
            return {
                id: null,
                result: {
                    //组件数目
                    count: 0,
                    //画布背景样式
                    style: {
                        backStyle: {
                            backgroundColor: 'rgba(0,0,0,0)'
                        }
                    },
                    //组件布局信息
                    layouts: [],
                    //组件配置信息
                    options: []
                },
                rowHeight: 20,
                blockMargin: [0, 0]
            }
        },
        components: {
            GridLayout: VueGridLayout.GridLayout,
            GridItem: VueGridLayout.GridItem,
            UserMonitorCreateAddItem,
            UserMonitorCreateAddToolBar,
            CreateItemMain, UserMonitorCreateAddMainEdit
        },
        methods: {
            /**
             * 删除组件
             */
            deleteItem(index) {
                for (let i = 0; i < this.result.layouts.length; i++) {
                    if (this.result.layouts[i].i === index) {
                        this.result.layouts.splice(i, 1);
                        return;
                    }
                }
            },
            /**
             * 增加组件
             */
            addItem() {
                this.result.layouts.push({
                    "x": 22,
                    "y": 100,
                    "w": 2,
                    "h": 2,
                    "i": (this.result.count++) + ""
                });
            },
            /**
             * 组件改变大小时重新绘制组件内容
             * @param index
             * @param newH
             * @param newW
             * @param newHPx
             * @param newWPx
             */
            itemResize(index, newH, newW, newHPx, newWPx) {
                for (let i = 0; i < this.result.layouts.length; i++) {
                    if (this.result.layouts[i].i === index) {
                        this.$refs.addItem[i].resizeItem();
                        return;
                    }
                }
            },
            /**
             * 组件改变大小结束后，重新绘制组件内容
             * @param index
             * @param newH
             * @param newW
             * @param newHPx
             * @param newWPx
             */
            itemResized(index, newH, newW, newHPx, newWPx) {
                for (let i = 0; i < this.result.layouts.length; i++) {
                    if (this.result.layouts[i].i === index) {
                        let interval = setInterval(() => {
                            this.$refs.addItem[i].resizeItem();
                            clearInterval(interval);
                        }, 100);
                        return;
                    }
                }
            },
            /**
             * 完成编辑，保存编辑内容
             */
            finish() {
                //整理信息
                let tempLayouts = [];
                let count = 0;
                for (let i = 0; i < this.result.layouts.length; i++) {
                    tempLayouts[count] = {
                        'x': this.result.layouts[i].x,
                        'y': this.result.layouts[i].y,
                        'w': this.result.layouts[i].w,
                        'h': this.result.layouts[i].h,
                        'i': count + ''
                    };
                    this.result.options[count] = this.$refs.addItem[i].option;
                    this.result.options[count].index = count + '';
                    count++;
                }
                this.result.count = count;
                this.result.layouts = tempLayouts;

                if (this.id === null) {
                    //保存
                    this.$prompt('请输入数字大屏名称', '添加', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        inputPattern: /\S+/,//正则表达式校验
                        inputErrorMessage: '标题不能为空'
                    }).then(({value}) => {
                        //点击确认
                        this.axios
                            .post(
                                '/server/monitor/create/save',
                                qs.stringify({
                                    'result': JSON.stringify(this.result),
                                    'title': value
                                })
                            )
                            .then((res => {
                                //保存成功
                                this.id = res.data.id;
                                this.$message({
                                    message: '保存成功！',
                                    type: 'success'
                                });
                            }))
                            .catch(error => {
                                console.log(error);
                                this.$message.error('保存失败');
                            });
                    }).catch(() => {
                        //点击取消
                    });
                } else {
                    //修改
                    this.axios
                        .post(
                            '/server/monitor/create/update',
                            qs.stringify({
                                'result': JSON.stringify(this.result),
                                'id': this.id
                            })
                        )
                        .then((res => {
                            //保存成功
                            this.$message({
                                message: '保存成功！',
                                type: 'success'
                            });
                        }))
                        .catch(error => {
                            console.log(error);
                            this.$message.error('保存失败');
                        });
                }
            },
            initOptions() {
                //自适应高度
                this.rowHeight = (this.$refs.monitor.clientHeight - this.blockMargin[1] * 41) / 40;
                //设置组件
                for (let i = 0; i < this.result.layouts.length; i++) {
                    this.$refs.addItem[i].option = this.result.options[i];
                }
            },
            initHeight() {
                //自适应高度
                this.rowHeight = this.$refs.monitor.clientHeight / 40;
            }
        },
        mounted() {
            if (this.$route.query.result !== undefined) {
                this.result = JSON.parse(this.$route.query.result);
                this.id = this.$route.query.id;
                //延迟一段时间再加载配置信息，否则echarts会无法获取到父元素的宽度和高度，导致不能正常显示
                this.$nextTick(function () {
                    setTimeout(this.initOptions, 100);
                });
            } else {
                this.$nextTick(function () {
                    setTimeout(this.initHeight, 100);
                });
            }
            this.$root.monitorEditItem = this.$refs.itemEditMenu;
            this.$root.monitorMainEdit = this.$refs.mainEdit;
        }
    }
</script>

<style scoped>

</style>
