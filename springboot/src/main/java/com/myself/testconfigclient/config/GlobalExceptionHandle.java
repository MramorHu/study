package com.myself.testconfigclient.config;

import com.myself.common.ResponseOb;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseOb globalException(HttpServletRequest httpServletRequest,Exception e) throws Exception{
        ResponseOb responseOb=new ResponseOb();
        responseOb.setCode(500);
        responseOb.setMessage(e.getMessage());
        responseOb.setUrl(httpServletRequest.getRequestURL().toString());
        return responseOb;
    }
}
