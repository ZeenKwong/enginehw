import Vue from 'vue'
import App from './App.vue'
import router from '@/router'
import store from './store'
// 自定义字体的引入
import './assets/font/font.css'
// 引入axios用于与后端通信，并把其插入vue的原型对象里做初始化
// 这里有个跨域问题，我们做完再解决
import axios from 'axios'
Vue.prototype.$ajax = axios
axios.defaults.baseURL = "http://127.0.0.1:8080/"
// 封装localstorage方法，不然每次都要做json转换
import storage from '@/assets/js/storage';
Vue.prototype.$storage = storage

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')


