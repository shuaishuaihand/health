<template>
    <div class="all">
        <div class="title"> <h2><!--{{$route.params.hid}}-->创建科室信息</h2></div>

        <div class="form-box">
            <el-form ref="form" :model="department" label-width="80px">

              <el-form-item label="科室名称">
                <el-select v-model="department.did" placeholder="请选择">
                  <el-option
                    v-for="item in departmentlist"
                    :key="item.did"
                    :label="item.dname"
                    :value="item.did">
                  </el-option>
                  <!--<el-option label="儿科" value="儿科"></el-option>
                  <el-option label="脑科" value="脑科"></el-option>
                  <el-option label="骨科" value="骨科"></el-option>-->
                </el-select>
              </el-form-item>

                <el-form-item label="科室介绍">
                    <el-input type="textarea" v-model="department.introduce" :rows="13"></el-input>
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
    export default {
        data: function(){
            return {
              departmentlist: [],

              department:{
                 did:'',
                 dname:'',
                 introduce:'',
                 hid:''
             }
            }
        },
      created(){
        this.getData();
       },

      methods: {
          getData(){
              this.$axios.get(`http://localhost:5050/getDepartmentDnamelist`).then(data=>{
                if(data){
                  this.departmentlist= data.data
                  console.log(this.departmentlist+"data1111111")
                }
              })

          },
            handleChange(value) {
                    console.log(value);
            },
            createDepartment(department) {
                this.department.hid= this.$route.params.hid;
                this.$axios.post(`http://localhost:5050/addDepartment`, JSON.stringify(department),{
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    }
                }).then(response=>{
                    console.log(JSON.stringify(response)+"response==================================");
                    console.log(response.status+"response status");
                    console.log(response.data+"response data");
                    if(response.data==true){
                        console.log("success!");
                        this.$message.success('添加成功！');

                             //添加成功后，跳转到科室列表主页面
                            this.$router.push({
                               path:'/departmenttable'
                             })



                    }else{
                        this.$message.success('添加失败！');   //待优化，前端需js判断
                        console.log("insert error8888888888888888888888888888888888888888888888888");
                    }
                });
            },
            onSubmit() {
                   /* console.log("hospital"+JSON.stringify(this.hospital)),
                    console.log(this.hospital.hid),
                    console.log(this.hospital.hname),
                    console.log(this.hospital.grade),
                        console.log(this.hospital.address),
                        console.log(this.hospital.introduce),*/
                       this.department.hid=this.$route.params.hid;
                       this.createDepartment(this.department) //将添加的数据提交到后台



            },

            cancel(){
                this.$router.push({       //跳转到科室列表主页面
                  path:'/departmenttable'
                })

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
</style>
