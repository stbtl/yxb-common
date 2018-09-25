package com.yxb.shop.dao.impl;

import com.yxb.shop.dao.DbDAO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bing on 2016/08/29.
 */
@Repository
public class DbDAOImpl extends SqlSessionDaoSupport implements DbDAO {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public Object select(String sqlId, Object params) {
        return super.getSqlSession().selectOne(sqlId, params);
    }

    @Override
    public <T> List<T> query(String sqlId, Object params) {
        return super.getSqlSession().selectList(sqlId, params);
    }
}
