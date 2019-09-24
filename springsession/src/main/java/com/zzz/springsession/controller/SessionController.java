package com.zzz.springsession.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzz
 */
@RestController(value = "/session")
public class SessionController {
    @RequestMapping(value = "/create")
    public Map<String,String> createSession(Map<String,String> request,HttpSession session){
       session.setAttribute(request.get("name"),request.get("value"));
       return null;
    }
    @RequestMapping(value = "/get")
    public Map<String,String> getSessionAttribute(Map<String,String> request,HttpSession session){
        String value = session.getAttribute(request.get("name")) == null ? "" : session.getAttribute(request.get("name")).toString();
        Map<String,String> response = new HashMap<>(1);
        response.put(request.get("name"),value);
        return response;
    }
}
