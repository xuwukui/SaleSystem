package com.netease.homework.salesystem.controller;

import com.netease.homework.salesystem.service.GoodsService;
import com.netease.homework.salesystem.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    GoodsService goodsService;


    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String showLoginPage(Map<String,Object> map){
        CommonUtil.logining(map);
        map.put("success",true);
        return "login";
    }

    @RequestMapping("/logining")
    public  String login(@RequestParam("userName") String username, @RequestParam("password") String password,
                         HttpSession session,Map<String,Object> map, RedirectAttributes model){
        if("buyer".equals(username)){
            if(!"37254660E226EA65CE6F1EFD54233424".equals(password)){
                setErrorInfo(map,logger,"密码错误!");
                return "login";
            }
        }
        else if("seller".equals(username)){
            if(!"981C57A5CFB0F868E064904B8745766F".equals(password)){
                setErrorInfo(map,logger,"密码错误!");
                return "login";
            }
        }
        else{
            setErrorInfo(map,logger,"用户名不存在!");
            return "login";
        }
//        setSuccessInfo(model,logger,username);
        session.setAttribute("userName",username);
        session.setAttribute("isSeller","seller".equals(username));
        return "redirect:/homePage";
    }

    private void setErrorInfo(Map<String,Object> map,Logger logger,String errorMsg){
        map.put("logining" , true);
        map.put("success" , false);
        map.put("errorMsg" , errorMsg);
        logger.error(errorMsg);
    }

    private void setSuccessInfo(RedirectAttributes model,Logger logger,String username){
//        if("seller".equals(username)){
//            model.addFlashAttribute("sellerGoodsList",sellerService.getAllGoods());
//        }
//        else{
//            model.addFlashAttribute("sellerGoodsList",sellerService.getGoodsListIsNotBought());
//        }
        model.addFlashAttribute("sellerGoodsList", goodsService.getAllGoods());
        model.addFlashAttribute("logining" , false);
        model.addFlashAttribute("login" , true);
        model.addFlashAttribute("userName" , username );
        model.addFlashAttribute("isSeller" , "seller".equals(username));
        logger.info(username + "成功登陆!");
    }

    private static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    public static void main(String[] args){
        System.out.println(MD5("reyub"));
    }
}
