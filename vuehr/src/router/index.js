import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
// import EmpAdv from '@/components/emp/EmpAdv'
// import EmpBasic from '@/components/emp/EmpBasic'
// import PerEc from '@/components/personnel/PerEc'
// import PerEmp from '@/components/personnel/PerEmp'
// import PerMv from '@/components/personnel/PerMv'
// import PerSalary from '@/components/personnel/PerSalary'
// import PerTrain from '@/components/personnel/PerTrain'
// import SalMonth from '@/components/salary/SalMonth'
// import SalSearch from '@/components/salary/SalSearch'
// import SalSob from '@/components/salary/SalSob'
// import SalSobCfg from '@/components/salary/SalSobCfg'
// import SalTable from '@/components/salary/SalTable'
// import StaAll from '@/components/statistics/StaAll'
// import StaPers from '@/components/statistics/StaPers'
// import StaRecord from '@/components/statistics/StaRecord'
// import StaScore from '@/components/statistics/StaScore'
// import SysBasic from '@/components/system/SysBasic'
// import SysCfg from '@/components/system/SysCfg'
// import SysData from '@/components/system/SysData'
// import SysHr from '@/components/system/SysHr'
// import SysInit from '@/components/system/SysInit'
// import SysLog from '@/components/system/SysLog'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden:true
    },{
      path: '/home',
      name: '主页',
      component: Home,
      children:[
        {
          path: '/hospitaltable',
          component: resolve => require(['../components/hospital/HospitalTable.vue'], resolve) //医院信息列表
        },
        {
          path: '/createhospital',
          component: resolve => require(['../components/hospital/CreateHospital.vue'], resolve)      //创建医院信息页面
        },{
          path: '/hospitaldetail',
          component: resolve => require(['../components/hospital/HospitalDetail.vue'], resolve)         //医院详情信息页面
        },{
          name:'edithospital',
          path: '/edithospital/:hid',
          component: resolve => require(['../components/hospital/EditHospital.vue'], resolve)         //编辑医院信息页面
        },{
        /*  name:'departmenttable',*/
        /*  path: '/departmenttable/:hid'*/
          path: '/departmenttable',
          component: resolve => require(['../components/department/DepartmentTable.vue'], resolve) //科室信息列表

        }, {
          name:'createdepartment',
          path: '/createdepartment/:hid',
          component: resolve => require(['../components/department/CreateDepartment.vue'], resolve)   //创建科室信息页面

        },{
          name:'editdepartment',
          path: '/editdepartment/:did',
          component: resolve => require(['../components/department/EditDepartment.vue'], resolve)         //编辑科室信息页面
        },{
          path: '/doctortable',
          component: resolve => require(['../components/doctor/DoctorTable.vue'], resolve)      //查询医生信息页面
        },{
          path: '/createdoctor',
          component: resolve => require(['../components/doctor/CreateDoctor.vue'], resolve)      //创建医生信息页面
        },{
          name: 'editdoctor',
          path: '/editdoctor/:id',
          component: resolve => require(['../components/doctor/EditDoctor.vue'], resolve)      //编辑医生信息页面
        },{
          path: '/createuser',
          component: resolve => require(['../components/user/CreateUser.vue'], resolve)      //创建系统用户信息页面
        },{
          path: '/usertable',
          component: resolve => require(['../components/user/UserTable.vue'], resolve)      //创建系统用户信息页面
        },{
          name: 'edituser',
          path: '/edituser/:id',
          component: resolve => require(['../components/user/EditUser.vue'], resolve)      //创建系统用户信息页面
        }
      ],
      hidden:true,
      meta:{
        requireAuth:true
      }
    }
  ]
})
