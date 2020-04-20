package com.hxoms.modules.dataCapture.service.lmpl;

import com.hxoms.datasources.annotation.DBChange;
import com.hxoms.datasources.model.DataSource;
import com.hxoms.modules.dataCapture.mapper.DataCaptureMapper;
import com.hxoms.modules.dataCapture.service.DataCaptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @authore:wjf
 * @data 2020/4/14 9:42
 * @Description:
 ***/
@Service
public class DataCaptureServiceImpl implements DataCaptureService {
    @Autowired
    private DataCaptureMapper dataCaptureMapper;







    @Override
    public List<Map> getMasterA01() {
        return dataCaptureMapper.getMasterA01();
    }

    /**
     * 通过注解将数据源改为参数指定的。
     * @param dataSource
     * @return
     */
    @DBChange
    @Override
    public List<Map> getTargetA01(  @DBChange  DataSource dataSource) {
        return dataCaptureMapper.getTargetA01();
    }

    @Override
    public void updateMasterA01(List<Map> updateList) {

        dataCaptureMapper.updateMasterA01(updateList);

    }

    @Override
    public void insertMasterA01(List<Map> insertList) {

        dataCaptureMapper.insertMasterA01(insertList);

    }



    @Override
    public List<Map> getMasterA02() {
        return dataCaptureMapper.getMasterA02();
    }


    @DBChange
    @Override
    public List<Map> getTargetA02( @DBChange DataSource dataSource) {
        return dataCaptureMapper.getTargetA02();
    }

    @Override
    public void updateMasterA02(List<Map> updateList) {

        dataCaptureMapper.updateMasterA02(updateList);

    }

    @Override
    public void insertMasterA02(List<Map> insertList) {

        dataCaptureMapper.insertMasterA02(insertList);

    }


//    /**
//     * 目标数据源向主数据源同步数据
//     */
//    @Override
//    public void synchronizationData() {
//
//
//     diffListMap(targetMap,masterMap);
//
//    }



}
