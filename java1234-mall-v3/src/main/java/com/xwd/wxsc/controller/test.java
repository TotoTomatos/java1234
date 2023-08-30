package com.xwd.wxsc.controller;

import com.xwd.wxsc.entity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java1234")
public class test {

    @GetMapping("test")
    public R test(){
        return R.ok("流弊java");
    }
}
