<template>
    <div id="app">
        <el-container>
            <el-header class="xgc-padding-lr-none">
                <!-- 导航栏 -->
                <el-menu mode="horizontal" class="xgc-flex">
                    <el-menu-item>首页</el-menu-item>
                    <el-menu-item>随笔</el-menu-item>
                    <el-menu-item>分类</el-menu-item>

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
                <div class="xgc-content-container">
                    <div class="xgc-fragment">
                        <el-row>
                            <el-col :span="18">
                                <div>
                                    <h3>Vue 3.0 这个迷人的小妖精，到底好在哪里？（更新原理对比）</h3>
                                    <div class="xgc-font-secondary xgc-flex xgc-vertical-center">
                                        <img src="./assets/img/user_avatar.jpg" alt="头像" class="xgc-avatar-mini">
                                        <span>XGC</span>
                                        <span>2020.04.24</span>
                                        <span>Vue</span>
                                    </div>
                                </div>
                            </el-col>
                            <el-col :span="6">
                                <img src="./assets/img/mediaImg.png" class="xgc-media-img">
                            </el-col>
                        </el-row>
                    </div>
                    <div class="xgc-fragment">
                        <el-row>
                            <el-col :span="18">
                                <div>
                                    <h3>Vue 3.0 这个迷人的小妖精，到底好在哪里？（更新原理对比）</h3>
                                    <div class="xgc-font-secondary xgc-flex xgc-vertical-center">
                                        <img src="./assets/img/user_avatar.jpg" alt="头像" class="xgc-avatar-mini">
                                        <span>XGC</span>
                                        <span>2020.04.24</span>
                                        <span>Vue</span>
                                    </div>
                                </div>
                            </el-col>
                            <el-col :span="6">
                                <img src="./assets/img/mediaImg.png" class="xgc-media-img">
                            </el-col>
                        </el-row>
                    </div>
                    <div class="xgc-fragment">
                        <el-row>
                            <el-col :span="18">
                                <div>
                                    <h3>Vue 3.0 这个迷人的小妖精，到底好在哪里？（更新原理对比）</h3>
                                    <div class="xgc-font-secondary xgc-flex xgc-vertical-center">
                                        <img src="./assets/img/user_avatar.jpg" alt="头像" class="xgc-avatar-mini">
                                        <span>XGC</span>
                                        <span>2020.04.24</span>
                                        <span>Vue</span>
                                    </div>
                                </div>
                            </el-col>
                            <el-col :span="6">
                                <img src="./assets/img/mediaImg.png" class="xgc-media-img">
                            </el-col>
                        </el-row>
                    </div>
                    <div class="xgc-fragment">
                        <el-row>
                            <el-col :span="18">
                                <div>
                                    <h3>Vue 3.0 这个迷人的小妖精，到底好在哪里？（更新原理对比）</h3>
                                    <div class="xgc-font-secondary xgc-flex xgc-vertical-center">
                                        <img src="./assets/img/user_avatar.jpg" alt="头像" class="xgc-avatar-mini">
                                        <span>XGC</span>
                                        <span>2020.04.24</span>
                                        <span>Vue</span>
                                    </div>
                                </div>
                            </el-col>
                            <el-col :span="6">
                                <img src="./assets/img/mediaImg.png" class="xgc-media-img">
                            </el-col>
                        </el-row>
                    </div>
                    <div class="xgc-fragment">
                        <el-row>
                            <el-col :span="18">
                                <div>
                                    <h3>Vue 3.0 这个迷人的小妖精，到底好在哪里？（更新原理对比）</h3>
                                    <div class="xgc-font-secondary xgc-flex xgc-vertical-center">
                                        <img src="./assets/img/user_avatar.jpg" alt="头像" class="xgc-avatar-mini">
                                        <span>XGC</span>
                                        <span>2020.04.24</span>
                                        <span>Vue</span>
                                    </div>
                                </div>
                            </el-col>
                            <el-col :span="6">
                                <img src="./assets/img/mediaImg.png" class="xgc-media-img">
                            </el-col>
                        </el-row>
                    </div>
                    <div class="xgc-fragment">
                        <el-row>
                            <el-col :span="18">
                                <div>
                                    <h3>Vue 3.0 这个迷人的小妖精，到底好在哪里？（更新原理对比）</h3>
                                    <div class="xgc-font-secondary xgc-flex xgc-vertical-center">
                                        <img src="./assets/img/user_avatar.jpg" alt="头像" class="xgc-avatar-mini">
                                        <span>XGC</span>
                                        <span>2020.04.24</span>
                                        <span>Vue</span>
                                    </div>
                                </div>
                            </el-col>
                            <el-col :span="6">
                                <img src="./assets/img/mediaImg.png" class="xgc-media-img">
                            </el-col>
                        </el-row>
                    </div>
                </div>
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
        name: 'App'
    }
</script>

<style lang="less" scoped>
    .xgc-font-secondary span {
        margin: 0 3px;
    }

    .el-menu-item:nth-child(3) {
        margin-right: auto !important;
    }

    .el-footer {
        height: auto !important;
    }

    .xgc-footer-content p {
        text-align: center;
    }

</style>
