<template>
    <div class="xgc-main-container xgc-display-flex">
        <div class="xgc-content-container" v-infinite-scroll="load" :infinite-scroll-disabled="disabled" infinite-scroll-delay="500">
            <div class="xgc-fragment" v-for="essay in essayList" :key="essay.eid">
                <div class="xgc-media">
                    <div class="xgc-display-flex xgc-flex-direction-col xgc-justify-content-space-around">
                        <div class="xgc-title">
                            <span>{{ essay.title }}</span>
                        </div>
                        <div class="xgc-font-secondary">
                            <div class="essay-info xgc-display-flex xgc-align-items-center">
                                <img :src="baseUrl + essay.avatarUrl" alt="头像" class="xgc-img-mini xgc-border-round">
                                <span>{{essay.username}}</span>
                                <i class="iconfont icon-yanjing"></i>
                                <span>{{essay.view}}</span>
                                <i class="iconfont icon-icon_calendar_fill"></i>
                                <span>{{essay.updateTime | dateFormat}}</span>
                                <el-tag size="mini">{{essay.tagName}}</el-tag>
                            </div>
                        </div>
                    </div>
                    <div class="xgc-margin-left-auto">
                        <img src="@/assets/img/mediaImg.png" class="xgc-img-normal">
                    </div>
                </div>
                <el-divider></el-divider>
            </div>
        </div>
        <div class="xgc-aside xgc-font-secondary xgc-align-self-flex-start">
            <div class="xgc-content-container">
                <div class="author-info xgc-fragment xgc-display-flex xgc-flex-direction-col">
                    <span>Designed By XGC</span>
                    <span>Email:1307708161@qq.com</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "EssayList",
        data() {
            return {
                baseUrl: this.$http.defaults.baseURL,
                essayList: [],
                queryParam: {
                    pageNum: 0,
                    pageSize: 5
                },
                total: 0,
                disabled: false
            }
        },
        methods: {
            // async getEssayList() {
            //     const {data: res} = await this.$http.get('/essays')
            //     if (res.status !== 200) return this.$message.error("获取文章列表失败");
            //     this.essayList = res.data;
            // },
            async load() {
                this.queryParam.pageNum += 1;
                const {data: res} = await this.$http.get('/essays', {
                    params: {
                        pageNum: this.queryParam.pageNum,
                        pageSize: this.queryParam.pageSize
                    }
                });
                this.essayList = this.essayList.concat(res.data);
                if (this.queryParam.pageNum >= this.total) this.disabled = true;
            },
            async getTotal() {
                const {data: res} = await this.$http.get("/essaycount");
                this.total = Math.ceil(res.data/this.queryParam.pageSize);
            }
        },
        created() {
            // this.getEssayList();
            this.getTotal();
        }

    }
</script>

<style scoped>
    .author-info * {
        margin: 8px;
    }
</style>