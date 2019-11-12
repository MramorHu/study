package com.myself.springboot.controller;

import brave.sampler.Sampler;
import com.myself.common.ResponseOb;
import com.myself.springboot.service.StudyService;
import com.myself.springboot.service.impl.StudyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@RestController
@RequestMapping("/study")
@Api(value = "study", description = "study")
public class StudyController {

    private static Logger logger= LoggerFactory.getLogger(StudyController.class);

    @Autowired
    StudyService studyService;

    @ApiOperation(value = "测试普通返回",notes = "测试一下")
    @GetMapping("/getString")
    public ResponseOb getString(HttpServletRequest httpServletRequest){
        Enumeration enumeration=httpServletRequest.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String a=enumeration.nextElement().toString();
            logger.debug("-----------------header:"+a+","+httpServletRequest.getHeader(a));
        }
        ResponseOb responseOb=new ResponseOb();
        responseOb.setCode(200);
        responseOb.setData(studyService.getString());
        return responseOb;
    }

    @ApiOperation(value = "测试普通返回",notes = "测试一下")
    @ApiImplicitParam(paramType = "query",name = "name", value = "用户名称",dataType = "String",required = false)
    @GetMapping("/getString1")
    public String getString1(String name){
        return name;
    }

    @ApiOperation(value = "测试redis",notes = "测试一下")
    @GetMapping("/testRedis")
    public String testRedis() throws Exception{
        if(true){
            throw new Exception("aaaaaaaa");
        }
        return studyService.getString();
    }

    @ApiOperation(value = "测试异常",notes = "测试一下")
    @GetMapping("/testRedis1")
    public String testException() throws Exception{
        throw new Exception("aaa");
    }

    @ApiOperation(value = "测试mybatis",notes = "测试一下")
    @GetMapping("/list")
    public ResponseOb<Map> getList() throws Exception{
        ResponseOb responseOb=new ResponseOb();
        responseOb.setData(studyService.getList());
        return responseOb;
    }


}
