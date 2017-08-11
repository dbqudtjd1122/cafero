package com.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.model.ModelCafeReview;

public interface IDaoReview {
    
    int insertReview(ModelCafeReview review);
    
}
