package com.hand.hand.service;

import com.hand.hand.domain.Chartdata;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;
import com.github.pagehelper.Page;
import java.util.List;

/**
 * Created by nishuai on 2017/11/12.
 */
public interface HospitalService {

     /*
      查询所有医院信息
     */

    public List<Hospital> findAllHospital();

    /**
     * 查询所有医院信息（分页）
     */

    public Page<Hospital> findAllHospitalPage(Integer page,Integer size);
     /*
      根据id查询医院信息
     */

    public Hospital getHospitalByHid(Integer hid);

    /**
     * 根据hid,hanme,grade,模糊查询医院信息
     */
    public List<Hospital> getHospitalLike(String selectword);

     /*
      添加单个医院信息
     */

    public Hospital addHospital(Hospital hospital);

     /*
      编辑单个医院信息
     */

    public Hospital editHospital(Hospital hospital);

      /*
     根据id删除医院信息
     */

    public int deleteHospital(int hid);

    /**
     * 根据id集合，批量删除医院信息
     */
    public Boolean batchdeleteHospital(Integer[] hidlist);

    /**
     *  根据id，查询对应的所有科室信息
     */
   public List<Department> findAllDepartmentByHid(Integer hid);

    /**
     *  根据id，查询对应的所有科室信息（分页）
     */
    public Page<Department> findAllDepartmentPageByHid(Integer hid,Integer page,Integer size);

    /*
      查询医院各等级个数比例
     */

    public List<Chartdata> findHospitalnumberByGrade();
}
