package com.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoLike;
import com.spring.dao.IDaoReview;
import com.spring.model.ModelCafeLike;

@Repository("servicerelike")
public class ServiceCafeLike implements IServiceCafeLike {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(ServiceCafeLike.class);
    
    @Autowired
    IDaoLike dao;
    
    @Override
    public int insertBookmark(ModelCafeLike like) {
        int result = 0;
        try {
            result = dao.insertBookmark(like);
        } catch (Exception e) {
            logger.error("insertBookmark" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int getBookmark(int cafeno, int userno) {
        int result = 0;
        try {
            result = dao.getBookmark(cafeno, userno);
        } catch (Exception e) {
            logger.error("getBookmark" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int deleteBookmark(ModelCafeLike like) {
        int result = 0;
        try {
            result = dao.deleteBookmark(like);
        } catch (Exception e) {
            logger.error("deleteBookmark" + e.getMessage() );
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
}
