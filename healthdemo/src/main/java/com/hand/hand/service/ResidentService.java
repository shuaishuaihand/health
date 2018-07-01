package com.hand.hand.service;

import com.github.pagehelper.Page;
import com.hand.hand.domain.Chartdata;
import com.hand.hand.domain.Doctor;

import java.util.List;
import java.util.Map;

/**
 * Created by nishuai on 2017/12/19.
 */
public interface ResidentService {


    /*
      查询居民各年龄段的人数比例
     */
    public List<Chartdata> findResidentproportionByAge();

    /*
      查询医院近年就诊人数
     */
    public List<Chartdata> findResidentnumberByTime();



}
