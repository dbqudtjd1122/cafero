package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelUser;

@Repository("daoteam")
public class DaoUser implements IDaoUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoUser.class);

    @Autowired
    private SqlSession session;
    
    @Override
    public int login(ModelUser team) {
        return session.selectOne("mapper.mysql.mapperTeam.login", team);
    }

    @Override
    public List<ModelUser> getTeamList(ModelUser team) {
        return session.selectList("mapper.mysql.mapperTeam.getTeamList", team);
    }

    @Override
    public int insertTeam(ModelUser team) {
        return session.insert("mapper.mysql.mapperTeam.insertTeam", team);
    }
}
