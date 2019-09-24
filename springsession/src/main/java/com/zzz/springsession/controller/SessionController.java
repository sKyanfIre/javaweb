package com.zzz.springsession.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzz
 */
@RestController
public class SessionController {
    private final static Logger logger = LoggerFactory.getLogger(SessionController.class);
    @RequestMapping(value = "/session/create",method = RequestMethod.POST)
    public Map<String,String> createSession(@RequestBody Map<String,String> request,HttpSession session){
        logger.info("请求报文：" + request.toString());
       session.setAttribute(request.get("name"),request.get("value"));
       logger.info("session=" + session.getId());
       return null;
    }
    @RequestMapping(value = "/session/get",method = RequestMethod.POST)
    public Map<String,String> getSessionAttribute(@RequestBody Map<String,String> request,HttpSession session){
        logger.info("请求报文：" + request.toString());
        String value = session.getAttribute(request.get("name")) == null ? "" : session.getAttribute(request.get("name")).toString();
        Map<String,String> response = new HashMap<>(1);
        response.put(request.get("name"),value);
        logger.info("session=" + session.getId());
        logger.info("返回报文：" + response.toString());
        return response;
    }
}
