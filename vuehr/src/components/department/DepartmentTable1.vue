<template>
    <div class="departmenttable">

        <div class="head">

            <div class="introduce">
                <div class="hospital-tips">
                    {{this.hospital.hname}}
                </div>
                <div class="hospitalintroduce">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{this.hospital.introduce}}

                </div>
                <div class="hospitalmap"></div>
            </div>

            <div class="img">
                <img class="pre-img" :src="this.hospital.picture" alt="">
            </div>

            <div class="map" id="map">

            </div>


        </div>



        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 表格</el-breadcrumb-item>
                <el-breadcrumb-item>  {{$route.params.hid}}{{this.hospital.hname}}科室信息列表1111<!--{{this.tableData[0].hid}}--></el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="handle-box">
            <el-button type="primary" icon="delete" class="handle-del mr10" @click="delAll">批量删除</el-button>
            <el-input v-model="select_word" placeholder="筛选关键词" class="handle-input mr10"></el-input>
            <el-button type="primary" icon="search" @click="search">搜索</el-button>
            <el-button type="primary" class="handle-insert mr10"
                       @click="handleDepartmentCreate">新增
                <!--  <router-link :to="{name:'createdepartment',params:{hid:$route.params.hid}}">新增</router-link>-->
               <!-- <router-link to="/createdepartment">新增</router-link>-->
            </el-button>
        </div>
        <el-table :data="tableData" border style="width: 100%" ref="multipleTable" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="did" label="编号" >
            </el-table-column>
            <el-table-column prop="dname" label="科室名称" >
            </el-table-column>
            <el-table-column prop="introduce" label="科室介绍" >
            </el-table-column>

            <el-table-column label="操作" width="180">
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
                url: './static/vuetable1.json',
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
                is_search: false,
            }
        },
        mounted() {
            //创建Map实例
            var map = new BMap.Map("map");
            var point = new BMap.Point(121.160724,31.173277);
            map.centerAndZoom(point,15);
            //添加鼠标滚动缩放
            map.enableScrollWheelZoom();

            //添加缩略图控件
            map.addControl(new BMap.OverviewMapControl({isOpen:false,anchor:BMAP_ANCHOR_BOTTOM_RIGHT}));
            //添加缩放平移控件
            map.addControl(new BMap.NavigationControl());
            //添加比例尺控件
            map.addControl(new BMap.ScaleControl());
            //添加地图类型控件
            //map.addControl(new BMap.MapTypeControl());

            //设置标注的图标
            var icon = new BMap.Icon("./static/img/map.png",new BMap.Size(100,100));
            //设置标注的经纬度
            var marker = new BMap.Marker(new BMap.Point(121.160724,31.173277),{icon:icon});
            //把标注添加到地图上
            map.addOverlay(marker);
            var content = "<table>";
            content = content + "<tr><td> 编号：001</td></tr>";
            content = content + "<tr><td> 地点：上海汉得信息技术股份有限公司</td></tr>";
            content = content + "<tr><td> 时间：2018-1-3</td></tr>";
            content += "</table>";
            var infowindow = new BMap.InfoWindow(content);
            marker.addEventListener("click",function(){
                this.openInfoWindow(infowindow);
            });

            //点击地图，获取经纬度坐标
            map.addEventListener("click",function(e){
                document.getElementById("aa").innerHTML = "经度坐标："+e.point.lng+" &nbsp;纬度坐标："+e.point.lat;
            });
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
              this.hid=this.$route.params.hid;
                console.log(this.$route.params.hid+"123574697947");

                //根据医院信息hid获取医院信息的接口
                this.$axios.get(`http://118.89.33.198:5050/getHospitalByHid/${this.hid}`).then(data=>{
                    if(data){
                        console.log(JSON.stringify(data.data)+"66666666666666666666666666666666666666666666666666666");
                        this.hospital=data.data;
                        console.log(this.hospital.introduce+"777777777777777777777777777777777777777");
                    }
                })

                //根据医院信息hid获取科室数据集合的接口
                this.$axios.get(`http://118.89.33.198:5050/findAllDepartmentPageByHid/${this.hid}?page=${this.cur_page}&size=${this.pagesize}`).then(data=>{
                    if(data){
                        console.log(3333333333333333333333333333333333333333333333333333333);
                        console.log(JSON.stringify(data.data.pagehospitaldata));
                        console.log(data.data.total+"total");
                        this.total=data.data.total;
                        this.tableData=data.data.pagedepartmentdata;
                        console.log(this.tableData[0].hid+"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
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
                this.$axios.get(`http://118.89.33.198:5050/getDepartmentLike/${this.select_word}`).then(data=> {
                    if (data) {
                        this.tableData = data.data;
                    }
                })
            },
           handleEdit(index, row) {
               console.log(row.did+"row.didtest------------");
               console.log(row.hid+"row.hidtest------------");
                this.$router.push({
                     name: 'editdepartment',
                     params: {
                         did: row.did,
                         hid: row.hid
                    }
                })

            },
          handleDepartmentCreate() {
            console.log("nini1111111111111111111111"+this.hid);
            this.$router.push({
              name: 'createdepartment',
              params: {
                hid: this.hid
              }
            })

          },

            handleDelete(index, row) {
                console.log(index+"index");
                console.log(row.hid+"row");
                this.$axios.delete(`http://118.89.33.198:5050/deleteDepartment/${row.did}`).then(response=>{
                    const status = response.status;
                    console.log(status+"status");
                    if(status===200){
                        this.$message.success('成功删除编号为'+(row.did)+'的科室信息');
                        this.getData();
                    }else{
                        this.$message.success('失败删除编号为'+(row.did)+'的科室信息');
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
                this.$axios.post(`http://118.89.33.198:5050/batchdeleteDepartment`,JSON.stringify(idlist),{
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
    .departmenttable{
        margin-top: -10px;
    }
    .handle-box{
        margin-bottom: 20px;
    }
    .handle-insert{
        margin-left: 520px;
    }
    .handle-select{
        width: 120px;
    }
    .handle-input{
        width: 300px;
        display: inline-block;
    }
    .head{
        height: 320px;
        width:100%;
    }
    .hospital-tips{
        width: 300px;
        height: 20px;
        margin-left: 200px;
    }
    .introduce{
        height: 300px;
        width:40%;
        float: left;
        border:1px solid yellow;
    }
    .hospitalintroduce{
        width: 400px;
        height:250px ;
        margin-top: 10px;
        margin-left: 15px;
        float: left;
        border:1px solid green;
    }
    .map{
        height: 300px;
        width:30%;
        margin-left: 3px;
        float: right;
        border:1px solid green;
    }
    .img{
        width: 310px;
        height:300px ;
        float: left;
        border:1px solid red;
    }
    .pre-img{
        width:300px;
        height: 250px;
        margin-top: 5px;
        margin-bottom: 20px;
    }

</style>
