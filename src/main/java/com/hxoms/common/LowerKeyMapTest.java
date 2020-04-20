package com.hxoms.common;

import dm.jdbc.driver.DmdbClob;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * @authore:wjf
 * @data 2020/4/14 11:41
 * @Description:
 ***/
public class LowerKeyMapTest<K,V> extends java.util.HashMap {

    @Override
    public V put(Object key, Object value) {
        if (key != null) {
                return (V) super.put(key.toString().toLowerCase(), value);
        } else {
            return (V) super.put(key, value);
        }
    }
}
