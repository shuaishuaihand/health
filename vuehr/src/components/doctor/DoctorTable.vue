<template>
    <div class="table">
        <div class="crumbs">
          <!--  <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-message"></i> 表格</el-breadcrumb-item>
                <el-breadcrumb-item>  {{$route.params.hid}}医生信息列表&lt;!&ndash;{{this.tableData[0].hid}}&ndash;&gt;</el-breadcrumb-item>
            </el-breadcrumb>-->
        </div>
        <div class="handle-box">
            <el-input v-model="select_word" placeholder="筛选关键词" class="handle-input mr10"></el-input>
            <el-button type="primary" icon="search" @click="search">搜索</el-button>
            <el-button type="primary" class="handle-insert mr10">
               <!-- <router-link :to="{name:'createdepartment',params:{hid:101}}">新增</router-link>-->
              <router-link to="/createdoctor">新增</router-link>
            </el-button>
        </div>
        <el-table :data="tableData" border style="width: 100%" ref="multipleTable" @selection-change="handleSelectionChange">
            <el-table-column prop="name" label="姓名" width="80">
            </el-table-column>
            <el-table-column prop="idnumber" label="身份证号" >
            </el-table-column>
            <el-table-column prop="practicenumber" label="职业编号" >
            </el-table-column>
            <el-table-column prop="professionaltitle" label="职称" >
            </el-table-column>
            <el-table-column prop="gender" label="性别" width="65">
            </el-table-column>
            <el-table-column prop="age" label="年龄" width="65">
            </el-table-column>
            <el-table-column prop="phone" label="电话号码" >
            </el-table-column>
            <el-table-column prop="speciality" label="医生擅长" >
            </el-table-column>
            <el-table-column prop="introduce" label="医生介绍" >
            </el-table-column>
            <el-table-column prop="department.dname" label="所在科室" width="95">
            </el-table-column>

            <el-table-column label="操作" width="200">
                <template scope="scope">
                    <el-button size="small"
                            @click="handleEdit(scope.$index, scope.row)"><!--<router-link :to="{name:'edithospital',params:{hid:101}}">编辑</router-link>-->
                        编辑
                    </el-button>
                    <el-button size="small" type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div class="pagination">
            <el-pagination
                    @current-change ="handleCurrentChange"
                    layout="prev, pager, next"
                    :current-page="1"
                    :page-size="pagesize"
                    :total="total">
            </el-pagination>

        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                url: './static/vuetable1.json',
                //url: 'http://localhost:5050/',
                tableData: [],
                total:1000,
                hid:'',
                cur_page: 1,
                pagesize: 5,
                page:'',
                multipleSelection: [],
                select_cate: '',
                select_word: '',
                del_list: [],
                did_list:[],
                is_search: false
            }
        },
       created(){
             this.getData();
        },

       watch:{    //监听 select_word发生改变后，调用模糊查询方法
            select_word:function () {
                if (this.select_word == ""||this.select_word ==null) {  //当搜索框为空时，获取所有数据
                    this.getData();
                } else {
                    this.likeselect(); //根据搜索框的值，进行模糊查询
                }
            }
        },
        methods: {

          handleCurrentChange(val){
                this.cur_page = val;
                console.log(this.cur_page+"this.cur_page555555555555555555");

               this.getData();


            },
            getData(){
                this.hid=this.$store.state.user.hid;
                this.$axios.get(`http://localhost:5050/findAllDoctorPage/${this.hid}?page=${this.cur_page}&size=${this.pagesize}`).then(data=>{
                    if(data){
                        console.log(3333333333333333333333333333333333333333333333333333333);
                        console.log(JSON.stringify(data.data.pagedoctordata));
                        console.log(data.data.total+"total");
                        this.total=data.data.total;
                        this.tableData=data.data.pagedoctordata;
                    }
                })

            },
            insertDepartment(){
                this.$router.push({
                    path: '/createdepartment'
                })

            },

            search(){  //点击搜索按钮后调用，模糊查询接口

               //调用后台模糊查询接口的方法
                this.likeselect();


            },

            likeselect(){
                //调用后台模糊查询接口
                this.$axios.get(`http://localhost:5050/getDoctorLike/${this.select_word}`).then(data=> {
                    if (data) {
                        this.tableData = data.data;
                    }
                })
            },
           handleEdit(index, row) {
               console.log(row.id+"row.didtest------------");
           /*    console.log(row.did+"row.hidtest------------");*/
                this.$router.push({
                  /*path: '/editdoctor'*/
                     name: 'editdoctor',
                     params: {
                         id: row.id
                    }
                })

            },
            handleDelete(index, row) {
                console.log(index+"index");
                console.log(row.id+"row");
                this.$axios.delete(`http://localhost:5050/deleteDoctor/${row.id}`).then(response=>{
                    const status = response.status;
                    console.log(status+"status");
                    if(status===200){
                        this.$message.success('成功删除编号为'+(row.id)+'的科室信息');
                        this.getData();
                    }else{
                        this.$message.success('失败删除编号为'+(row.id)+'的科室信息');
                    }
                });


            },
            delAll(){
                const self = this,
                    length = self.multipleSelection.length; //self.multipleSelection是选中的科室元素的数组

                let str = '';                 //拼接str,作为下面$message信息提示框的内容
                self.del_list = self.del_list.concat(self.multipleSelection);
                for (let i = 0; i < length; i++) {
                    str += self.multipleSelection[i].did + ' ';    //连接两个数组concat，将multipleSelection数组拼接到del_list后面
                    self.did_list.push(self.multipleSelection[i].did);     //将multipleSelection中的所有对象的did,放在一个数组中，转入后台
                }

                //调用后台接口删除，批量删除hid_list集合对应的医院信息
                this.batchdelete(self.did_list,str);

            },

            batchdelete(idlist,str){
                this.$axios.post(`http://localhost:5050/batchdeleteDepartment`,JSON.stringify(idlist),{
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    }

                }).then(response=>{
                    const status = response.status;
                    console.log(status+"status1111111111111111111111111");
                   if(status===200){
                        this.$message.success('删除编号为'+str+'的医院信息');
                        this.getData();
                    }
                });
            },

            handleSelectionChange(val) {     //监听事件改变
                this.multipleSelection = val;
            }
        }
    }
</script>

<style scoped>
.handle-box{
    margin-top: 50px;
  /*  margin-left:400px;*/
    margin-bottom: 20px;
}
.handle-insert{
    margin-left: 560px;
}
.handle-select{
    width: 120px;
}
.handle-input{
    width: 380px;
    display: inline-block;
}
</style>
