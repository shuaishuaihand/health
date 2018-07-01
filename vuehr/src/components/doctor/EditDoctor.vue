<template>
    <div class="all">
        <div class="title">  <h2>医生信息编辑<!--{{$route.params.id}}--></h2></div>

        <div class="form-box">
            <el-form ref="form" :model="doctor" label-width="80px">

                <el-form-item label="医生姓名">
                    <el-input v-model="doctor.name" placeholder="请输入姓名"></el-input>
                </el-form-item>

              <el-form-item label="性别">
               <!-- <el-input v-model=" hospital.hname" placeholder="性别"></el-input>-->
                <el-radio-group v-model="doctor.gender">
                  <el-radio label="男"></el-radio>
                  <el-radio label="女"></el-radio>
                  <el-radio label="其他"></el-radio>
                </el-radio-group>
               </el-form-item>

               <el-form-item label="电话号码">
                <el-input v-model=" doctor.phone" placeholder="请输入手机号码"></el-input>
               </el-form-item>


              <el-form-item label="年龄">
                <el-input v-model="doctor.age" placeholder="请输入年龄"></el-input>
              </el-form-item>

              <el-form-item label="身份证号">
                <el-input v-model=" doctor.idnumber" placeholder="请输入身份证号"></el-input>
              </el-form-item>

              <el-form-item label="执业编号">
                <el-input v-model=" doctor.practicenumber" placeholder="请输入执业编号"></el-input>
              </el-form-item>

              <el-form-item label="职称">
                    <el-select v-model="doctor.professionaltitle" placeholder="请选择">
                        <el-option label="主任医师" value="主任医师"></el-option>
                        <el-option label="副主任医师" value="副主任医师"></el-option>
                        <el-option label="主治医师" value="主治医师"></el-option>
                    </el-select>
                </el-form-item>

              <el-form-item label="所属科室">
                <el-select v-model="doctor.department.did" placeholder="请选择">
                  <el-option
                    v-for="item in departmentlist"
                    :key="item.did"
                    :label="item.dname"
                    :value="item.did">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="医生介绍">
                    <el-input type="textarea" v-model="doctor.introduce" :rows="9"></el-input>
                </el-form-item>

              <el-form-item label="医生擅长">
                <el-input type="textarea" v-model="doctor.speciality" :rows="6"></el-input>
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
  /*  import ElInput from "../../../../node_modules/element-ui/packages/input/src/input";*/
    export default {
      /*  components: {ElInput},*/
        data: function(){
            return {
               doctor: {
                    id: '',
                    name:'',
                    idnumber:'',
                    practicenumber:'',
                    professionaltitle:'',
                    gender:'',
                    age:'',
                    phone:'',
                    speciality: '',
                    introduce: '',
                    department:{
                        did:'',
                        dname:'',
                        introduce:'',
                        doctorList:[]
                    },
                    dialogImageUrl: '',
                    dialogVisible: false

                }
            }
        },
        created(){
           this.getData();
        },
        methods: {
           getData(){
            /* 获取医院科室集合的接口*/
              this.$axios.get(`http://localhost:5050/getDepartmentDnamelistByHid/${this.$store.state.user.hid}`).then(data=>{
                if(data){
                  this.departmentlist= data.data
                  console.log(this.departmentlist[0].dname+"data2222")
                }
              })


             /* 根据医生id 获取医生信息的接口*/
              this.id =this.$route.params.id;
              console.log(this.id+"idtest111111111");
              this.$axios.get(`http://localhost:5050/getDoctorById/${this.id}`).then(data=>{
                if(data){
                  this.doctor= data.data;
                  console.log(this.doctor.department.did+"d121111")
                }
              })

          },
          handleChange(value) {
                    console.log(value);
          },
          updateDoctor(doctor) {
            console.log(doctor.dname+"dname");
            this.$axios.put(`http://localhost:5050/editDoctor`, JSON.stringify(doctor),{
              headers: {
                'Content-Type': 'application/json;charset=UTF-8'
              }
            });
          },
            onSubmit() {

                //将 userlocation的经纬度，赋值给hospital的longitude和 latitude经纬度属性
               /* this.hospital.longitude=this.userlocation.lng;
                this.hospital.latitude=this.userlocation.lat;*/

                console.log("test2222222");

                       this.updateDoctor(this.doctor), //将添加的数据提交到后台
                this.$message.success('添加成功！');

               this.$router.push({      //跳转到医院列表主页面
                    path: '/doctortable'
                })

            },

            cancel(){
                this.$router.push({      //跳转到医院列表主页面
                    path: '/doctortable'
                })

            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },
            uploadSuccess(response, file, fileList){
                console.log(response+"response1")
                this.hospital.picture=response;

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
        margin-top: 30px
    }
    .title{
        height: 20px;
        width:900px;
    }
    .form-box{
        height: 1000px;
        width:600px;
        margin: 60px auto;

    }
    #addressmap{
        width: 520px;
        height: 250px;
        margin-top: 10px;
        margin-bottom: -10px;
        border:1px solid gray;
    }
    .addressinput{
        width: 520px;
        height: 35px;
    }
</style>
