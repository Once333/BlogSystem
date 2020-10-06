import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home'
import Category from '../views/Category'
import Tag from '../views/Tag'
import File from '../views/File'
import Resource from '../views/Resource'
import About from '../views/About'
import Blog from '../views/Blog'
import CArticles from '../components/CArticles'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    { path: '/', component: Home },
    { path: '/category', component: Category },
    { path: '/tag', component: Tag },
    { path: '/file', component: File },
    { path: '/resource', component: Resource },
    { path: '/about', component: About },
    { path: '/blog/:blogId', name: 'Blog', component: Blog },
    { path: '/category/:cid', name: 'CArticles', component: CArticles }
  ]
})
