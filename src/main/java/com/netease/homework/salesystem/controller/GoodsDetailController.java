package com.netease.homework.salesystem.controller;

import com.netease.homework.salesystem.pojo.Goods;
import com.netease.homework.salesystem.service.GoodsService;
import com.netease.homework.salesystem.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class GoodsDetailController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/detail")
    public String showGoodsDetailPage(@RequestParam("goodsId") int id, HttpSession session, Map<String,Object> map){
        map.put("goods",goodsService.getGoodsDetailById(id));
        if(session.getAttribute("userName") != null){
            CommonUtil.afterSignin(session,map);
        }
        else{
            CommonUtil.beforeSignin(map);
        }
        return "goodsDetail";
    }
}
