import Vue from 'vue'
import Router from 'vue-router'

import EssayList from '@/components/EssayList';
import Essay from "@/components/Essay";
import CategoryList from "@/components/CategoryList";
import Publish from "@/components/Publish";

Vue.use(Router)

const router = new Router({
    routes: [
        {path: '/', redirect:'/index'},
        {path: '/index', component: EssayList},
        {path:'/category', component: CategoryList},
        {path: '/essay/10', component: Essay},
        {path: '/publish', component: Publish}
    ]
})

router.beforeEach((to, from, next) => {
    if (to.path === '/publish') {
        if (window.sessionStorage.getItem("user")) {
            next();
        }else {
            return;
        }
    }
    next();
})

export default router;