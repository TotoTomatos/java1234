package com.xwd.wxsc.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * mybaitisplus
 *
 */
@Configuration
public class MybatisPlusConfig {


    /**
     * 加上此方法使分页插件生效
     * @return
     */
    public PaginationInterceptor paginationInterceptor(){return new PaginationInterceptor();}

}
