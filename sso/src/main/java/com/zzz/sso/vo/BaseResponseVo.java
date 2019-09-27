package com.zzz.sso.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zzz
 * @description 通用返回vo
 * @date 2019/9/27
 */
@Data
@ToString
public class BaseResponseVo {
    private String respCode;
    private String respDesc;
    private String sign;
    private Date reqTime;
    public void setBaseResponse(String respCode,String respDesc){
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.reqTime = Calendar.getInstance().getTime();
    }
}
