import Vue from 'vue'
import Router from 'vue-router'

import EssayList from '@/components/EssayList';
import RealizeList from "@/components/RealizeList";
import CategoryList from "@/components/CategoryList";
import Essay from "@/components/Essay";

Vue.use(Router)

const router = new Router({
    routes: [
        {path: '/', redirect:'/index'},
        {path: '/index', component: EssayList,},
        {path: '/realize', component: RealizeList},
        {
            path:'/categories',
            component: CategoryList,
            children: [

            ]
        },
        {path: '/essay/10', component: Essay}
    ]
})

export default router;