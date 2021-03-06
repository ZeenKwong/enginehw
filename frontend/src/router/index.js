import Vue from 'vue'
import Router from 'vue-router'
// import Home from '@/views/Home.vue'

Vue.use(Router)

export default new Router({
  // mode: 'history',
  // base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      // component: Home
      component: () => import(/* webpackChunkName: "about" */ '@/page/Home.vue')
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      // component: () => import(/* webpackChunkName: "about" */ '@/views/About.vue')
      component: resolve => require(['@/views/About.vue'], resolve),
    },
    {
      path: '/user',
      name: 'user',
      component: resolve => require(['@/page/User.vue'], resolve),
    },
    {
      path: '/orderlist',
      name: 'orderlist',
      component: resolve => require(['@/page/OrderList.vue'], resolve),
    },
    {
      path: '/Items',
      name: 'Items',
      component: resolve => require(['@/page/Items.vue'], resolve),
    },
  ]
})
