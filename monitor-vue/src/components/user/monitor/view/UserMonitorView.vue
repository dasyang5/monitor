<template>
    <div ref="monitor" class="main-monitor" @contextmenu.prevent="">
        <!-- 布局主体 -->
        <grid-layout :style="result.style.backStyle" id="grid-layout" :isDraggable="false" :isResizable="false"
                     style="height: 100%;width: 100%;"
                     :layout.sync="result.layouts" :col-num="24"
                     :row-height="rowHeight" :is-draggable="true" :is-resizable="true" :is-mirrored="false"
                     :vertical-compact="true" :margin="blockMargin" :use-css-transforms="true">
            <!-- 组件 -->
            <grid-item v-for="item in result.layouts"
                       :minH="2" :minW="2" :x="item.x" :y="item.y" :w="item.w" :h="item.h" :i="item.i" :key="item.i">
                <!-- 组件明细 -->
                <user-monitor-create-add-item style="height: 100%;width: 100%;" :show-tool-bar="false"
                                              :index="item.i" :w="item.w" :h="item.h" ref="addItem"/>
            </grid-item>
        </grid-layout>
    </div>
</template>

<script>
    import VueGridLayout from 'vue-grid-layout';
    import UserMonitorCreateAddItem from "../create/UserMonitorCreateAddItem";
    import UserMonitorCreateAddToolBar from "../create/UserMonitorCreateAddToolBar";
    import CreateItemMain from "../create/item-edit/CreateItemMain";
    import UserMonitorCreateAddMainEdit from "../create/UserMonitorCreateAddMainEdit";
    import qs from 'qs'
    export default {
        name: "UserMonitorView",
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
                rowHeight: 25,
                blockMargin: [0,0]
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
            initOptions(){
                //自适应高度
                this.rowHeight = this.$refs.monitor.clientHeight/ 40;
                //设置组件
                for (let i = 0; i < this.result.layouts.length; i++) {
                    this.$refs.addItem[i].option = this.result.options[i];
                }
            }
        },
        mounted() {
            this.id = this.$route.query.id;
            this.axios
                .post(
                    '/server/monitor/list/showDetail',
                    qs.stringify({
                        'id': this.id
                    })
                )
                .then((res => {
                    this.result = JSON.parse(res.data.item.result);
                    //延迟一段时间再加载配置信息，否则echarts会无法获取到父元素的宽度和高度，导致不能正常显示
                    this.$nextTick(function () {
                        setTimeout(this.initOptions, 100);
                    });
                }))
                .catch(error => {
                    console.log(error);
                    this.$message.error('查询失败');
                });
        }
    }
</script>

<style scoped>
    .main-monitor {
        height: 100%;
        width: 100%;
        overflow-y: hidden;
        overflow-x: hidden;
    }
</style>
