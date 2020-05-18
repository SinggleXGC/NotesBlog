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
                    <el-menu-item index="/publish" @click="pushToPublish">
                        <span><i class="iconfont icon-bianji"></i>写文章</span>
                    </el-menu-item>
                    <el-menu-item v-if="isShowLoginButton">
                        <el-button type="primary" size="mini" @click="loginDialogVisible = true">登录</el-button>
                    </el-menu-item>
                    <el-menu-item v-else>
                        <div><img :src="avatarUrl" alt="头像" class="xgc-img-mini xgc-border-round"></div>
                    </el-menu-item>
                </el-menu>
            </el-header>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>

        <!-- LoginDialog -->
        <el-dialog title="登录" :visible.sync="loginDialogVisible" :before-close="loginDialogClosed" width="40%" >
            <div class="xgc-main-container">
                <el-form :model="loginForm"  ref="loginFormRef" :rules="loginFormRules"  label-width="5em" label-position="left">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input show-password v-model="loginForm.password" placeholder="请输入密码"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer xgc-display-flex">
                    <el-button @click="loginDialogClosed" class="xgc-margin-left-auto">取 消</el-button>
                    <el-button type="primary" @click="login">确 定</el-button>
                </div>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: 'App',
        data() {
            return {
                activeIndex: '/',
                loginDialogVisible: false,
                loginForm: {
                    username: '',
                    password: ''
                },
                //登录表单验证规则
                loginFormRules:{
                    username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                    password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
                },
                isShowLoginButton: true,
                avatarUrl: ''
            }
        },
        methods: {
            loginDialogClosed() {
                this.$refs.loginFormRef.resetFields();
                this.loginDialogVisible = false;
            },
            login() {
                //在提交前先验证登录表单数据是否有效
                this.$refs.loginFormRef.validate(async valid => {
                    //有效就post表单
                    if (valid) {
                        const loginForm = new FormData();
                        loginForm.append("username", this.loginForm.username);
                        loginForm.append("password", this.loginForm.password);
                        const {data: res} = await this.$http.post('/login', loginForm);
                        if (res.status != 200){
                            this.$message.error(res.msg);
                        } else {
                            //将user对象存入到客户端的sessionStorage中
                            window.sessionStorage.setItem('user', this.objToString(res.data));
                            this.isShowLoginButton = false;
                            this.loginDialogVisible = false;
                            this.avatarUrl = res.data.avatarUrl;
                            this.$message.success(res.msg);
                        }
                    }
                })
            },
            showLoginedStatus() {
                if (this.checkIfLogin()) {
                    const user = this.strToObj(window.sessionStorage.getItem("user"));
                    this.isShowLoginButton = false;
                    this.avatarUrl = user.avatarUrl;
                }
            },
            objToString(obj) {
                return JSON.stringify(obj);
            },
            strToObj(str) {
                return JSON.parse(str);
            },
            checkIfLogin() {
                if (window.sessionStorage.getItem("user")) return true;
                else return false;
            },
            pushToPublish() {
                if (!this.checkIfLogin()) return this.$message.error("请先登录！")
            }
        },
        created() {
            this.showLoginedStatus();
        }
    }
</script>

<style lang="less" scoped>

</style>
