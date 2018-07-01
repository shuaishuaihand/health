package com.hand.hand.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;
import com.hand.hand.mapper.DepartmentMapper;
import com.hand.hand.mapper.HospitalMapper;
import com.hand.hand.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nishuai on 2017/11/22.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

   @Autowired
   private DepartmentMapper departmentMapper;


    /**
     * 添加单个医院信息
     */
    @Override
    public Boolean addDepartment(Department department){
        int result=departmentMapper.addDepartment(department);
        if(result>0){
             System.out.println("插入成功！");
             return  true;
         }
       return  false;
    }

    /*
      根据id查询科室信息
     */

    public Department getDepartmentByDid(String id){
       Department department= departmentMapper.getDepartmentByDid(id);
        return department;
    }

      /*
      编辑单个科室信息
     */

     public Department editDepartment(Department department){
         int result=departmentMapper.editDepartment(department);
         if(result>0){
             System.out.println("修改成功！");
             return departmentMapper.getDepartmentByDid(department.getDid());
         }
         return  null;
     }

     /*
       根据id删除科室信息
     */

    public int deleteDepartment(String did){
        int result=departmentMapper.deleteDepartment(did);
        if(result>0){
            System.out.println("科室删除成功！");
            return result;
        }
        return  0;
    }

    /**
     * 根据id集合，批量删除科室信息
     */
    public Boolean batchdeleteDepartment(String[] didlist){
        Boolean flag=false;
        for (int i=0;i<didlist.length;i++){
            int result=  departmentMapper.deleteDepartment(didlist[i]);  //有空考虑批量删除
            if(result>0){
                flag=true;
            }
        }
        return flag;
    }

    /**
     * 根据did,danme,introduce,模糊查询科室信息
     */
    public List<Department> getDepartmentLike(String selectword,Integer hid){
        List<Department> departmentLists=  departmentMapper.getDepartmentLike(selectword,hid);

        return departmentLists;
    }

     /*
        查询医院包含的所有科室名称集合
     */

    @Override
    public List<Department> getDepartmentDnamelist(){
        List<Department> departmentsdnamelist=departmentMapper.getDepartmentDnamelist();
        return departmentsdnamelist;
    }

      /*
         查询医院包含的所有科室名称集合通过医院(hid)
     */

    @Override
    public List<Department> getDepartmentDnamelistByHid(int hid){
        System.out.print("进入service方法");
        List<Department> departmentsdnamelist=departmentMapper.getDepartmentDnamelistByHid(hid);
        return departmentsdnamelist;
    }


}
