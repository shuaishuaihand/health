<template>
    <div>
   <div class="head">

        <div class="introduce">
            <div class="hospital-tips">
               安徽省立医院
            </div>
            <div class="hospitalintroduce">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;北京协和医院是集医疗、教学、科研于一体的大型三级甲等综合医院，是国家卫生计生委指定的全国疑难重症诊治指导中心
                也是最早承担高干保健和外宾医疗任务的医院之一，以学科齐全、技术力量雄厚、特色专科突出、多学科综合优势强大享誉海内外。
                在2009-2016年度复旦大学医院管理研究所公布的“中国最佳医院排行榜”中连续八年名列榜首。
                医院建成于1921年，由洛克菲勒基金会创办。建院之初，就志在“建成亚洲最好的医学中心”。95年来，医院形成了“严谨、求精、勤奋、奉献”
                的协和精神和兼容并蓄的特色文化风格，创立了“三基”、“三严”的现代医学教育理念，形成了以“教授、病案、图书馆”著称的协和“三宝”
                ，培养造就了张孝骞、林巧稚等一代医学大师和多位中国现代医学的领军人物，并向全国输送了大批的医学管理人才.

            </div>
        </div>


        <div class="img">
        <img class="pre-img" :src="src" alt="">
        </div>
    </div>


    <departmentTable>
    </departmentTable>


    </div>
</template>

<script>
    import departmentTable from './../department/DepartmentTable.vue';
    export default {
        data: function(){
            return {
                //src: './static/img/img.jpg',
                src: './static/img/hospital2.jpg',
                fileList: []
            }
        },
        components: {
            departmentTable
        },
        methods:{

        }
    }
</script>

<style scoped>
    .head{
        height: 320px;
        width:100%;
        border: 1px solid red;
    }
    .introduce{
        height: 300px;
        width:60%;
        float: left;
    }
    .img{
        width: 300px;
        height:300px ;
        margin-right: 25px;
        float: right;
    }
    .pre-img{
        width:350px;
        height: 250px;
        margin-top: 15px;
        margin-bottom: 20px;
    }
    .hospitalintroduce{
        width: 600px;
        height:300px ;
        margin-left: 15px;
        float: left;
    }
</style>
