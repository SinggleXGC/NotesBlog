import Vue from 'vue'
import App from './App.vue'
import './assets/css/xgc.css'
import './assets/font/iconfont.css'

//导入element-ui的配置文件
import '@/plugins/element-ui'
//导入element-ui的样式文件
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
