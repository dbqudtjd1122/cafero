package com.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoCafeMenu;
import com.spring.dao.IDaoReview;
import com.spring.model.ModelCafeMenu;
import com.spring.model.ModelUser;


@Repository("servicecafemenu")
public class ServiceCafeMenu implements IServiceCafeMenu {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(ServiceCafeMenu.class);
    
    @Autowired
    IDaoCafeMenu dao;

    @Override
    public List<String> getCafecd(String brand) {
        List<String> result = null;
        try {
            result = dao.getCafecd(brand);
        } catch (Exception e) {
            logger.error("getCafecd" + e.getMessage() );
            throw e;
        }
        return result;
        
    }

    @Override
    public List<ModelCafeMenu> getCafeMenu(String menucd, String brand) {
        List<ModelCafeMenu> result = null;
        try {
            result = dao.getCafeMenu(menucd, brand);
        } catch (Exception e) {
            logger.error("getCafeMenu" + e.getMessage() );
            throw e;
        }
        return result;
    }

}
