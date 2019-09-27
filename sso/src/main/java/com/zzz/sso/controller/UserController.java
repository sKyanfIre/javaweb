package com.zzz.sso.controller;

import com.zzz.sso.def.Constants;
import com.zzz.sso.vo.BaseResponseVo;
import com.zzz.sso.vo.UserRequestVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zzz
 * @description 用户信息
 * @date 2019/9/27
 */
@RestController("/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponseVo login(UserRequestVo req, HttpSession session){
        logger.info("调用【/user/login】接口开始，请求报文：" + req.toString());
        BaseResponseVo respVo = new BaseResponseVo();

        if(StringUtils.isEmpty(req.getUsername()) || StringUtils.isEmpty(req.getPassword())){
            logger.error("登录失败，账户或密码不能为空");
            respVo.setBaseResponse(Constants.ERR_CODE_MISSING_BIZ,"账户或密码不能为空");
            return respVo;
        }

        //校验账号密码

        return respVo;
    }
}
