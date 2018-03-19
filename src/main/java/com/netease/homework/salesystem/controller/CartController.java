package com.netease.homework.salesystem.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netease.homework.salesystem.service.BuyerGoodsService;
import com.netease.homework.salesystem.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    BuyerGoodsService buyerGoodsService;

    @RequestMapping("/add")
    public void addToCart(@RequestParam("goodsId") int goodsId,@RequestParam("buyNum") int buyNum,@RequestParam("buyPrice") int buyPrice) {
        buyerGoodsService.addGoodsToCart(goodsId,buyNum,buyPrice);
    }

    @RequestMapping("/show")
    public String showCart(HttpSession session, Map<String,Object> map){
        CommonUtil.afterSignin(session,map);
        map.put("isInCartPage",true);
        map.put("cartList",buyerGoodsService.getCartGoodsList());
        return "cart";
    }

    @RequestMapping("/balance")
    public String balance(@RequestParam("goodsIdList") String goodsIdList,@RequestParam("buyNumList") String buyNumList,
                          HttpSession session, Map<String,Object> map){
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Integer.class);
        try {
            List<Integer> idList = (List<Integer>)objectMapper.readValue(goodsIdList,javaType);
            List<Integer> numList = (List<Integer>)objectMapper.readValue(buyNumList,javaType);
            buyerGoodsService.goodsBalance(idList,numList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CommonUtil.afterSignin(session,map);
        map.put("isInCartPage",true);
        map.put("cartList",buyerGoodsService.getCartGoodsList());
        return "show";
    }
}
