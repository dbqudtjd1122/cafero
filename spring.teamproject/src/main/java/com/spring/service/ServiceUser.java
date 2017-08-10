package com.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoUser;
import com.spring.model.ModelUser;

@Repository("serviceteam")
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
    public List<ModelUser> getTeamList(ModelUser team) {
        List<ModelUser> result = null;
        try {
            result = dao.getTeamList(team);
        } catch (Exception e) {
            logger.error("getTeamList" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int insertTeam(ModelUser team) {
        int result = -1;
        try {
            result = dao.insertTeam(team);
        } catch (Exception e) {
            logger.error("insertTeam" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int updateUserinfo(ModelUser updateValue, ModelUser searchValue) {
        
        int result = -1;
        
        try {
            result = dao.updateUserinfo(updateValue, searchValue);
        } catch (Exception e) {
            logger.error("updateUserinfo" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int updatePasswd(String newPasswd, String currentPasswd, String email) {
        int result = -1;
        try {
            result = dao.updatePasswd( newPasswd, currentPasswd, email);
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
        }
        return result;
    }

    @Override
    public ModelUser selectUserOne(int userno) {
        
        ModelUser result = null;
        
        try {
            result = dao.selectUserOne(userno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectUserOne" + e.getMessage() );
            throw e;
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
}
