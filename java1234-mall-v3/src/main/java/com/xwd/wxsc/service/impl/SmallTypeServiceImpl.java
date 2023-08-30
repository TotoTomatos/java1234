package com.xwd.wxsc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwd.wxsc.entity.BigType;
import com.xwd.wxsc.entity.SmallType;
import com.xwd.wxsc.mapper.BigTypeMapper;
import com.xwd.wxsc.mapper.SmallTypeMapper;
import com.xwd.wxsc.service.IBigTypeService;
import com.xwd.wxsc.service.ISmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SmallTypeService")
public class SmallTypeServiceImpl extends ServiceImpl<SmallTypeMapper, SmallType> implements ISmallTypeService {


    @Autowired
    private SmallTypeMapper smallTypeMapper;
}
