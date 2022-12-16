package com.study.springboot202210h.web.controller;

import com.study.springboot202210h.web.dto.RequestStudyDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ControllerStudy {

    @ResponseBody
    @GetMapping("/study/page")
    public String 페이지응답() {
        return "page_study";
    }
    
    @ResponseBody
    @GetMapping("/study/text/1")
    public String 문자열데이터응답(){
        return "문자열을 응답";
    }

    @GetMapping("/study/text/2")
    public String 요청데이터Params(String data1, int data2){
        return "문자열:" + data1  + ", 숫자:" + data2;
    }

    @ResponseBody
    @GetMapping("/study/text/3")
    public String 요청데이터Obj(RequestStudyDto requestStudyDto){
        return requestStudyDto.toString();
    }
}
