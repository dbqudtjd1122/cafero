package com.spring.dao;

import java.util.List;

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
    public List<ModelCafeReview> getReviewList(String strcafeno) {
        
        Integer cafeno = Integer.valueOf(strcafeno);
        return session.selectList("mapper.mysql.mapperTeam.getReviewList", cafeno);
    }


    @Override
    public int insertReview(ModelCafeReview review) {
        
        return session.insert("mapper.mysql.mapperTeam.insertReview", review);
    }


    @Override
    public int updateReview(ModelCafeReview review) {
        
        return session.update("mapper.mysql.mapperTeam.updateReview", review);
    }


    @Override
    public int deleteReview(ModelCafeReview review) {
        
        return session.delete("mapper.mysql.mapperTeam.deleteReview", review);
    }


    @Override
    public int increaseLike(int cafeno) {
        
        return session.update("mapper.mysql.mapperTeam.increaseLike",cafeno);
    }

    @Override
    public int increaseReview(int cafeno) {
        
        return session.update("mapper.mysql.mapperTeam.increaseReview",cafeno);
    }

    @Override
    public int increaseAvg(int cafeno) {
        return session.update("mapper.mysql.mapperTeam.increaseAvg",cafeno);
    }
    
}
