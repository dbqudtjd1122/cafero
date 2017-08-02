package com.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoCafeinfo;
import com.spring.model.ModelCafeinfo;

@Repository("servicecafe")
public class ServiceCafeinfo implements IServiceCafeinfo {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceCafeinfo.class);
    
    @Autowired
    IDaoCafeinfo dao;
    
    @Override
    public List<ModelCafeinfo> getCafeList() {
        List<ModelCafeinfo> result = null;
        try {
            result = dao.getCafeList();
        } catch (Exception e) {
            logger.error("getCafeList" + e.getMessage() );
            throw e;
        }
        return result;
    }
}
