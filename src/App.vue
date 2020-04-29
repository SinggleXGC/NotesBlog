<template>
    <div id="app">
        <el-container>
            <el-header class="xgc-padding-lr-none">
                <!-- 导航栏 -->
                <el-menu :default-active="activeIndex" mode="horizontal" class="xgc-flex" router>
                    <el-menu-item index="/">首页</el-menu-item>
                    <el-menu-item index="/realize">随笔</el-menu-item>
                    <el-menu-item index="/categories">分类</el-menu-item>

                    <el-menu-item>
                        <el-input placeholder="请输入搜索内容" suffix-icon="iconfont icon-sousuo"></el-input>
                    </el-menu-item>
                    <el-menu-item>
                        <span class="xgc-flex xgc-vertical-center"><i class="iconfont icon-bianji xgc-margin-r-mini"></i>写文章</span>
                    </el-menu-item>
                    <el-menu-item>登录</el-menu-item>
                </el-menu>
            </el-header>
            <el-main>
                <router-view></router-view>
            </el-main>
            <el-footer class="xgc-padding-lr-none xgc-bg-dark-grey xgc-font-footer">
                <div class="xgc-footer-content">
                    <p>Design By XGC</p>
                    <p>Email: 1307708161@qq.com</p>
                </div>
            </el-footer>
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
    .el-main {
        padding: 0 !important;
    }

    /* nav */
    .el-menu-item:nth-child(3) {
        margin-right: auto !important;
    }

    /* footer */
    .el-footer {
        height: auto !important;
    }
    .xgc-footer-content p {
        text-align: center;
    }

    /*.el-scrollbar .el-scrollbar__wrap {*/
    /*    overflow-x: hidden;*/
    /*}*/
</style>
