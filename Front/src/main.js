import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import tagCloud from 'v-tag-cloud'

Vue.use(tagCloud)
Vue.use(ElementUI)
Vue.config.productionTip = false
Vue.prototype.axios = axios

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
