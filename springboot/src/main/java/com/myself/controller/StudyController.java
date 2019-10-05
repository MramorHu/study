package com.myself.controller;

import com.myself.service.StudyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study")
public class StudyController {

    @Autowired
    StudyService studyService;

    @ApiOperation(value = "测试普通返回",notes = "测试一下")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id",dataType = "String",required = false),
            @ApiImplicitParam(name = "name", value = "用户名称",dataType = "String",required = false)
    })
    @GetMapping("/getString")
    public String getString(){
        return studyService.getString();
    }

    @ApiOperation(value = "测试普通返回",notes = "测试一下")
    @ApiImplicitParam(name = "name", value = "用户名称",dataType = "String",required = false)
    @GetMapping("/getString1")
    public String getString1(){
        return studyService.getString();
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


}
