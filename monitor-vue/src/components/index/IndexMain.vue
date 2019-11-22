<template>
  <div>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" :router="router" @select="handleSelect">
      <el-menu-item index="/">首页</el-menu-item>
      <el-menu-item index="/login">登录</el-menu-item>
    </el-menu>
    <router-view/>
  </div>
</template>

<script>
    export default {
        name: "IndexMain",
        data(){
            return {
                activeIndex: '/',
                router: false
            }
        },
        methods: {
            handleSelect(index, indexPath) {
                //导航菜单 点击后回调函数
                this.$router.push(index);
            }
        },
        mounted() {
            //通过钩子函数，保证每次页面刷新，导航栏的激活菜单都是对应的当前页面
            this.activeIndex = this.$route.path;
        }
    }
</script>

<style src="./IndexMain.css"></style>
