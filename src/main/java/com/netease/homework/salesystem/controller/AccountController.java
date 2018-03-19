package com.netease.homework.salesystem.controller;

import com.netease.homework.salesystem.service.BuyerGoodsService;
import com.netease.homework.salesystem.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AccountController {

    @Autowired
    BuyerGoodsService buyerGoodsService;

    @RequestMapping("/account")
    public String showAccount(HttpSession session, Map<String,Object> map){
        CommonUtil.afterSignin(session,map);
        map.put("isInCartPage",false);
        map.put("accountList",buyerGoodsService.getAccountList());
        return "account";
    }
}
