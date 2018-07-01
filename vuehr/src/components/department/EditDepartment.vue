<template>
    <div class="all">
        <div class="title"><h2>编辑科室信息

        <!-- {{$route.params.did}}-->
        </h2></div>

        <div class="form-box">
            <el-form ref="form" :model="department" label-width="80px">


                <el-form-item label="科室编号">
                    <el-input v-model="department.did" placeholder="请输入内容" readonly="true"></el-input>
                </el-form-item>

                <el-form-item label="科室名称">
                    <el-input v-model=" department.dname" placeholder="请输入内容" readonly="true"></el-input>
                </el-form-item>

                <el-form-item label="科室介绍">
                    <el-input type="textarea" v-model=" department.introduce" :rows="13"></el-input>
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
                department: {
                    did: '',
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
                this.did =this.$route.params.did,
                this.$axios.get(`http://localhost:5050/getDepartmentByDid/${this.did}`).then(data=>{
                    if(data){
                       this.department= data.data;
                       console.log(JSON.stringify(this.department)+"depaerment")
                    }
                })

            },
            handleChange(value) {
                    console.log(value);
            },
            updateDepartment(department) {
                this.$axios.put(`http://localhost:5050/editDepartment`, JSON.stringify(department),{
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    }
                }).then(response=>{
                    if(response.status==200){
                        this.$message.success('修改成功！');

                        //修改成功，则跳转到科室列表
                        this.$router.push({
                          path:'/departmenttable'
                        })
                    }
                });
            },
            onSubmit() {

                   //将修改的数据提交到后台
                   this.updateDepartment(this.department)

            },
            cancel(){
                this.$router.push({      //跳转到医院列表主页面
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
