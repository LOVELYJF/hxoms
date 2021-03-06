package com.hxoms.datasources.mapper;

import com.hxoms.datasources.model.DataSource;
import org.apache.ibatis.annotations.Param;

/**
 * @authore:wjf
 * @data 2020/4/14 17:17
 * @Description:
 ***/
public interface CutTargetDataSourceMapper {

    DataSource targetDataSource(@Param("tableName") String tableName,@Param("code") String code);

}
