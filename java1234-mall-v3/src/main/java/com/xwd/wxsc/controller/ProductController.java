package com.xwd.wxsc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xwd.wxsc.entity.Product;
import com.xwd.wxsc.entity.ProductSwiperImage;
import com.xwd.wxsc.entity.R;
import com.xwd.wxsc.service.IProductService;
import com.xwd.wxsc.service.IProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductSwiperImageService productSwiperImageService;

    @GetMapping("findSwiper")
    public R findSwiper(){
        List<Product> list = productService.list(new QueryWrapper<Product>().eq("isSwiper", true).orderByAsc("swiperSort"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("message",list);
        return R.ok(map);
    }


    /**
     * 查询热卖商品
     * @return
     */
    @GetMapping("findHot")
    public R findHot(){
        Page<Product> page = new Page<>(0,8);
        Page<Product> productPage = productService.page(page, new QueryWrapper<Product>().eq("isHot", 1).orderByAsc("hotDateTime"));
        List<Product> productList = productPage.getRecords();
        HashMap<String, Object> map = new HashMap<>();
        map.put("message",productList);
        return R.ok(map);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("dtail")
    public R detail(Integer id){
        Product product = productService.getById(id);
        List<ProductSwiperImage> productSwiperImageList = productSwiperImageService.list(new QueryWrapper<ProductSwiperImage>().eq("productId", product.getId()).orderByAsc("sort"));
        Map map = new HashMap<String,Object>();
        product.setProductSwiperImageList(productSwiperImageList);
        map.put("massage",product);
        return R.ok(map);
    }
}
