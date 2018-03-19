package com.netease.homework.salesystem.utils;

import com.netease.homework.salesystem.dao.BuyerGoodsDAO;
import com.netease.homework.salesystem.dao.GoodsDAO;
import com.netease.homework.salesystem.pojo.Goods;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class CommonUtil {

    public static void beforeSignin(Map<String,Object> map){
        map.put("logining",false);
        map.put("login",false);
    }

    public static void logining(Map<String,Object> map){
        map.put("logining",true);
        map.put("login",false);
    }

    public static void afterSignin(HttpSession session, Map<String,Object> map){
        map.put("logining",false);
        map.put("login",true);
        map.put("isInCartPage",false);
        map.put("userName",session.getAttribute("userName"));
        map.put("isSeller",session.getAttribute("isSeller"));
    }


    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        GoodsDAO goodsDAO = ac.getBean("goodsDAO",GoodsDAO.class);
        BuyerGoodsDAO buyerGoodsDAO = ac.getBean("buyerGoodsDAO",BuyerGoodsDAO.class);
        System.out.println(goodsDAO.getGoodsDetailById(18));
   }
}
