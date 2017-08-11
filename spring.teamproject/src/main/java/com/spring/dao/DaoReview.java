package com.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelCafeReview;

@Repository("daoreview")
public class DaoReview implements IDaoReview {
    
    private static Logger logger = LoggerFactory.getLogger(DaoReview.class);
    
    @Autowired
    private SqlSession session;
    
    @Override
    public int insertReview(ModelCafeReview review) {
        return session.insert("mapper.mysql.mapperTeam.insertReview", review);
        
    }
}
