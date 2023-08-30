package com.xwd.wxsc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwd.wxsc.entity.BigType;
import com.xwd.wxsc.mapper.BigTypeMapper;
import com.xwd.wxsc.service.IBigTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BigTypeService")
public class BigTypeServiceImpl extends ServiceImpl<BigTypeMapper, BigType> implements IBigTypeService {


    @Autowired
    private BigTypeMapper bigTypeMapper;
}
