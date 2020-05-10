import Vue from 'vue'
import App from './App.vue'
//导入css样式
import '@/assets/css/global.css'
import '@/assets/font/iconfont.css'

//导入VueRouter配置
import router from "@/router";

//导入element-ui的配置文件
import '@/element-ui'
//导入element-ui的样式文件
import 'element-ui/lib/theme-chalk/index.css'

import axios from 'axios'
axios.defaults.baseURL = 'http://127.0.0.1:8081/'
Vue.prototype.$http = axios

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
