package com.unicom.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;



/**
 * @ClassName：MybatisConfig
 * @Author：kuangzy
 * @Time：2019/5/5 20:13
 * @Discription:这里只是演示一下如果通过配置类进行mybatis设置，没有也不影响数据库连接
 */
@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){

            @Override
            public void customize(Configuration configuration) {
                //MapUnderscoreToCamelCase本身可通过mybatis的全局配置文件进行配置，默认为false，设为true之后，可实现从经典数据库列名 A_COLUMN 到经典 Java 属性名 aColumn 的类似映射，有利于避免字段名和成员变量名不一致产生的bug
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
