<template>
  <div id="main">
    <form id="main-form">
      <!-- 用户名 -->
      <el-input id="username" type="text" v-model="loginData.username"></el-input>
      <!-- 密码 -->
      <el-input id="password" type="password" v-model="loginData.password"></el-input>
      <!-- 错误提示信息 -->
      <h4 id="msg-error">
        <span v-html="error"></span>
      </h4>
      <!-- 登录按钮 -->
      <el-button type="primary" v-on:click="doLogin" style="width: 100%">Login</el-button>
    </form>
  </div>
</template>

<script>
    import { mapMutations } from 'vuex';
    import qs from 'qs'
    export default {
        name: "IndexLogin",
        data(){
            return {
                loginData: {
                    username: '',
                    password: ''
                },
                error: '&nbsp;'
            }
        },
        methods: {
            ...mapMutations(['changeLogin']),
            doLogin() {
                this.axios
                    .post(
                        '/server/login',
                        qs.stringify(this.loginData)
                    )
                    //登录成功，保存token
                    .then((res)=>{
                        //服务器端校验token需要发送token type + 空格 + token
                        let token = res.data.tokenType + ' ' + res.data.token;
                        this.changeLogin(token);
                        this.$router.push('/user');
                    })
                    //登录失败，显示提示信息
                    .catch(error=>{
                        this.error = error
                    })
            }
        }
    }

</script>
<style src="./IndexLogin.css"></style>
