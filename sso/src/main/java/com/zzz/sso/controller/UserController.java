package com.zzz.sso.controller;

import com.zzz.sso.bean.User;
import com.zzz.sso.def.Constants;
import com.zzz.sso.service.UserService;
import com.zzz.sso.vo.BaseResponseVo;
import com.zzz.sso.vo.UserRequestVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zzz
 * @description 用户信息
 * @date 2019/9/27
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponseVo login(@RequestBody UserRequestVo req, HttpSession session){
        logger.info("调用【/user/login】接口开始，请求报文：" + req.toString());
        BaseResponseVo respVo = new BaseResponseVo();

        if(StringUtils.isEmpty(req.getUsername()) || StringUtils.isEmpty(req.getPassword())){
            logger.error("登录失败，账户或密码不能为空");
            respVo.setBaseResponse(Constants.ERR_CODE_MISSING_BIZ,"账户或密码不能为空");
            return respVo;
        }

        //校验账号密码
        User user = userService.getUser(req.getUsername(),req.getPassword());
        if(user == null){
          logger.error("账号或密码错误");
          respVo.setBaseResponse(Constants.ERR_FAILURE,"账号或密码错误");
          return respVo;
        }
        //账号密码校验成功
        session.setAttribute("loginUser",user.getUsername());
        respVo.setBaseResponse(Constants.SUCCESS_CODE,"登录成功");
        return respVo;
    }
}
