import Vue from 'vue'
import App from './App.vue'
//导入css样式
import '@/assets/css/global.css'
import '@/assets/font/iconfont.css'

//导入VueRouter配置
import router from "@/router";

//导入element-ui的配置文件
import '@/plugins/element-ui'
//导入element-ui的样式文件
import 'element-ui/lib/theme-chalk/index.css'

// import 'editor.md/css/editormd.min.css'
// import 'editor.md/editormd.min'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
