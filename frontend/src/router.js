import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/all',
      name: 'films',
      component: () => import('./components/FilmList')
    },
    {
      path: '/add',
      name: 'add-film',
      component: () => import('./components/AddFilm')
    },
    {
      path: '/find',
      name: 'find-film',
      component: () => import('./components/FindFilm')
    }
  ]
})
