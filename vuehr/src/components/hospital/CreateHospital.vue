<template>
    <div class="all">
        <div class="title">  <h2>医院信息表单</h2></div>

        <div class="form-box">
            <el-form ref="form" :model="hospital" label-width="80px">

                <el-form-item label="医院名称">
                    <el-input v-model=" hospital.hname" placeholder="请输入内容"></el-input>
                </el-form-item>

                <el-form-item label="医院图片">
                    <!--  <el-input type="textarea" v-model=" hospital.introduce" :rows="9"></el-input>-->
                    <div>
                        <el-upload
                            action="http://localhost:5050/ftpuploadimg"
                            list-type="picture-card"
                            :on-preview="handlePictureCardPreview"
                            :on-remove="handleRemove"
                            :on-success="uploadSuccess">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                        <el-dialog :visible.sync="dialogVisible" size="tiny">
                            <img width="100%" :src="dialogImageUrl" alt="">
                        </el-dialog>

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


                <el-form-item label="医院介绍">
                    <el-input type="textarea" v-model=" hospital.introduce" :rows="9"></el-input>
                </el-form-item>

                <el-form-item label="医院地址">
                   <!-- <el-input v-model=" hospital.hname" placeholder="请输入内容"></el-input>-->
                <!-- <el-input type="text" id="suggestId" placeholder="请输入地址" v-model="hospital.address"></el-input>-->

                    <input type="text"  style="width:515px;height: 28px" id="suggestId" placeholder="请输入地址" v-model="hospital.address"></input>
               <!-- <input type="text" id="suggestId" placeholder="如门牌号等" v-model="hospital.address">-->
                   <div id="addressmap"></div>
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
               hospital: {
                    hid: '',
                    hname:'',
                    grade:'',
                    address:'',
                    longitude:'',
                    latitude:'',
                    introduce:'',
                    picture:'',
                   address_detail: null, //详细地址
                   userlocation: {lng: "", lat: ""},
                   dialogImageUrl: '',
                   dialogVisible: false

                }
            }
        },

        //百度地图搜索
        mounted(){
            this.$nextTick(function () {

                var th = this
                // 创建Map实例
                var map = new BMap.Map("addressmap");

                //测试定位控件,的使用怎么用？
              // map.GeolocationControl();

                // 初始化地图,设置中心点坐标
               var point = new BMap.Point(121.160724,31.173277); // 创建点坐标
                map.centerAndZoom(point, 15);
                map.enableScrollWheelZoom();
                var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
                    {
                        "input": "suggestId"
                        , "location": map
                    })
                var myValue
                ac.addEventListener("onconfirm", function (e) {    //鼠标点击下拉列表后的事件
                    var _value = e.item.value;
                    myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
                    this.address = myValue
                    setPlace();
                });

                function setPlace() {
                    map.clearOverlays();    //清除地图上所有覆盖物
                    function myFun() {
                        th.userlocation = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
                        map.centerAndZoom(th.userlocation, 18);
                        map.addOverlay(new BMap.Marker(th.userlocation));    //添加标注
                    }

                    var local = new BMap.LocalSearch(map, { //智能搜索
                        onSearchComplete: myFun
                    });
                    local.search(myValue);

                    //测试输出坐标
                    map.addEventListener("click",function(e){
                         //经度
                        console.log(th.userlocation.lng+"222222222");
                         //维度
                        console.log(th.userlocation.lat+"222222222");

                    })

                  //将经纬度赋值给hospital的经纬度属性
                  this.hospital.longitude=th.userlocation.lng;
                  this.hospital.latitude=th.userlocation.lat;
                }

            })
        },
        methods: {
            handleChange(value) {
                    console.log(value);
            },
            createHospital (hospital) {
              console.log(hospital.longitude+"33333333333333333");
              console.log(hospital.latitude+"44444444444444444");
                this.$axios.post(`http://localhost:5050/addHospital`, JSON.stringify(hospital),{
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

                       this.createHospital(this.hospital), //将添加的数据提交到后台
                this.$message.success('添加成功！');

               this.$router.push({      //跳转到医院列表主页面
                    path: '/hospitaltable'
                })

            },

            cancel(){
                this.$router.push({      //跳转到医院列表主页面
                    path: '/hospitaltable'
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
                this.hospital.picture="http://101.132.171.196/images/"+response;

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
