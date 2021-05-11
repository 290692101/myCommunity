import Vue from 'vue'
import App from './App.vue'

//自己加的 导入路由
import router from './router'
import Axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(Axios,VueAxios)

new Vue({
  router,
  el: '#app',
 render:h=>h(App)
})
