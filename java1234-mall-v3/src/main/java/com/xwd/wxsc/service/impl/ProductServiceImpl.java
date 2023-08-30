package com.xwd.wxsc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwd.wxsc.entity.Product;
import com.xwd.wxsc.mapper.ProductMapper;
import com.xwd.wxsc.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品service实现类
 */
@Service("productservice")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;
}
