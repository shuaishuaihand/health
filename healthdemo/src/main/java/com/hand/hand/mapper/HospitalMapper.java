package com.hand.hand.mapper;

import com.hand.hand.domain.Chartdata;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;
import com.hand.hand.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nishuai on 2017/11/22
 */

@Mapper
public interface HospitalMapper {

    /*
     查询所有医院信息
     */

   List<Hospital> findAllHospital();

    /**
     * 添加单个医院信息
     */

    int addHospital(Hospital hospital);

   /**
   * 根据hid,hanme,grade,模糊查询医院信息
   */
    List<Hospital> getHospitalLike(@Param("selectword") String selectword);


    /**
     * 根据id查询医院信息
     */

    Hospital getHospitalByHid(Integer hid);


    /**
     * 编辑单个医院信息
     */

    int editHospital(Hospital hospital);

    /**
     * 根据id删除医院信息
     */

    int deleteHospital(Integer hid);


    /**
     *  根据id查询对应的所有科室信息
     */
     List<Department> findAllDepartmentByHid(Integer hid);

    /*
      查询医院各等级个数比例
     */

     List<Chartdata> findHospitalnumberByGrade();
}
