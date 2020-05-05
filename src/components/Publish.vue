<template>
    <div class="xgc-main-container xgc-bg-color-white">
        <div class="xgc-content-container-8 xgc-margin-auto">
            <el-form label-width="80px" label-position="left">
                <el-form-item label="文章标题">
                    <el-input></el-input>
                </el-form-item>
                <el-form-item label="content">
<!--                    <div id="editor">-->
<!--                        <textare style="display: none;">### input essay contenta</textare>-->
<!--                    </div>-->
                </el-form-item>
                <el-form-item label="展示图片">
                    <el-input></el-input>
                </el-form-item>
                <el-form-item class="xgc-display-inline-block">
                    <el-select multiple placeholder="请选择文章标签">
                    </el-select>
                </el-form-item>
                <el-form-item class="xgc-display-inline-block xgc-float-right">
                    <el-button class="xgc-margin-left-auto">草稿</el-button>
                    <el-button>发布</el-button>
                </el-form-item>
                </el-form>
        </div>
    </div>
</template>


<script>
    export default {
        name: "Publish"
    }
</script>

<style scoped>

</style>