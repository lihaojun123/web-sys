import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/home'
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: () => import('../views/dashboard')
  },
  {
    path: '/index',
    name: 'Index',
    component: () => import('../views/index'),
    children: [
      {
        path: '/xxx1',
        name: 'xxx1',
        component: () => import('../views/index/index')
      }, {
        path: '/xxx2',
        name: 'visit',
        component: () => import('../views/visit/index')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
