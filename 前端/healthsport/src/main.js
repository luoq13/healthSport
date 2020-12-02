import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import './assets/css/global.css'
import './assets/font/iconfont.css'
import axios from 'axios'

// 挂在axios
Vue.prototype.$http = axios
// 设置默认请求路径
axios.defaults.baseURL = 'http://localhost:9090'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
