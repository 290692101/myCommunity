import Vue from 'vue'
import Router from 'vue-router'
//导入组件
import Login from "@/components/Login";
import HelloWorld from "@/components/HelloWorld";
import Topics from "@/components/Topics";
//安装插件
Vue.use(Router)
//创建路由对象并【配置路由规则
export default new Router({
    //默认不加#号
    mode:'history',
    routes:[
        {
            path:'/login',
            component:Login

        },
        {
            path:'/hello',
            component:HelloWorld

        },
        {
            path:'/topics',
            component:Topics

        },


    ]

})