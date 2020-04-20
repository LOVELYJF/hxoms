package com.hxoms.datasources.service.Impl;

import com.hxoms.datasources.mapper.CutTargetDataSourceMapper;
import com.hxoms.datasources.model.DataSource;
import com.hxoms.datasources.service.CutTargetDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @authore:wjf
 * @data 2020/4/14 20:04
 * @Description:
 ***/
@Service
public class CutTargetDataSourceServiceImpl implements CutTargetDataSourceService {
    @Autowired
    private CutTargetDataSourceMapper cutTargetDataSourceMapper;

    @Override
    public DataSource targetDataSource(String tableName, String code) {
        return cutTargetDataSourceMapper.targetDataSource(tableName,code);
    }
}
