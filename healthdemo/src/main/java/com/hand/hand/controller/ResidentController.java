package com.hand.hand.controller;
import com.hand.hand.domain.Chartdata;
import com.hand.hand.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nishuai on 2018/3/18
 */
@CrossOrigin
@RestController
public class ResidentController{


    @Autowired
    private ResidentService residentService;;


    /**
     * 查询居民各年龄段的人数比例
     */
    @RequestMapping(value = "findResidentproportionByAge",method = RequestMethod.GET)
    public List<Chartdata> findResidentproportionByAge(){
        /*Map<String,Integer> residentproportion=new HashMap<>();
        residentproportion= residentService.findResidentproportionByAge();*/
        return residentService.findResidentproportionByAge();
    }


    /**
     * 查询医院近年就诊次数（一人可能就诊两次等）
     */
    @RequestMapping(value = "findResidentnumberByTime",method = RequestMethod.GET)
    public List<Chartdata> findResidentnumberByTime(){
        /*Map<String,Integer> residentproportion=new HashMap<>();
        residentproportion= residentService.findResidentproportionByAge();*/
        return residentService.findResidentnumberByTime();
    }





}
