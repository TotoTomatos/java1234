package com.xwd.wxsc.controller;

import com.xwd.wxsc.entity.Order;
import com.xwd.wxsc.entity.R;
import com.xwd.wxsc.service.IOrderDtailService;
import com.xwd.wxsc.service.IOrderService;
import com.xwd.wxsc.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("my/order")
public class OrderController {


    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDtailService orderDtailService;

    @PostMapping("create")
    public R create(@RequestBody Order order, @RequestHeader(value = "token") String token){
        //通过token获取openid
        System.out.println("token="+token);

        Claims claims = JwtUtils.validateJWT(token).getClaims();
        if(claims!=null){
            System.out.println("openid="+claims.getId());
        }
        //添加订单到数据库


        //添加订单详情到数据库
        return R.ok();
    }


}
