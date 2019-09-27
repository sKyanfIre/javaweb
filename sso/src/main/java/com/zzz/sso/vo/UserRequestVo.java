package com.zzz.sso.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zzz
 * @description 用户请求vo
 * @date 2019/9/27
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserRequestVo extends BaseRequestVo{
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
