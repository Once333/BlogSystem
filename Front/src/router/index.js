import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    { path: '/', component: () => import('../views/Home') },
    { path: '/category', component: () => import('../views/Category') },
    { path: '/tag', component: () => import('../views/Tag') },
    { path: '/file', component: () => import('../views/File') },
    { path: '/resource', component: () => import('../views/Resource') },
    { path: '/about', component: () => import('../views/About') },
    { path: '/blog/:blogId', name: 'Blog', component: () => import('../views/Blog') },
    { path: '/category/:cid', name: 'CArticles', component: () => import('../components/CArticles') }
  ]
})
