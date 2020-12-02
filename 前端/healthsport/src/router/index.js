import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import UserList from '../components/admin/UserList.vue'

Vue.use(VueRouter)

const routes = [
  {
    path:'/' , redirect:'/login'
  },
  {
    path:'/login', component:Login,
  },
  {
    path:'/home', component:Home,
    redirect:'/welcome',
    children:[
      {path:'/welcome' ,component:Welcome},
      {path:'/user' , component:UserList}
    ]
  },
  
]

const router = new VueRouter({
  routes
})

// 跳转有问题时使用-------------------------------------------------------------------------》
  // const originalPush = VueRouter.prototype.push
  // VueRouter.prototype.push = function push(location,onResolve,onReject){
  // if(onResolve || onReject) return originalPush.call(this,location,onResolve,onReject)
  // return originalPush.call(this,location).catch(er => er)
  // }
// ----------------------------------------------------------------------------------------》

// 路由守卫
router.beforeEach((to,from,next) => {
  // 如果路径为'/login'直接放行
    if(to.path == '/login') return next();
  // 非'/login'路径，先获取当前登录的用户信息
    const user =  window.sessionStorage.getItem('user');
  // 有则放行，无则转到'/login'
    if(!user) return next('/login');
    next();
})

export default router
