<template>
    <div class="xgc-main-container">
        <div class="xgc-content-container-full">
            <div class="xgc-padding-medium">
                <h1 style="text-align: center">{{essay.title}}</h1>

                <div id="content" v-html="essay.content"></div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Essay",
        data() {
            return {
                essay: {}
            }
        },
        props: ['eid'],
        methods: {
            async getEssayByEid(eid) {
                const {data: res} = await this.$http.get("/essay", {
                    params: {
                        eid: eid
                    }
                });
                if(res.status !== 200) return this.$message.error("获取文章信息失败");
                this.essay = res.data;
            }
        },
        watch: {
            eid: function (newValue) {
                this.getEssayByEid(newValue);
                window.sessionStorage.setItem("eid", newValue);
            }
        },
        created() {
            const eid = window.sessionStorage.getItem("eid");
            this.getEssayByEid(eid);
        }
    }
</script>

<style lang="less" scoped>

</style>