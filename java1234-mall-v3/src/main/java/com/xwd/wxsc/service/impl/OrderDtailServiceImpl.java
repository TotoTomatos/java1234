package com.xwd.wxsc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwd.wxsc.entity.OrderDetail;
import com.xwd.wxsc.mapper.OrderDetailMapper;
import com.xwd.wxsc.service.IOrderDtailService;
import org.springframework.stereotype.Service;

@Service("orderDtailService")
public class OrderDtailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDtailService {
}
