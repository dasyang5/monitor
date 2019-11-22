<template>
    <div style="height: 100%;width: 100%">

        <el-menu ref="userMenu" :default-active="activeIndex" class="el-menu-demo" mode="horizontal"
                 :router="router" @select="handleSelect">
            <el-menu-item index="/user">首页</el-menu-item>

            <el-submenu index="/user/monitor">
                <template slot="title">监控</template>
                <el-menu-item index="/user/monitor/list">我的监控</el-menu-item>
                <el-menu-item index="/user/monitor/create">新增监控</el-menu-item>
            </el-submenu>

            <el-submenu class="float-right" index="/user/information">
                <template slot="title">用户管理</template>
                <el-menu-item index="/user/personal/information">个人信息</el-menu-item>
                <el-menu-item index="/user/personal/password">修改密码</el-menu-item>
                <el-menu-item index="/user/personal/logout">退出登录</el-menu-item>
            </el-submenu>
        </el-menu>

        <router-view :style="{ height: routerViewHeight, width: routerViewWidth }"/>
    </div>
</template>

<script>
    import { mapMutations } from 'vuex';
    export default {
        name: "UserMain",
        data() {
            return {
                activeIndex: '/',
                router: false,
                menuHeight: 0,
                menuWidth: 0
            }
        },
        methods: {
            ...mapMutations(['changeLogin']),
            handleSelect(index, indexPath) {
                if (index === '/user/personal/logout') {
                    this.changeLogin('');
                    this.$router.push('/');
                    return;
                }
                this.$router.push(index);
            }
        },
        computed: {
            routerViewHeight: function () {
                //减去导航栏的高度
                return (document.body.clientHeight - this.menuHeight - 5) + 'px';
            },
            routerViewWidth: function () {
                return '100%'
            }
        },
        mounted() {
            //通过钩子函数，保证每次页面刷新，导航栏的激活菜单都是对应的当前页面
            this.activeIndex = this.$route.path;
            //主体铺满全屏时需要获取屏幕的宽度和高度
            this.menuHeight = this.$refs.userMenu.$el.clientHeight;
            this.menuWidth = this.$refs.userMenu.$el.clientWidth;
        }

    }
</script>

<style scoped>
    .float-right {
        float: right;
    }
</style>
