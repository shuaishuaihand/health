<template>
  <div>
    <div class="schart">
      <div class="content-title">饼状图</div>
      <schart canvasId="pie" width="600" height="500" :data="data1" type="pie" :options="options1"></schart>
    </div>
    <div class="schart">
      <div class="content-title">柱状图</div>
      <schart canvasId="bar" width="500" height="400" :data="data2" type="bar" :options="options2"></schart>
    </div>
    <div class="schart">
      <div class="content-title">折线图</div>
      <schart canvasId="line" width="500" height="400" :data="data2" type="line" :options="options2"></schart>
    </div>
  </div>
</template>

<script>
  import Schart from 'vue-schart';
  export default {
    components: {
      Schart
    },
    data: () => ({
      data1: [
       /* {name:'0-10岁',value:1200},
        {name:'10-20岁',value:1222},
        {name:'20-30岁',value:1283},
        {name:'30-40岁',value:1314},
        {name:'40-50岁',value:300},
        {name:'50-60岁',value:2314},*/
      ],
      options1: {
        title: '本医院患者各年龄段比例图',
        bgColor: '#FFFFFF',
        titleColor: '#EEB422',
        legendColor: '#7FFF00'
      },
      /* residentlist:[]*/
      data2:[
        {name:'2012',value:1141},
        {name:'2013',value:1499},
        {name:'2014',value:2260},
        {name:'2015',value:1170},
        {name:'2016',value:970},
        {name:'2017',value:1450}
      ],
      options2: {
        title: '医院近年就诊次数',
        bgColor: '#009688',
        titleColor: '#ffffff',
        fillColor: '#e0f2f1',
        axisColor: '#ffffff',
        contentColor: '#999'
      },
    }),
    created(){
      this.getData();
    },
    methods: {
      getData(){
          //（获取居民各年龄段的人数比例）接口
        this.$axios.get(`http://localhost:5050/findResidentproportionByAge`).then(data => {
          if (data) {
             this.data1= data.data;
             console.log(JSON.stringify(this.data1)+"111111");
          }
        })


        //查询医院近年就诊次数（一人可能就诊两次等）的接口
        this.$axios.get(`http://localhost:5050/findResidentnumberByTime`).then(data => {
          if (data) {
            this.data2= data.data;
            console.log(JSON.stringify(this.data2)+"22222");
          }
        })
      },
    }
  }
</script>

<style scoped>
  .schart{
    width: 600px;
    /*  display: inline-block;*/
    margin: 0 auto;
    /*  border: 1px solid red;*/
  }


</style>
