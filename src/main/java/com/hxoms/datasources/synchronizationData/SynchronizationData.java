package com.hxoms.datasources.synchronizationData;

import com.hxoms.datasources.model.DataSource;
import com.hxoms.datasources.model.DefultTargetDataSource;
import com.hxoms.datasources.service.CutTargetDataSourceService;
import com.hxoms.modules.dataCapture.service.DataCaptureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @authore:wjf
 * @data 2020/4/17 9:22
 * @Description:
 ***/
@Component
public class SynchronizationData {


    @Autowired
    private DataCaptureService a01Service;

    @Autowired
    private CutTargetDataSourceService cutTargetDataSourceService;

    @Autowired
    private DefultTargetDataSource defultTargetDataSource;

    // 需要插入的集合
    private List<Map> insertList ;
    // 需要修改的集合
    private List<Map>  updateList ;

    private final Logger log = LoggerFactory.getLogger(getClass());

    public void synchronizationData(){
        DataSource dataSource = cutTargetDataSourceService.targetDataSource("dataSource","2");
        if(dataSource == null){
            dataSource = defultTargetDataSource;
        }

        List<Map> targetMap =  a01Service.getTargetA01(dataSource);
        List<Map> masterMap =  a01Service.getMasterA01();
        diffListMap(targetMap,masterMap,"A01");

//        if (insertList != null && insertList.size() > 0) {
//            a01Service.insertMasterA01(insertList);
//        }
//        if(updateList!=null && updateList.size()>0){
//            a01Service.updateMasterA01(updateList);
//        }
//
//

        List<Map> targetMapA02 =  a01Service.getTargetA02(dataSource);
        List<Map> masterMapA02 =  a01Service.getMasterA02();
        diffListMap(targetMapA02,masterMapA02,"A02");
//
//        if (insertList != null && insertList.size() > 0) {
//            a01Service.insertMasterA01(insertList);
//        }
//        if(updateList!=null && updateList.size()>0){
//            a01Service.updateMasterA01(updateList);
//        }






    }


    private  void diffListMap(List<Map> targetMapList,List<Map> masterMapList,String tabelName){

     if(targetMapList != null && targetMapList.size() > 0){


        List<String> sameA0100 = new ArrayList();

        if(masterMapList != null && masterMapList.size() > 0 ){

            for(Map masterMap : masterMapList){

                String a0100 =(String) masterMap.get("a0100");
                sameA0100.add(a0100);

             }

           }else {

            log.info("主数据源为空，直接执行插入操作");

          }

        updateList =  targetMapList.stream().filter((Map m) ->sameA0100.contains(m.get("a0100")) ).collect(Collectors.toList());

        log.info("需要修改的集合长度为"+updateList.size()+"\t"+tabelName);

        insertList =  targetMapList.stream().filter((Map m) ->!sameA0100.contains(m.get("a0100")) ).collect(Collectors.toList());

        log.info("需要插入的集合长度为"+insertList.size()+"\t"+tabelName);

        if (insertList != null && insertList.size() > 0) {

            insertTable(tabelName,insertList);

         //   a01Service.insertMasterA01(insertList);
        }
        if(updateList!=null && updateList.size()>0){
            upDataTable(tabelName,updateList);
         //   a01Service.updateMasterA01(updateList);
        }





        }else{


            log.info("目标数据源为空不需要任何操作");
        }

    }


    public void insertTable(String tableName,List<Map> insertList){

        switch(tableName){

            case "A01" :

                //语句
                a01Service.insertMasterA01(insertList);
                break;
            case "A02" :

                //语句
                a01Service.insertMasterA02(insertList);
                break;

            default :

                //语句

        }
    }


    public void upDataTable(String tableName,List<Map> updateList){

        switch(tableName){

            case "A01" :

                //语句
                a01Service.updateMasterA01(updateList);
                break;
            case "A02" :

                //语句
                a01Service.updateMasterA02(updateList);
                break;

            default :

                //语句

        }
    }














}
