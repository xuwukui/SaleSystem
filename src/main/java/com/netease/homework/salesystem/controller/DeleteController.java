package com.netease.homework.salesystem.controller;

import com.netease.homework.salesystem.service.GoodsService;
import com.netease.homework.salesystem.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class DeleteController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("delete")
    public String deleteGoods(@RequestParam("goodsId") int goodsId, HttpSession session, Map<String,Object> map){
        goodsService.deleteGoodsById(goodsId);
        CommonUtil.afterSignin(session,map);
        map.put("isInCartPage",false);
        map.put("sellerGoodsList", goodsService.getAllGoods());
        return "homePage";
    }
}
