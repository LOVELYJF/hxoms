package com.hxoms.datasources.service;

import com.hxoms.datasources.model.DataSource;

/**
 * @authore:wjf
 * @data 2020/4/14 20:03
 * @Description:
 ***/
public interface CutTargetDataSourceService {

    DataSource targetDataSource(String tableName,String code);
}
