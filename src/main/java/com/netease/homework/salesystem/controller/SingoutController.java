package com.netease.homework.salesystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class SingoutController {

    private Logger logger = LoggerFactory.getLogger(SingoutController.class);

    @RequestMapping("/signout")
    public String signout(HttpSession session){
        String userName = session.getAttribute("userName").toString();
        Enumeration<String> em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement());
        }
        session.invalidate();
        logger.info(userName + "成功退出！");
        return "redirect:/homePage";
    }
}
