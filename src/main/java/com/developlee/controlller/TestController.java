package com.developlee.controlller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Leson on 2018/6/22.
 */
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }
}
