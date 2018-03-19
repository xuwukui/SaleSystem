package com.netease.homework.salesystem.controller;

import com.netease.homework.salesystem.service.GoodsService;
import com.netease.homework.salesystem.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class HomePageController {

    @Autowired
    GoodsService goodsService;


    @RequestMapping({"/","/homePage"})
    public String showHomePage(HttpSession session, Map<String,Object> map){
        map.put("sellerGoodsList", goodsService.getAllGoods());
        if(session.getAttribute("userName") != null){
            CommonUtil.afterSignin(session,map);
        }
        else{
            CommonUtil.beforeSignin(map);
        }
        return "homePage";
    }
}
