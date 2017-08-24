package com.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoReview;
import com.spring.model.ModelCafeReview;


@Repository("servicereview")
public class ServiceReview implements IServiceReview {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceReview.class);
    
    @Autowired
    IDaoReview dao;
    
    @Override
    public List<ModelCafeReview> getReviewList(String cafeno) {
        List<ModelCafeReview> result;
        try {
            result = dao.getReviewList(cafeno);
        } catch (Exception e) {
            logger.error("getReviewList" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int insertReview(ModelCafeReview review) {
        int result = -1;
        try {
            result = dao.insertReview(review);
        } catch (Exception e) {
            logger.error("insertReview" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int updateReview(ModelCafeReview review) {
        int result = -1;
        try {
            result = dao.updateReview(review);
        } catch (Exception e) {
            logger.error("updateReview" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    


}
