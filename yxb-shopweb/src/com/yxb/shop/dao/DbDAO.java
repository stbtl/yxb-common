package com.yxb.shop.dao;

import java.util.List;

/**
 * Created by bing on 2016/08/29.
 */
public interface DbDAO {

    public Object select(String sqlId, Object params);

    public <T> List<T> query(String sqlId, Object params);
}
