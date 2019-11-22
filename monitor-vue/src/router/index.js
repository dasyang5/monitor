import Vue from 'vue'
import Router from 'vue-router'

import IndexMain from "../components/index/IndexMain";
import IndexLogin from "../components/index/login/IndexLogin";
import IndexHome from "../components/index/home/IndexHome";

import UserMain from "../components/user/UserMain";
import UserHome from "../components/user/home/UserHome";
import UserMonitorCreateAdd from "../components/user/monitor/create/UserMonitorCreateAdd";
import UserMonitorCreate from "../components/user/monitor/create/UserMonitorCreate";
import UserMonitorList from "../components/user/monitor/list/UserMonitorList";
import UserMonitorView from "../components/user/monitor/view/UserMonitorView"

Vue.use(Router);

const originalPush = Router.prototype.push;
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
};

export default new Router({
    routes: [
        {
            path: '/',
            component: IndexMain,
            children: [
                {path: '', component: IndexHome},
                {path: 'login', component: IndexLogin}
            ]
        },
        {
            path: '/user/',
            component: UserMain,
            children: [
                {path: '', component: UserHome},
                {path: 'monitor/create', component: UserMonitorCreate},
                {path: 'monitor/create/add', component: UserMonitorCreateAdd},
                {path: 'monitor/list', component: UserMonitorList}
            ]
        },
        {
            path: '/user/monitor/view', component: UserMonitorView
        }

    ]
})
