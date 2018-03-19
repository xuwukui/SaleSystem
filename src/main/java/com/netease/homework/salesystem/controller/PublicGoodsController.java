package com.netease.homework.salesystem.controller;

import com.netease.homework.salesystem.pojo.Goods;
import com.netease.homework.salesystem.service.GoodsService;
import com.netease.homework.salesystem.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class PublicGoodsController {

    @Autowired
    GoodsService goodsService;


    @RequestMapping("/public")
    public String showPublicPage( HttpSession session, Map<String,Object> map){
        CommonUtil.afterSignin(session,map);
        map.put("isInCartPage",false);
        return "public";
    }

    @RequestMapping("/publicSubmit")
    public String publicSubmit(Goods goods, HttpSession session, Map<String,Object> map){
        CommonUtil.afterSignin(session,map);
        map.put("isInCartPage",false);
        try {
            goodsService.insertGoods(goods);
            int goodId = goodsService.getGoodsIdByPictureUrl(goods.getPictureUrl());
            map.put("goodsId",goodId);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            return "publicSubmit";
        }
        map.put("success",true);
        return "publicSubmit";
    }



}
