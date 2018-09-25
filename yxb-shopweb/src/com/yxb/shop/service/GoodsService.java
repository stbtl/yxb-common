package com.yxb.shop.service;

import com.yxb.shop.model.GoodsDTO;

import java.util.List;

/**
 * Created by bing on 2016/08/30.
 */
public interface GoodsService {
    public GoodsDTO getGoodsById(int id);
    public List<GoodsDTO> getAllGoods();
}
