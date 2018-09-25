package com.yxb.shop.service.impl;

import com.yxb.shop.dao.DbDAO;
import com.yxb.shop.model.GoodsDTO;
import com.yxb.shop.service.GoodsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bing on 2016/08/30.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private DbDAO dbDAO;

    @Resource
    public void setDbDAO(DbDAO dbDAO) {
        this.dbDAO = dbDAO;
    }

    @Override
    @Cacheable(value = "myCache", key = "#id")
    public GoodsDTO getGoodsById(int id) {
        return (GoodsDTO) dbDAO.select("com.yxb.shop.context.goods.select", id);
    }

    @Override
    @Cacheable(value = "myCache", key = "#root.methodName")
    public List<GoodsDTO> getAllGoods() {
        return dbDAO.query("com.yxb.shop.context.goods.query", null);
    }
}
