package com.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.model.ModelCafeLike;

public interface IDaoLike {
    
    int insertBookmark(ModelCafeLike like);
    
    int getBookmark(int cafeno, int userno);
    
    int deleteBookmark(ModelCafeLike like);
    
    int increaseLike(int cafeno);
}
