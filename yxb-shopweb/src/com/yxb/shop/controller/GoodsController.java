package com.yxb.shop.controller;

import com.yxb.shop.model.GoodsDTO;
import com.yxb.shop.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by bing on 2016/08/30.
 */
@Controller
@RequestMapping("Goods")
public class GoodsController {
    private GoodsService goodsService;

    @RequestMapping("detainInit")
    public String detainInit(Model model, int goodsId) {
        GoodsDTO goodsDTO = goodsService.getGoodsById(goodsId);
        model.addAttribute("goodsDTO", goodsDTO);
        return "shop/GoodsDetain";
    }

    @Resource
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
}
