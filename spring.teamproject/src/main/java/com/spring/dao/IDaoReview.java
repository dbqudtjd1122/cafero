package com.spring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.model.ModelCafeReview;

public interface IDaoReview {
    
    List<ModelCafeReview> getReviewList(String cafeno);
    
    int insertReview(ModelCafeReview review);
    
    int updateReview(ModelCafeReview review);
    
    int deleteReview(ModelCafeReview review);
    
    int increaseLike(int cafeno);
    int increaseReview(int cafeno);
    int increaseAvg(int cafeno);
}
