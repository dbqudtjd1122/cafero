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

    @Override
    public int deleteReview(ModelCafeReview review) {
        int result = -1;
        try {
            result = dao.deleteReview(review);
        } catch (Exception e) {
            logger.error("deleteReview" + e.getMessage() );
            throw e;
        }
        return result;
    }

    
    @Override
    public int increaseLike(int cafeno) {
        int result = 0;
        try {
         result = dao.increaseLike(cafeno);
     } catch (Exception e) {
         logger.error("increaseLike" + e.getMessage() );
         throw e;
     }
         return result;
    }

    @Override
    public int increaseReview(int cafeno) {
        int result = 0;
        try {
            result = dao.increaseReview(cafeno);
        } catch (Exception e) {
            logger.error("increaseReview" + e.getMessage() );
            throw e;
        }
        
        return result;
    }

    @Override
    public int increaseAvg(int cafeno) {
        int result = 0;
        try {
            result = dao.increaseAvg(cafeno);
        } catch (Exception e) {
            logger.error("increaseAvg" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    


}
