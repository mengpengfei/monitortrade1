package com.dazong.www.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * Created by zhaoxueying on 2016/2/22.
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private static final Logger LOG = LoggerFactory.getLogger(MybatisUtil.class);


    static{
        try{
            reader    = Resources.getResourceAsReader(Thread.currentThread().getContextClassLoader(), "Configuration.xml");
            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, props);
        }catch(Exception e){
            LOG.error("failed to build sqlSessionFactory. {}", e.getMessage(), e);
        }
    }

    public static SqlSessionFactory getSessionFactory(){
        return sqlSessionFactory;
    }
}
