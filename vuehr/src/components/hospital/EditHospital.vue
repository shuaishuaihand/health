<template>
    <div class="all">
        <div class="head">
            <div class="title">
               <h2>医院信息表单<!--{{$route.params.hid}}--></h2>
            </div>
           <!--<div class="img">
              <img class="pre-img" :src="hospital.picture" alt="">
              <vue-core-image-upload :class="['pure-button','pure-button-primary','js-btn-crop']"
                                   :crop="false"
                                   text="上传图片"
                                   inputOfFile="file"
                                   url="http://localhost:5050/ftpuploadimg"
                                   extensions="png,gif,jpeg,jpg"
                                   @imageuploaded="imageuploaded"
                                   @errorhandle="handleError"></vue-core-image-upload>
           </div>-->
        </div>

        <div class="form-box">
            <el-form ref="form" :model="hospital" label-width="80px">

                <el-form-item label="医院编号">
                    <el-input v-model=" hospital.hid" placeholder="请输入内容" readonly></el-input>
                </el-form-item>

                <el-form-item label="医院名称">
                    <el-input v-model=" hospital.hname" placeholder="请输入内容" ></el-input>
                </el-form-item>

              <el-form-item label="图片">
                <div class="img">
                  <img class="pre-img" :src="hospital.picture" alt="">
                  <vue-core-image-upload :class="['pure-button','pure-button-primary','js-btn-crop']"
                                         :crop="false"
                                         text="上传图片"
                                         inputOfFile="file"
                                         url="http://localhost:5050/ftpuploadimg"
                                         extensions="png,gif,jpeg,jpg"
                                         @imageuploaded="imageuploaded"
                                         @errorhandle="handleError"></vue-core-image-upload>
                </div>
              </el-form-item>

                <el-form-item label="等级">
                    <el-select v-model=" hospital.grade" placeholder="请选择">
                        <el-option label="三级甲等" value="三级甲等"></el-option>
                        <el-option label="三级乙等" value="三级乙等"></el-option>
                        <el-option label="三级丙等" value="三级丙等"></el-option>
                        <el-option label="二级甲等" value="二级甲等"></el-option>
                        <el-option label="二级乙等" value="二级乙等"></el-option>
                        <el-option label="二级丙等" value="二级丙等"></el-option>
                        <el-option label="一级甲等" value="一级甲等"></el-option>
                        <el-option label="一级乙等" value="一级乙等"></el-option>
                        <el-option label="一级丙等" value="一级丙等"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="医院地址">
                    <el-input v-model=" hospital.address" placeholder="请输入内容"></el-input>
                </el-form-item>

                <el-form-item label="文本框">
                    <el-input type="textarea" v-model=" hospital.introduce" :rows="10"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">提交</el-button>
                    <el-button @click="cancel">取消</el-button>
                </el-form-item>
            </el-form>
        </div>

    </div>
</template>

<script>
    import VueCoreImageUpload  from 'vue-core-image-upload';
    export default {
        data: function(){
            return {
               hospital: {
                    hid:'',
                    hname:'',
                    grade:'',
                    address:'',
                    longitude:'',
                    latitude:'',
                    introduce:'',
                    picture: './static/img/hospital2.jpg'

                },
               // src: './static/img/hospital1.jpg',
                fileList: []
            }
        },
        components: {
            VueCoreImageUpload
        },
        created(){
            this.getData();
        },
        methods: {
            getData(){
                this.hid =this.$route.params.hid,
                this.$axios.get(`http://localhost:5050/getHospitalByHid/${this.hid}`).then(data=>{
                    if(data){
                       this.hospital= data.data
                    }
                })

            },
            handleChange(value) {
                    console.log(value);
            },
            updateHospital(hospital) {
                console.log(hospital.picture+"picture");
                this.$axios.put(`http://localhost:5050/editHospital`, JSON.stringify(hospital),{
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    }
                });
            },
            onSubmit() {
                /*    console.log("hospital"+JSON.stringify(this.hospital)),
                    console.log(this.hospital.hid),
                    console.log(this.hospital.hname),
                    console.log(this.hospital.grade),
                    console.log(this.hospital.address),
                    console.log(this.hospital.introduce),*/

                   this.updateHospital(this.hospital),  //将修改的数据提交到后台
                   this.$message.success('修改成功！');

                   this.$router.push({
                       path: '/hospitaltable'
                  })
            },
            cancel(){
                this.$router.push({      //跳转到医院列表主页面
                    path: '/hospitaltable'
                })

            },
          imageuploaded(res) {
            console.log("文件上传成功！");
            console.log(res+"123456");
            //上传至文件服务器
            // var imgpath="http://127.0.0.1:8089/"+res;
            this.hospital.picture="http://101.132.171.196/images/"+res;
            // this.src= 'http://101.132.186.20/images/99k.jpg';
            //C:\Users\Administrator\Desktop\vue-manage-system-master\static\img
            //  this.src='C:\Users\Administrator\Desktop\vue-manage-system-master\static\img\img.jpg';
            // this.src= 'F:\Springboot\demo\healthdemo\src\main\resources\static\imgupload\hospital2.jpg';
            //console.log(this.src)
          },
            handleError(){
                console.log("文件上传失败！");
                //this.src= 'F:\Springboot\demo\healthdemo\src\main\resources\static\imgupload\hospital2.jpg';
                this.$notify.error({
                    title: '上传失败',
                    message: '图片上传接口上传失败，可更改为自己的服务器接口'
                });
            }
        }
    }
</script>


<style>
  .all{
    height: 1000px;
    width:900px;
    text-align: center;
    margin: auto;
    margin-top: -5px
  }
  .title{
    height: 20px;
    width:400px;
    margin-top: 20px;
  }
  .form-box{
    height: 1000px;
    width:600px;
    margin: 0px auto;

  }
  .head{
    width: 800px;
    height:100px ;
    /* margin-top: 5px;*/
    margin: 5px auto;
  }
  .img{
    width: 170px;
    height:145px ;
    margin: 0px auto;

  }
  .pre-img{
    width:130px;
    height: 100px;
  }
</style>
