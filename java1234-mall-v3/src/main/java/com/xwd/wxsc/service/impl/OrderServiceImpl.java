package com.xwd.wxsc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwd.wxsc.entity.Order;
import com.xwd.wxsc.mapper.OrderMapper;
import com.xwd.wxsc.service.IOrderService;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
