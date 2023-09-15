package com.xwd.wxsc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwd.wxsc.constant.SystemConstant;
import com.xwd.wxsc.entity.R;
import com.xwd.wxsc.entity.WxUserInfo;
import com.xwd.wxsc.properties.WeixinProperties;
import com.xwd.wxsc.service.IWxUserService;
import com.xwd.wxsc.util.HttpClientUtil;
import com.xwd.wxsc.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private WeixinProperties weixinProperties;

    @Autowired
    private HttpClientUtil httpClientUtil;

    @Autowired
    private IWxUserService wxUserService;

    /**
     *微信login登录
     * @return
     */
    @PostMapping("wxlogin")
    public R wxLogin(@RequestBody WxUserInfo wxUserInfo){
        System.out.println(wxUserInfo);
        String jscode2sessionUrl = weixinProperties.getJscode2sessionUrl()+"?appid="+weixinProperties.getAppid()+"&secret="+weixinProperties.getSecret()+"&js_code="+wxUserInfo.getCode()+"&grant_type=authorization_code";
        System.out.println(jscode2sessionUrl);
        String s = httpClientUtil.sendHttpGet(jscode2sessionUrl);
        System.out.println(s);
        JSONObject jsonObject = JSON.parseObject(s);
        String openid = jsonObject.get("openid").toString();
        System.out.println(openid);
        //插入用户到数据库 如果用户不存在 插入用户  如果用户存在 则更新用户数据
        WxUserInfo resultWxUserInfo = wxUserService.getOne(new QueryWrapper<WxUserInfo>().eq("openid", openid));
        if(resultWxUserInfo==null){
            wxUserInfo.setOpenid(openid);
            wxUserInfo.setLastLoginDate(new Date());
            wxUserInfo.setRegisterDate(new Date());
            System.out.println("不存在 插入用户");
            wxUserService.save(wxUserInfo);
        }else {
            System.out.println("存在 更新用户");
            resultWxUserInfo.setNickName(wxUserInfo.getNickName());
            resultWxUserInfo.setAvatarUrl(wxUserInfo.getAvatarUrl());
            resultWxUserInfo.setLastLoginDate(new Date());
            wxUserService.updateById(resultWxUserInfo);
        }
        //利用jwt生成token返回到前端
        String token = JwtUtils.createJWT(openid, wxUserInfo.getNickName(), SystemConstant.JWT_TTL);
        Map<String , Object> map =new HashMap<>();
        map.put("token",token);
        return R.ok(map);
    }
}
