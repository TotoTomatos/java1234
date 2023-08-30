package com.xwd.wxsc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwd.wxsc.entity.BigType;
import com.xwd.wxsc.entity.Product;
import com.xwd.wxsc.entity.R;
import com.xwd.wxsc.entity.SmallType;
import com.xwd.wxsc.service.IBigTypeService;
import com.xwd.wxsc.service.IProductService;
import com.xwd.wxsc.service.ISmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bigType")
public class BigTypeController {

    @Autowired
    private IBigTypeService bigTypeService;

    @Autowired
    private ISmallTypeService smallTypeService;

    @Autowired
    private IProductService productService;

    /**
     * 查询所有商品大类
     * @return
     */
    @GetMapping("findAll")
    public R findAll(){
        List<BigType> bigTypeList = bigTypeService.list(new QueryWrapper<BigType>().orderByDesc("id"));
        Map<String, Object> map = new HashMap<>();
        map.put("message",bigTypeList);
        return new R().ok(map);

    }

    @GetMapping("findCategorys")
    public R findCategorys(){
        List<BigType> bigTypeList = bigTypeService.list();
        for(BigType bigType : bigTypeList){
            List<SmallType> smallTypeList = smallTypeService.list(new QueryWrapper<SmallType>().eq("bigTypeId", bigType.getId()));
            bigType.setSmallTypeList(smallTypeList);
            for (SmallType smallType : smallTypeList){
                List<Product> productList = productService.list(new QueryWrapper<Product>().eq("typeId", smallType.getId()));
                smallType.setProductList(productList);
            }

        }
        Map<String, Object> map = new HashMap<>();
        map.put("message",bigTypeList);
        return new R().ok(map);
    }


}
