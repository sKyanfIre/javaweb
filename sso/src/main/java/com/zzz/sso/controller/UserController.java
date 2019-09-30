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
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public BaseResponseVo logout(HttpSession session){
        logger.info("调用【/user/logout】接口开始");
        session.removeAttribute("loginUser");
        logger.info("退出成功！");
        BaseResponseVo respVo = new BaseResponseVo();
        respVo.setBaseResponse(Constants.SUCCESS_CODE,"退出成功");
        logger.info("调用【/user/logout】接口结束，返回报文：" + respVo);
        return respVo;
    }
    @RequestMapping(value = "/isLogin",method = RequestMethod.POST)
    public BaseResponseVo isLogin(@RequestBody UserRequestVo req,HttpSession session){
        logger.info("调用【/user/isLogin】接口开始,请求报文：" + req.toString());
        BaseResponseVo respVo = new BaseResponseVo();
        if(StringUtils.isEmpty(req.getUsername())){
            respVo.setBaseResponse(Constants.ERR_CODE_MISSING_BIZ,"账号不能为空");
            return respVo;
        }
        if(session == null
                || session.getAttribute("loginUser") == null
                || !req.getUsername().equals(session.getAttribute("loginUser").toString())){
            respVo.setBaseResponse(Constants.ERR_FAILURE,"尚未登录");
            return respVo;
        }
        respVo.setBaseResponse(Constants.SUCCESS_CODE,"已登录");
        logger.info("调用【/user/isLogin】接口结束，返回报文：" + respVo);
        return respVo;
    }
    @RequestMapping(value = "/register")
    public BaseResponseVo register(@RequestBody UserRequestVo req){
        logger.info("调用【/user/register】接口开始：" + req.toString());
        BaseResponseVo respVo = new BaseResponseVo();
        if(StringUtils.isEmpty(req.getUsername()) || StringUtils.isEmpty(req.getPassword())){
            logger.info("注册失败，账号或密码不能为空");
            respVo.setBaseResponse(Constants.ERR_CODE_MISSING_BIZ,"账号或密码不能为空");
            return respVo;
        }
        //检验账号是否已存在
        User user = userService.getUserByName(req.getUsername());
        if(user != null){
            logger.info("注册失败，用户已存在");
            respVo.setBaseResponse(Constants.ERR_FAILURE,"用户已存在");
            return respVo;
        }
        //注册账号
        if(userService.createUser(req.getUsername(),req.getPassword())){
           logger.info("注册成功");
           respVo.setBaseResponse(Constants.SUCCESS_CODE,"注册成功");
        }else{
            respVo.setBaseResponse(Constants.ERR_FAILURE,"注册失败，请重试");
        }
        logger.info("调用【/user/register】接口结束：" + respVo.toString());
        return respVo;
    }
}
