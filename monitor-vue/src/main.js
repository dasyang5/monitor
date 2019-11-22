// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import VueAxios from 'vue-axios'
import axios from 'axios'
import store from './store'
//引入element-ui界面
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import {eventBus,labelPosition,labelWidth} from "./const";
import eCharts from 'echarts'

Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.use(VueAxios,axios);

Vue.prototype.$eventBus = eventBus;
Vue.prototype.$eCharts = eCharts;
Vue.prototype.$labelPosition = labelPosition;
Vue.prototype.$labelWidth = labelWidth;
/**
 * 如果没有token，则跳转到登录页面进行登录
 */
router.beforeEach((to, from, next) => {
  if (to.path === '/login' || to.path === '/') {
    next();
  } else {
    let token = store.state.token;
    if (token === 'null' || token === '') {
      next('/login');
    } else {
      next();
    }
  }
});

/**
 * 请求头部注入token
 */
axios.interceptors.request.use(
  config => {
    if (localStorage.getItem('token')) {
      config.headers.Authorization = localStorage.getItem('token');
    }
    return config;
  },
  error => {
    return Promise.reject(error);
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>',
  render: h => h(App),
  data(){
    return{
      monitorEditItem: null,//组件编辑dialog
      monitorMainEdit: null,//主体背景编辑dialog
      monitorOption: null
    }
  }
});

