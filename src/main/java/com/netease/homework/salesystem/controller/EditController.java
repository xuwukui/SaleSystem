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
public class EditController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/edit")
    public String showEditPage(@RequestParam("goodsId") int goodsId, HttpSession session, Map<String,Object> map){
        CommonUtil.afterSignin(session,map);
        map.put("isInCartPage",false);
        map.put("goods",goodsService.getGoodsById(goodsId));
        return "edit";
    }

    @RequestMapping("/editSubmit")
    public String editSubmit(Goods goods, HttpSession session, Map<String,Object> map){
        CommonUtil.afterSignin(session,map);
        map.put("isInCartPage",false);
        try {
            goodsService.updateGoods(goods);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("goodsId",goods.getId());
            return "editSubmit";
        }
        map.put("success",true);
        map.put("goodsId",goods.getId());
        return "editSubmit";
    }


}
