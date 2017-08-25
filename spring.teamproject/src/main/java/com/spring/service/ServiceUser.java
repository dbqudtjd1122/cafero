package com.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoUser;
import com.spring.model.ModelUser;

@Repository("serviceuser")
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);

    @Autowired
    IDaoUser dao;
    
    @Override
    public ModelUser login(ModelUser team) {
        ModelUser result = null;
        try {
            result = dao.login(team);
        } catch (Exception e) {
            logger.error("login" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int insertUser(ModelUser user) {
        int result = -1;
        try {
            result = dao.insertUser(user);
        } catch (Exception e) {
            logger.error("insertUser" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int updateUserinfo(ModelUser updateValue,ModelUser searchValue) {
        
        int result = -1;
        
        try {
            result = dao.updateUserinfo(updateValue,searchValue);
        } catch (Exception e) {
            logger.error("updateUserinfo" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int updatePasswd(String email, String passwd, String newPasswd) {
        int result = -1;
        try {
            result = dao.updatePasswd(email, passwd, newPasswd );
        } catch (Exception e) {
            logger.error("updatePasswd" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int deleteUser(ModelUser searchValue) {
        int result = -1;
        try {
            result = dao.deleteUser(searchValue);
        } catch (Exception e) {
            logger.error("updateUserInfo " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public ModelUser selectId(ModelUser team) {
        ModelUser result = null;
        try {
            result = dao.selectId(team);
        } catch (Exception e) {
            logger.error("selectId" + e.getMessage() );
            throw e;
        }
        return result;
    }

   @Override
    public ModelUser selectPwd(ModelUser team) {
        ModelUser result = null;
        try {
            result = dao.selectPwd(team);
        } catch (Exception e) {
            logger.error("selectPwd" + e.getMessage() );
            throw e;
        }
        return result;
    }
}
