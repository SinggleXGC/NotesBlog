<template>
    <div class="markdown-editor">
        <div id="editor">
            <textarea style="display: none;" id="content">### input essay content</textarea>
        </div>
    </div>
</template>

<script>
    import $script from 'scriptjs'

    export default {
        name: "MarkdownEditor",
        data() {
            return {
                // publicPath: process.env.BASE_URL,
                instance: null
            }
        },
        props: {
            editorPath: {
                type: String,
                default: '/editor.md/'
            },
            editorConfig: {
                type: Object,
                default() {
                    return {
                        width: '100%',
                        height: 530,
                        path: '/editor.md/lib/',
                        codeFold: true,
                        saveHTMLToTextarea: true,
                        searchReplace: true,
                        htmlDecode: 'style,script,iframe|on*',
                        emoji: true,
                        taskList: true,
                        tocm: true,                  // Using [TOCM]
                        tex: true,                   // 开启科学公式TeX语言支持，默认关闭
                        flowChart: true,             // 开启流程图支持，默认关闭
                        sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
                        // imageUpload: true,
                        // imageFormats: ['jpg', 'jpeg', 'gif', 'png', 'bmp', 'webp'],
                        // imageUploadURL: 'examples/php/upload.php',
                        // onload: () => {
                            // eslint-disable-next-line
                            // console.log('onload', this);
                        // }
                    };
                }
            }
        },
        mounted() {
            // async loading js dependencies
            // editormd depdend on jquery and zepto
            $script([
                `${this.editorPath}js/jquery.min.js`,
                `${this.editorPath}js/zepto.min.js`,
            ], () => {
                $script(`${this.editorPath}js/editormd.min.js`, () => {
                    this.initEditor();
                });
            });
        },
        methods: {
            initEditor() {
                // eslint-disable-next-line
                this.$nextTick((editorMD = window.editormd) => {
                    if (editorMD) {
                        // Vue 异步执行 DOM 更新，template 里面的 script 标签异步创建
                        // 所以，只能在 nextTick 里面初始化 editor.md
                        this.instance = editorMD('editor', this.editorConfig);
                    }
                });
            },
            getContent() {
                const content = document.getElementById('content').value;
                return content;
            }
        }
    }
</script>

<style scoped>
    .markdown-editor {
        width: 100%;
        height: 100%;
        margin-top: 100px;
    }
</style>