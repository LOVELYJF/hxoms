package com.hxoms.modules.dataCapture.mapper;

import java.util.List;
import java.util.Map;

/**
 * @authore:wjf
 * @data 2020/4/14 9:44
 * @Description:
 ***/
public interface DataCaptureMapper {

    List<Map> getMasterA01();

    List<Map> getTargetA01();

    void      updateMasterA01(List<Map> updateList);

    void      insertMasterA01(List<Map> insertList);


    List<Map> getMasterA02();

    List<Map> getTargetA02();

    void      updateMasterA02(List<Map> updateList);

    void      insertMasterA02(List<Map> insertList);

}
