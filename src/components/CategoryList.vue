<template>
    <div class="xgc-main-container xgc-display-flex">
        <div class="xgc-content-container" v-infinite-scroll="load" :infinite-scroll-disabled="disabled" infinite-scroll-delay="300">
            <div class="xgc-fragment" v-for="essay in essayList" :key="essay.eid">
                <div class="xgc-media">
                    <div class="xgc-display-flex xgc-flex-direction-col xgc-justify-content-space-around">
                        <a class="xgc-title" :href="'/#/essay/' + essay.eid" @click="saveEid(essay.eid)">
                            <span>{{ essay.title }}</span>
                        </a>
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
        <div class="xgc-aside xgc-align-self-flex-start">
            <el-menu :default-active="activeItem" v-for="tag in tagList" :key="tag.tid">
                <el-menu-item :index="tag.tid.toString()" @click="setActiveItem(tag.tid)"> {{tag.tagName}}</el-menu-item>
            </el-menu>
        </div>
    </div>
</template>

<script>
    export default {
        name: "CategoryList",
        data() {
            return {
                baseUrl: this.$http.defaults.baseURL,
                tagList: [],
                activeItem: null,
                essayList: [],
                queryParam: {
                    pageNum: 1,
                    pageSize: 5,
                    tid: -1
                },
                disabled: false,
                count: 0
            }
        },
        methods: {
            async getTagList() {
                const {data: res} = await this.$http.get("/taglist");
                if (res.status !== 200) return this.$message.error("获取分类列表失败");
                this.tagList = res.data;
                this.activeItem = this.tagList[0].tid.toString();
                this.queryParam.tid = this.tagList[0].tid;
                // console.log("taglist-->" + this.queryParam.tid)
                this.getEssayList();
                this.getEssayCount();
            },
            setActiveItem(tid) {
                this.activeItem = tid.toString();
                this.queryParam.tid = tid;
                this.getEssayList();
                this.getEssayCount();
            },
            async getEssayList() {
                // console.log("essaylist-->" + this.queryParam.tid)
                const {data: res} = await this.$http.get("essaysbytid", {
                    params: {
                        pageNum: this.queryParam.pageNum,
                        pageSize: this.queryParam.pageSize,
                        tid: this.queryParam.tid
                    }
                });
                if (res.status !== 200) return this.$message.error("获取文章列表失败");
                this.essayList = res.data;
            },
            async getEssayCount() {
                this.queryParam.pageNum = 1;
                const {data: res} = await this.$http.get("essaybytidcount", {
                    params: {
                        tid: this.queryParam.tid
                    }
                })
                if (res.status !== 200) return this.$message.error("获取文章总数失败");
                this.count = res.data;
                console.log(this.count);
            },
            async load() {
                this.queryParam.pageNum += 1;
                const {data: res} = await this.$http.get('/essaysbytid', {
                    params: {
                        pageNum: this.queryParam.pageNum,
                        pageSize: this.queryParam.pageSize,
                        tid: this.queryParam.tid
                    }
                });
                this.essayList = this.essayList.concat(res.data);
                if (this.queryParam.pageNum >= this.total) this.disabled = true;
            },
            saveEid(eid) {
                window.sessionStorage.setItem("eid", eid);
            }
        },
        created() {
            this.getTagList();
        },
        computed: {
            // getDefaultIndex() {
            //     if (this.tagList[0] !== undefined) {
            //         return this.tagList[0].tid.toString();
            //     }
            //     return null;
            // }
        }
    }
</script>

<style lang="less" scoped>

</style>