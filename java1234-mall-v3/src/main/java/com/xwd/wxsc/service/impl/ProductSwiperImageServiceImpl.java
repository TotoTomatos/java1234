package com.xwd.wxsc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwd.wxsc.entity.ProductSwiperImage;
import com.xwd.wxsc.mapper.ProductSwiperImageMapper;
import com.xwd.wxsc.service.IProductSwiperImageService;
import org.springframework.stereotype.Service;

@Service("productSwiperImageService")
public class ProductSwiperImageServiceImpl extends ServiceImpl<ProductSwiperImageMapper, ProductSwiperImage> implements IProductSwiperImageService {
}
