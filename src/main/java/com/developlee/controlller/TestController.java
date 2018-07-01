package com.developlee.controlller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leson on 2018/6/22.
 */
@RestController
@RequestMapping("/threadLocal")
public class TestController {

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }
}
