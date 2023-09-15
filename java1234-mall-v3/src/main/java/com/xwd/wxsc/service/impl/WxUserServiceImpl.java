package com.xwd.wxsc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwd.wxsc.entity.BigType;
import com.xwd.wxsc.entity.WxUserInfo;
import com.xwd.wxsc.mapper.BigTypeMapper;
import com.xwd.wxsc.mapper.WxUserMapper;
import com.xwd.wxsc.service.IBigTypeService;
import com.xwd.wxsc.service.IWxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wxUserService")
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUserInfo> implements IWxUserService {


    @Autowired
    private WxUserMapper wxUserMapper;
}
