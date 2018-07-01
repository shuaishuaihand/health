package com.hand.hand.service.Impl;

import com.hand.hand.domain.Chartdata;
import com.hand.hand.mapper.ResidentMapper;
import com.hand.hand.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nishuai on 2018/3/18.
 */
@Service
public class ResidentServiceImpl implements ResidentService{


   @Autowired
    private ResidentMapper residentMapper;

    /*
      查询居民各年龄段的人数比例
     */

   @Override
    public List<Chartdata>  findResidentproportionByAge(){
      /*  List<Map<String,Integer>> residentmaplist=new ArrayList<Map<String,Integer>>();
        residentmaplist=residentMapper.findResidentproportionByAge();

        Map map=new HashMap<>();
        Chartdata chartdata;
        for(int i=0;i<residentmaplist.size();i++){

             System.out.print(residentmaplist.get(i).get("年龄段"));
             System.out.print("------------------------------------");
             System.out.print(residentmaplist.get(i).get("人数"));
             System.out.println();

            chartdata=new Chartdata(String.valueOf(residentmaplist.get(i).get("年龄段")),residentmaplist.get(i).get("人数"));

            System.out.print( chartdata.getName()+"||"+chartdata.getValue());


           *//*  map.put(residentmaplist.get(i).get("年龄段"),residentmaplist.get(i).get("人数"));*//*
        }

         return  map;*/

       return residentMapper.findResidentproportionByAge();
    }

    /*
     查询医院近年就诊人数
    */
    public List<Chartdata> findResidentnumberByTime(){
      return  residentMapper.findResidentnumberByTime();
    }

}
