package com.dazong.www.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class Configuration {
    private static ConcurrentHashMap<String, Properties> propertiesMap = new ConcurrentHashMap<String, Properties>();
//    static {
//        init();
//    }
//    
//    private static void init(){
//        String[] configFileArr = new String[]{"mail.properties"};
//        for(String configFile : configFileArr){
//            addProperties(configFile);
//        }
//    }
    
    public static synchronized void addProperties(String fileName){
        InputStream is = null;
        try {
            if(propertiesMap.get(fileName) != null)return;
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            Properties props = new Properties();
            props.load(is);
            propertiesMap.putIfAbsent(fileName, props);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(fileName + " not found");
        } catch (IOException e) {
            throw new RuntimeException("load " + fileName + " file error");
        }finally{
            if(is != null){
                try{is.close();}catch(Exception e){}
            }
        }
    }
    
    public static synchronized String getProperty(String propertyFileName, String propertyKey){
        return getProperty(propertyFileName, propertyKey, "");
    }
    
    public static synchronized String getProperty(String propertyFileName, String propertyKey, String defaultPropertyValue){
        Properties props = propertiesMap.get(propertyFileName);
        if(props == null){
            addProperties(propertyFileName);
        }
        props = propertiesMap.get(propertyFileName);
        if(props == null)return defaultPropertyValue;
        String propertyValue = props.getProperty(propertyKey);
        if(propertyValue == null)return defaultPropertyValue;
        return propertyValue;
    }
}
