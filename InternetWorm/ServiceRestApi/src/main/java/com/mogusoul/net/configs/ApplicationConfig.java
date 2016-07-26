package com.mogusoul.net.configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.InputStream;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2016/7/22.
 */

@Configuration
//@ComponentScan("com.mogusoul.net.controller")
@ComponentScan({
        "com.soulsbooks.net.service",
        "com.mogusoul.net.aop",
        "com.mogusoul.net.aspect",
        "com.mogusoul.net.controller",
        "com.mogusoul.net.controllerx"})

@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class ApplicationConfig {



    @Bean
    public DriverManagerDataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/soulbook?useUnicode=true&amp;characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("sql123456");

        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        String resource = "configs/mybatis.xml";
        InputStream is = ApplicationConfig.class.getClassLoader().getResourceAsStream(resource);

        sqlSessionFactory.setDataSource(this.dataSource());
        sqlSessionFactory.setConfigLocation(new InputStreamResource(is));

        return sqlSessionFactory;
    }

    @Bean
    public SqlSessionTemplate  sqlSessionTemplate(){
//        String resource = "configs/mybatis.xml";
//        InputStream is = ApplicationConfig.class.getClassLoader().getResourceAsStream(resource);
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);


        SqlSessionTemplate sqlSessionTemplate = null;
        try {

            sqlSessionTemplate = new SqlSessionTemplate(this.sqlSessionFactoryBean().getObject());
        }catch (Exception e){
            e.printStackTrace();
        }

        return sqlSessionTemplate;

    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.soulsbooks.net.mapper");
        configurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        return configurer;
    }






}
