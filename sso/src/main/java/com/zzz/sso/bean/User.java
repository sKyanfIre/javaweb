package com.zzz.sso.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author zzz
 * @description 用户实体
 * @date 2019/9/27
 */
@Data
@ToString
public class User {
    private String username;
    private String password;
    private String userId;
    private String registerDate;
    private String updateDate;
    private String valid;

}
