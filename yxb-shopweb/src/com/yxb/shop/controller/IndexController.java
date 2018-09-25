package com.yxb.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxb.shop.model.GoodsDTO;
import com.yxb.shop.service.GoodsService;

@Controller
public class IndexController {

    //private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    private GoodsService goodsService;

    @RequestMapping("/")
    public String Init(Model model) {
       // logger.debug("init start!");

        List<GoodsDTO> goodsList = goodsService.getAllGoods();
        model.addAttribute("goodsList", goodsList);
        model.addAttribute("strVal", "i'm bing!");
        model.addAttribute("intVal", 8);
        return "index";
    }

    @Resource
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
}
