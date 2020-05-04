import Vue from 'vue'
import Router from 'vue-router'

import EssayList from '@/components/EssayList';
import Essay from "@/components/Essay";
import CategoryList from "@/components/CategoryList";

Vue.use(Router)

const router = new Router({
    routes: [
        {path: '/', redirect:'/index'},
        {path: '/index', component: EssayList},
        {path:'/category', component: CategoryList},
        {path: '/essay/10', component: Essay}
    ]
})

export default router;