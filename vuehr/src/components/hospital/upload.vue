<template>
    <div>
        <el-upload
            action="http://localhost:5050/uploadimg"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove">
            <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible" size="tiny">
           <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
   </div>
</template>
<script>
    export default {
        data() {
            return {
                dialogImageUrl: '',
                dialogVisible: false
            };
        },
        methods: {
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            }
        }
    }
</script>
