package com.hxoms.modules.dataCapture.service;

//import com.hxoms.datasources.annotation.DBChange;
import com.hxoms.datasources.annotation.DBChange;
import com.hxoms.datasources.model.DataSource;

import java.util.List;
import java.util.Map;

/**
 * @authore:wjf
 * @data 2020/4/14 9:40
 * @Description:
 ***/
public interface DataCaptureService {


   /**
    * A01表的相关操作
    *
    * **/

    List<Map> getMasterA01();

    /**
     * 通过注解将数据源改为参数指定的。
     * @param dataSource
     * @return
     */
    List<Map> getTargetA01( @DBChange DataSource dataSource);


    void      updateMasterA01(List<Map> updateList);

    void      insertMasterA01(List<Map> insertList);

    /**
     * A02表的相关操作
     *
     * **/
    List<Map> getMasterA02();

    /**
     * 通过注解将数据源改为参数指定的。
     * @param dataSource
     * @return
     */
    List<Map> getTargetA02( @DBChange DataSource dataSource);


    void      updateMasterA02(List<Map> updateList);

    void      insertMasterA02(List<Map> insertList);

//    /**
//     * 目标数据源向主数据同步
//     */
//    void   synchronizationData();
}
