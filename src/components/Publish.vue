<template>
    <div class="xgc-content-container-full">
        <div class="xgc-overflow-hidden">
            <el-form label-width="80px" label-position="left">
                <el-form-item label="文章标题">
                    <el-input></el-input>
                </el-form-item>
                <el-form-item>
                    <markdown-editor></markdown-editor>
                </el-form-item>
                <el-form-item label="展示图片">
                    <el-upload>
                        <el-button size="small" type="primary">点击上传</el-button>
                    </el-upload>
                </el-form-item>
                <el-form-item class="xgc-display-inline-block">
                    <el-select multiple placeholder="请选择文章标签">
                    </el-select>
                </el-form-item>
                <el-form-item class="xgc-display-inline-block xgc-float-right">
                    <el-button class="xgc-margin-left-auto" type="warning">草稿</el-button>
                    <el-button type="primary">发布</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>


<script>
    import MarkdownEditor from "@/components/MarkdownEditor";

    export default {
        name: "Publish",
        components: {MarkdownEditor}
    }
</script>

<style lang="less" scoped>
    .el-form {
        margin: 20px;
    }
</style>