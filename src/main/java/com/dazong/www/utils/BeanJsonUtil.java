package com.dazong.www.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 *  Created by cczhu on 2016/1/19.
 *  实现BEAN至JSON/XML 之间的转换
 * Revision History:
 */
public class BeanJsonUtil {

    /**
     * 实现将bean转换为JSON字符串
     * @param bean
     * @return
     */
    public static String bean2Json(Object bean){
        return bean2Json(bean,null);
    }

    public static String bean2JsonWithDateFormat(Object bean,String dateFormat){
        return bean2Json(bean,dateFormat,null);
    }

    public static String bean2Json(Object bean,String dateFormat,SerializerFeature[] features ){
        if(null == bean){
            throw new IllegalArgumentException("target bean is null!");
        }
        try {
            String json = null;
            if(null == features){
                features = new SerializerFeature[0];
                json = JSON.toJSONStringWithDateFormat(bean, dateFormat, features);
            }else{
                json =  JSON.toJSONStringWithDateFormat(bean, dateFormat, features);
            }
            return json;
        } catch (Exception ex){
            throw new JSONException("Met error in converting bean" +
                    " to json!Error:"+ex.getMessage(),ex);
        }
    }

    /**
     * 实现将bean转换为JSON字符串
     *  SerializerFeature 具体定义见 http://code.alibabatech.com/wiki/display/FastJSON/Serial+Features
     * @param bean
     * @return
     * @throws   com.alibaba.fastjson.JSONException
     */
    public static String bean2Json(Object bean,SerializerFeature[] features ){
        if(null == bean){
            throw new IllegalArgumentException("target bean is null!");
        }
        try {
            String json = null;
            if(null == features)
                json = JSON.toJSONString(bean);
            else
                json = JSON.toJSONString(bean,features);
            return json;
        } catch (Exception ex){
            throw new JSONException("Met error in converting bean" +
                    " to json!Error:"+ex.getMessage(),ex);
        }
    }

    /**
     * 将json字符串转化为JSON
     * 注意：
     *     转换时仅对bean与JSON中对应的key进行赋值，其他无法映射的值均为空
     * @param json
     * @param targertClass
     * @return
     * @throws   com.alibaba.fastjson.JSONException
     */
    public static <T> T json2Object(String json,Class<T> targertClass){
        if(null == json || json.length() == 0){
            throw new IllegalArgumentException("input json string is blank!");
        }
        try{
            T bean = JSON.parseObject(json, targertClass);
            return bean;
        }catch (Exception ex){
            throw new JSONException("Met error in converting json string" +
                    " to bean!Error:"+ex.getMessage(),ex);
        }
    }

    /**
     * 将json字符串转化为JSON
     * 注意：
     *     转换时仅对bean与JSON中对应的key进行赋值，其他无法映射的值均为空
     * @param json
     * @param targertClass
     * @param features
     * @return
     * @throws   com.alibaba.fastjson.JSONException
     */
    public static Object json2Object(String json,Class<?> targertClass,Feature... features){
        if(null == json || json.length() == 0){
            throw new IllegalArgumentException("input json string is blank!");
        }
        try{
            Object bean = JSON.parseObject(json, targertClass,features);
            return bean;
        }catch (Exception ex){
            throw new JSONException("Met error in converting json string" +
                    " to bean!Error:"+ex.getMessage(),ex);
        }
    }

    /**
     * 将json转换为JSONObject
     * @param json
     * @return
     * @throws   com.alibaba.fastjson.JSONException
     */
    public static JSONObject toJsonObject(String json){
        if(null == json || json.length() == 0){
            throw new IllegalArgumentException("input json string is blank!");
        }
        try{
            JSONObject jsonObj = JSON.parseObject(json);
            return jsonObj;
        }catch (Exception ex){
            throw new JSONException("Met error in converting json string" +
                    " to bean!Error:"+ex.getMessage(),ex);
        }
    }

    /**
     * 将json转换为JSONArray
     * @param json
     * @return
     * @throws   com.alibaba.fastjson.JSONException
     */
    public static JSONArray toJsonArray(String json){
        if(null == json || json.length() == 0){
            throw new IllegalArgumentException("input json string is blank!");
        }
        try{
            JSONArray jsonArray = JSON.parseArray(json);
            return jsonArray;
        }catch (Exception ex){
            throw new JSONException("Met error in converting json string" +
                    " to bean!Error:"+ex.getMessage(),ex);
        }
    }


}
