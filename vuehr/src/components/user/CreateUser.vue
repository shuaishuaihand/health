<template>
    <div class="all">
        <div class="title">  <h2>系统用户信息表单</h2></div>

        <div class="form-box">
            <el-form ref="form" :model="user" label-width="80px">

                <el-form-item label="中文名">
                    <el-input v-model="user.name" placeholder="请输入姓名"></el-input>
                </el-form-item>
                <el-form-item label="英文名">
                <el-input v-model="user.username" placeholder="请输入年龄"></el-input>
                </el-form-item>
              <el-form-item label="性别">
              <!-- <el-input v-model=" hospital.hname" placeholder="性别"></el-input>-->
              <el-radio-group v-model="user.gender">
                <el-radio label="男"></el-radio>
                <el-radio label="女"></el-radio>
                <el-radio label="其他"></el-radio>
              </el-radio-group>
              </el-form-item>

                <el-form-item label="手机">
                <el-input v-model="user.phone" placeholder="请输入手机号码"></el-input>
                </el-form-item>

              <el-form-item label="电话号码">
                <el-input v-model="user.telephone" placeholder="请输入手机号码"></el-input>
              </el-form-item>

              <el-form-item label="是否禁用">
                <el-select v-model="user.enabled" placeholder="请选择">
                  <el-option label="是" value="0"></el-option>
                  <el-option label="否" value="1"></el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="所在医院">
                <el-select v-model="user.hid" placeholder="请选择">
                  <el-option
                    v-for="item in hospitallist"
                    :key="item.hid"
                    :label="item.hname"
                    :value="item.hid">
                  </el-option>
                </el-select>
              <!--  <el-select v-model="user.hname" placeholder="请选择">
                  <el-option label="主任医师" value="主任医师"></el-option>
                  <el-option label="副主任医师" value="副主任医师"></el-option>
                  <el-option label="主治医师" value="主治医师"></el-option>
                </el-select>-->
              </el-form-item>
              <el-form-item label="角色">
                  <el-select v-model="user.role.rid" placeholder="请选择">
                    <el-option
                      v-for="item in userrolelist"
                      :key="item.rid"
                      :label="item.nameZh"
                      :value="item.rid">
                    </el-option>
                  </el-select>
              </el-form-item>

              <el-form-item label="居住地址">
                <el-input v-model="user.address" placeholder="请输入手机号码"></el-input>
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
               user: {
                    id: '',
                    name:'',
                    phone:'',
                    telephone:'',
                    address:'',
                    enabled:'',
                    username:'',

                    hid: '',
                    hname: '',
                    role:{
                      rid:'',
                      name: '',
                      nameZh: ''
                    }
                },
              hospitallist:[],
              userrolelist:[],
              dialogImageUrl: '',
              dialogVisible: false
            }
        },
       created(){
         this.getData();
       },
        methods: {
          getData(){
            //获取所有医院信息接口
            this.$axios.get(`http://localhost:5050/findAllHospital`).then(data=>{
              if(data){
                this.hospitallist= data.data
                console.log(JSON.stringify(this. hospitallist)+"data2222")
              }
            })

            //获取所有角色（role）接口
            this.$axios.get(`http://localhost:5050/findAllUserRole`).then(data=>{
              if(data){
                this.userrolelist= data.data
                console.log(JSON.stringify(this.userrolelist)+"data2222")
              }
            })

          },
            handleChange(value) {
                    console.log(value);
            },
            createUser(user) {
                this.$axios.post(`http://localhost:5050/addUser`, JSON.stringify(user),{
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    }
                });
            },
            onSubmit() {

                //将 userlocation的经纬度，赋值给hospital的longitude和 latitude经纬度属性
               /* this.hospital.longitude=this.userlocation.lng;
                this.hospital.latitude=this.userlocation.lat;*/

                console.log("test111111111");

                       this.createUser(this.user), //将添加的数据提交到后台
                this.$message.success('添加成功！');

               this.$router.push({      //跳转到医院列表主页面
                    path: '/usertable'
                })

            },

            cancel(){
                this.$router.push({      //跳转到医院列表主页面
                    path: '/usertable'
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
