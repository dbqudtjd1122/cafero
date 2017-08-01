package com.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoCafe;
import com.spring.model.ModelCafe;

@Repository("servicecafe")
public class ServiceCafe implements IServiceCafe {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceCafe.class);
    
    @Autowired
    IDaoCafe dao;
    
    @Override
    public List<ModelCafe> getCafeList() {
        List<ModelCafe> result = null;
        try {
            result = dao.getCafeList();
        } catch (Exception e) {
            logger.error("getCafeList" + e.getMessage() );
            throw e;
        }
        return result;
    }
}
