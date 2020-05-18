<template>
    <div class="xgc-content-container-full">
        <div class="xgc-overflow-hidden">
            <el-form label-width="80px" label-position="left">
                <el-form-item label="文章标题">
                    <el-input v-model="title"></el-input>
                </el-form-item>
                <el-form-item>
                    <markdown-editor ref="editor"></markdown-editor>
                </el-form-item>
                <el-form-item label="展示图片">
                    <el-upload :action="uploadimg" :file-list="imgList" list-type="picture" :limit="1"
                               :on-exceed="fileLimit" :on-success="uploadImgSuccess" :on-remove="removeFile">
                        <el-button size="small" type="primary">点击上传</el-button>
                    </el-upload>
                </el-form-item>
                <el-form-item class="xgc-display-inline-block">
                    <el-select v-model="tid" filterable allow-create default-first-option placeholder="请选择文章标签" ref="tagSelect">
                        <el-option v-for="tag in essayTagList" :key="tag.tid" :label="tag.tagName" :value="tag.tid">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item class="xgc-display-inline-block xgc-float-right">
                    <el-button class="xgc-margin-left-auto" type="warning">草稿</el-button>
                    <el-button type="primary" @click="publishEssay">发布</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>


<script>
    import MarkdownEditor from "@/components/MarkdownEditor";

    export default {
        name: "Publish",
        components: {MarkdownEditor},
        data() {
            return {
                essayTagList: [],
                tid: '',
                uploadimg: this.$http.defaults.baseURL + '/uploadimg',
                imgList: [],
                title: ''
            }
        },
        methods: {
            async getTagList() {
                const {data: res} = await this.$http.get('/taglist');
                this.essayTagList = res;
            },
            async uploadImgSuccess(response) {
                const {data: res} = await response;
                this.imgList.push(res);
            },
            fileLimit() {
                this.$message.error("只能上传一张首图");
            },
            removeFile() {
                this.imgList.pop();
            },
            async commonPublish(isPublish) {
                const publishForm = new FormData();

                if(this.title === '') return this.$message.error('标题不能为空');
                publishForm.append("title", this.title);

                const content = this.$refs.editor.getContent();
                publishForm.append("content", content);

                if (this.$refs.tagSelect.createdLabel !== null) {
                    const tagName = new FormData();
                    tagName.append("tagName", this.$refs.tagSelect.createdLabel);
                    const {data: res} =await this.$http.post('/addtag', tagName);
                    if (res.status !== 200) {
                        return this.$message.error(res.msg);
                    }
                    publishForm.append("tid", res.data);
                }else {
                    publishForm.append("tid", this.tid);
                }

                if (this.imgList.length === 0) {
                    publishForm.append("showPicture", '');
                } else {
                    publishForm.append("showPicture", this.imgList[0].url);
                }

                const user = this.strToObj(window.sessionStorage.getItem("user"));
                publishForm.append("uid", user.uid);

                publishForm.append("isPublish", isPublish);

                const {data: res} = await this.$http.post("/publish", publishForm);
                if (res.status !== 200) return this.$message.error(res.msg);
                this.$message.success(res.msg);

                this.$router.push('/index');
            },
            publishEssay() {
                this.commonPublish(true);
            },
            strToObj(str) {
                return JSON.parse(str);
            },
        },
        created() {
            this.getTagList();
        }
    }
</script>

<style lang="less" scoped>
    .el-form {
        margin: 20px;
    }
</style>