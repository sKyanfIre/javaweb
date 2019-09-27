package com.zzz.sso.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @author zzz
 * @description 通用请求vo
 * @date 2019/9/27
 */
@Data
@ToString
public class BaseRequestVo {
    private String reqSeq;
    private String reqTime;
    private String sign;
}
