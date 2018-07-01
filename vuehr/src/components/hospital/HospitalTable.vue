<template>
    <div class="table">
        <div class="handle-box">
            <el-select v-model="select_cate" placeholder="筛选省份" class="handle-select mr10">
                <el-option key="1" label="广东省" value="广东省"></el-option>
                <el-option key="2" label="湖南省" value="湖南省"></el-option>
            </el-select>
            <el-input v-model="select_word" placeholder="筛选关键词" class="handle-input mr10"></el-input>
            <el-button type="primary" icon="search" @click="search">搜索</el-button>
            <el-button type="primary" class="handle-insert mr10" @click="insertHospital"><!--<router-link to="/createhospital">新增</router-link>-->新增</el-button>
        </div>
        <el-table :data="tableData" border style="width: 100%" ref="multipleTable" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="hid" label="编号" >
            </el-table-column>
            <el-table-column prop="hname" label="名称" >
            </el-table-column>
            <el-table-column prop="grade" label="等级" >
            </el-table-column>
            <el-table-column prop="address" label="地址" >
            </el-table-column>
            <el-table-column prop="longitude" label="经度" >
            </el-table-column>
            <el-table-column prop="latitude" label="维度" >
            </el-table-column>

            <el-table-column label="操作" width="300">
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
  import {getRequest} from '../../utils/api'
    export default {
        data() {
            return {
                url: './static/vuetable1.json',
                //url: 'http://localhost:5050/',
                tableData: [],
                total:1000,
                cur_page: 1,
                pagesize: 5,
                page:'',
                multipleSelection: [],
                select_cate: '',
                select_word: '',
                del_list: [],
                hid_list:[],
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
      /*computed: {
            data(){
                const self = this;
                return
                    self.select_word
               /!* return self.tableData.filter(function(d){*!/

                    /!*let is_del = false;
                    for (let i = 0; i < self.del_list.length; i++) {
                        if(d.name === self.del_list[i].name){
                            is_del = true;
                            break;
                        }
                    }
                    if(!is_del){
                        if(d.address.indexOf(self.select_cate) > -1 &&
                            (d.name.indexOf(self.select_word) > -1 ||
                            d.address.indexOf(self.select_word) > -1)
                        ){
                            return d;
                        }
                    }*!/
               /!* })*!/
            }
        },*/
        methods: {
          handleCurrentChange(val){
                this.cur_page = val;
                console.log(this.cur_page+"this.cur_page");

               this.getData();


            },
            /*getData(){
                this.$axios.get(`http://localhost:5050/findAllHospital`).then(data=>{
                    if(data){
                        console.log(4444444444444444444444444444444444444444444444444444444444444444444444444444444444444);
                        console.log(data.data[0]);
                        this.tableData=data.data;
                        console.log(this.tableData[0].hid+"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

                        //处理hospital的grade等级属性for switch
                        /!*for(var i=0;i< this.tableData.length;i++){
                            var hid= this.tableData[i].grade;
                            var x;
                            var d=2;
                            switch (hid)
                            {
                                case 0:
                                  x="Today it's Sunday";
                                    break;
                                case 1:
                                    x="Today it's Monday";
                                    break;
                                case 2:
                                   x="Today it's Tuesday";
                                    break;
                            }
                            console.log(x+"XXXxX");
                            /!*switch(hid){
                                case 1:
                                    this.tableData[i].grade="三级甲等";
                                    console.log(this.tableData[i].grade+"7");
                                    break;
                                case 2:
                                    this.tableData[i].grade="三级乙等";
                                    break;
                                case 3:
                                    this.tableData[i].grade="三级丙等";
                                    break;
                                case 4:
                                    this.tableData[i].grade="二级甲等";
                                    break;
                                case 5:
                                    this.tableData[i].grade="二级乙等";
                                    break;
                                case 6:
                                    this.tableData[i].grade="二级丙等";
                                    break;
                                case 7:
                                    this.tableData[i].grade="一级甲等";
                                    break;
                                case 8:
                                    this.tableData[i].grade="一级乙等";
                                    break;
                                case 9:
                                    this.tableData[i].grade="一级丙等";
                                    break;
                            }*!/
                            console.log(this.tableData[i].grade+"6");

                        }*!/





                    }
                })

            },*/
           getData(){
                this.$axios.get(`http://localhost:5050/findAllHospitalPage?page=${this.cur_page}&size=${this.pagesize}`).then(data=>{
                    if(data){
                        console.log(3333333333333333333333333333333333333333333333333333333);
                        console.log(JSON.stringify(data.data.pagehospitaldata));
                        console.log(data.data.total+"total");
                        this.total=data.data.total;
                        this.tableData=data.data.pagehospitaldata;
                        console.log(this.tableData[0].hid+"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
                    }
                })

            },
         /* getData(){
              getRequest(`http://localhost:5050/findAllHospitalPage?page=${this.cur_page}&size=${this.pagesize}`).then(resp=> {
                      if (resp && resp.status == 200) {
                        console.log(3333333333333333333333333333333333333333333333333333333);
                        console.log(JSON.stringify(resp.data.pagehospitaldata));
                        console.log(resp.data.total+"total");
                        this.total=resp.data.total;
                        this.tableData=resp.data.pagehospitaldata;
                        console.log(this.tableData[0].hid+"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
                 }
               })
          },*/

            insertHospital(){
                this.$router.push({
                    path: '/createhospital'
                })

            },

            search(){
               console.log(this.select_word+'this.select_word');

                //调用后台模糊查询接口的方法
                this.likeselect();

              this.is_search = true;

            },

            likeselect(){
                //调用后台模糊查询接口
                this.$axios.get(`http://localhost:5050/getHospitalLike/${this.select_word}`).then(data=> {
                    if (data) {
                        console.log(data.data[0]);
                        this.tableData = data.data;
                        console.log(this.tableData[0].hid + "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
                    }
                })
            },
            formatter(row, column) {
                return row.address;
            },
            filterTag(value, row) {
                return row.tag === value;
            },
           handleEdit(index, row) {
                console.log(row.hid+"row111111111111111111");
                this.$router.push({
                     name: 'edithospital',
                     params: {
                       hid: row.hid
                    }
                })

            },
          handleHospitalDetail(index, row) {
            console.log(row.hid+"detail111111111111111111");
            this.$router.push({
              name: 'departmenttable',
              params: {
                hid: row.hid
              }
            })
          },
          handleDelete(index, row) {
                console.log(index+"index");
                console.log(row.hid+"row");
                this.$axios.delete(`http://localhost:5050/deleteHospital/${row.hid}`).then(response=>{
                    const status = response.status;
                    console.log(status+"status");
                    if(status===200){
                        this.$message.success('删除编号为'+(row.hid)+'的医院信息');
                        this.getData();
                    }
                });


            },
            delAll(){
                const self = this,
                    length = self.multipleSelection.length;

                console.log(JSON.stringify(self.multipleSelection[0])+"self.multipleSelection");
                console.log(length+"length");

                let str = '';
                self.del_list = self.del_list.concat(self.multipleSelection);   //连接两个数组concat，将multipleSelection数组拼接到del_list后面
                for (let i = 0; i < length; i++) {
                    str += self.multipleSelection[i].hid + ' ';
                }

                //将multipleSelection中的所有对象的hid,放在一个数值中
                for (let i = 0; i < length; i++) {
                    self.hid_list.push(self.multipleSelection[i].hid);
                }
                console.log("0000000000000000000000000000000000000000");
                console.log(self.hid_list+"self.hid_list");


                self.$message.error('删除了'+str);

                //调用后台接口删除，批量删除hid_list集合对应的医院信息
                this.batchdelete(self.hid_list,str);

            },

            batchdelete(idlist,str){
                this.$axios.post(`http://localhost:5050/batchdeleteHospital`,JSON.stringify(idlist),{
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
    margin-left:-210px;
    margin-bottom: 20px;
}
.handle-insert{
    margin-left: 265px;
}
.handle-select{
    width: 120px;
}
.handle-input{
    width: 300px;
    display: inline-block;
}
</style>
