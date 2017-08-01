package com.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.IDaoTeam;
import com.spring.model.ModelTeam;

@Repository("serviceteam")
public class ServiceTeam implements IServiceTeam {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceTeam.class);

    @Autowired
    IDaoTeam dao;
    
    @Override
    public int login(ModelTeam team) {
        int result = -1;
        try {
            result = dao.login(team);
        } catch (Exception e) {
            logger.error("login" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public List<ModelTeam> getTeamList(ModelTeam team) {
        List<ModelTeam> result = null;
        try {
            result = dao.getTeamList(team);
        } catch (Exception e) {
            logger.error("getTeamList" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int insertTeam(ModelTeam team) {
        int result = -1;
        try {
            result = dao.insertTeam(team);
        } catch (Exception e) {
            logger.error("insertTeam" + e.getMessage() );
            throw e;
        }
        return result;
    }
}
