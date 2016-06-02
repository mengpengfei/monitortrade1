package com.dazong.www.dao;

import com.dazong.www.pojo.TradeLog;
import com.dazong.www.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by meng123 on 2016/5/10.
 */
public class TradeLogMapperDao {
    private static final Logger LOG = LoggerFactory.getLogger(TradeLogMapperDao.class);


    private static String MAPPER = "com.dazong.www.mapper.TradeLogMapper.";
    private static SqlSessionFactory sqlSessionFactory = MybatisUtil.getSessionFactory();


    public int insertTradeLog(TradeLog tradeLog){
        SqlSession session = sqlSessionFactory.openSession();
        int num = 0;
        try {
            num = session.insert(MAPPER.concat("insertTradeLog"), tradeLog);
        } catch (Exception e) {
            LOG.error("failed to execute sql insert. {}", e.getMessage(), e);
        }finally {
            session.commit();
            session.close();
            return num;
        }
    }
 }
