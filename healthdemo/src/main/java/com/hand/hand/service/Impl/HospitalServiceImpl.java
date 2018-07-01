package com.hand.hand.service.Impl;

import com.hand.hand.domain.Chartdata;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;
import com.hand.hand.mapper.HospitalMapper;
import com.hand.hand.service.HospitalService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nishuai on 2017/11/22.
 */
@Service
public class HospitalServiceImpl implements HospitalService{

   @Autowired
   private HospitalMapper hospitalMapper;

    /**
     * 查询所有医院信息
     */
    @Override
    public List<Hospital> findAllHospital(){
     List<Hospital> hospitalslist=hospitalMapper.findAllHospital();
     return hospitalslist;
    }

    /*
     * 查询所有医院信息（分页）
     */
    public Page<Hospital> findAllHospitalPage(Integer page,Integer size){

        PageHelper.startPage(page, size);
        List<Hospital> hospitallist=  this.findAllHospital();
        Page<Hospital> hospitallistPage= (Page<Hospital>)hospitallist;

        return hospitallistPage;
    }

      /*
      根据id查询医院信息
     */

    public Hospital getHospitalByHid(Integer hid){
     Hospital hospital=  hospitalMapper.getHospitalByHid(hid);
     return  hospital;
    }

    /**
     * 根据hid,hanme,grade,模糊查询医院信息
     */
    public List<Hospital> getHospitalLike(String selectword){
      List<Hospital> hospitals=  hospitalMapper.getHospitalLike(selectword);
     /*   System.out.println("test");*/
        System.out.println( hospitals.size());
      System.out.println( hospitals.get(0).getHname());
        return hospitals;
    }

    /**
     * 添加单个医院信息
     */
    @Override
    public Hospital addHospital(Hospital hospital){
        int result=hospitalMapper.addHospital(hospital);
        if(result>0){
             System.out.println("插入成功！");
             return hospitalMapper.getHospitalByHid(hospital.getHid());
         }
       return  null;
    }

    /**
     * 编辑单个医院信息
     */
    @Override
    public Hospital editHospital(Hospital hospital){
        int result=hospitalMapper.editHospital(hospital);
        if(result>0){
            System.out.println("修改成功！");
            return hospitalMapper.getHospitalByHid(hospital.getHid());
        }
        return  null;
    }

    /**
     * 根据id删除医院信息
     */
    @Override
    public int deleteHospital(int hid){
        int result=hospitalMapper.deleteHospital(hid);
        if(result>0){
            System.out.println("删除成功！");
            return result;
        }
        return  0;
    }

    /**
     * 根据id集合，批量删除医院信息
     */
    public Boolean batchdeleteHospital(Integer[] hidlist){
        Boolean flag=false;
        for (int i=0;i<hidlist.length;i++){
          int result=  hospitalMapper.deleteHospital(hidlist[i]);  //有空考虑批量插入
            if(result>0){
                flag=true;
            }
        }
        return flag;
    }

    /**
     *  根据id，查询对应的所有科室信息（未分页）
     */
   public List<Department> findAllDepartmentByHid(Integer hid){
        List<Department> departmentlist=hospitalMapper.findAllDepartmentByHid(hid);
        return  departmentlist;
    }

    /**
     *  根据id，查询对应的所有科室信息（分页）
     */
    public Page<Department> findAllDepartmentPageByHid(Integer hid,Integer page,Integer size){

        PageHelper.startPage(page, size);
        List<Department> departmentList=  this. findAllDepartmentByHid(hid);
        Page<Department> departmentListPage= (Page<Department>)departmentList;

        return  departmentListPage;
    }

      /*
      查询医院各等级个数比例
     */

    public List<Chartdata> findHospitalnumberByGrade(){
        return hospitalMapper.findHospitalnumberByGrade();
    }

}


