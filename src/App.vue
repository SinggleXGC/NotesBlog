<template>
    <div id="app">
        <el-container>
            <el-header>
                <!-- 导航栏 -->
                <el-menu :default-active="activeIndex" mode="horizontal" router class="xgc-display-flex">
                    <el-menu-item index="/">首页</el-menu-item>
                    <el-menu-item index="/category">分类</el-menu-item>
                    <el-menu-item class="xgc-margin-left-auto">
                        <el-input placeholder="请输入搜索内容" suffix-icon="iconfont icon-sousuo"></el-input>
                    </el-menu-item>
                    <el-menu-item index="/publish">
                        <span><i class="iconfont icon-bianji"></i>写文章</span>
                    </el-menu-item>
                    <el-menu-item>登录</el-menu-item>
                </el-menu>
            </el-header>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: 'App',
        data() {
            return {
                activeIndex: '/'
            }
        }
    }
</script>

<style lang="less" scoped>

</style>
