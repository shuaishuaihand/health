package com.hand.hand.mapper;

import com.hand.hand.domain.Chartdata;
import com.hand.hand.domain.Doctor;
import com.hand.hand.domain.Resident;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by nishuai on 2018/3/18
 */

@Mapper
public interface ResidentMapper {


    /*
      查询居民各年龄段的人数比例
     */

  List<Chartdata> findResidentproportionByAge();

  /*
     查询医院近年就诊人数
    */
  List<Chartdata> findResidentnumberByTime();

}
