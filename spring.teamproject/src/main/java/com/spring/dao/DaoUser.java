package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelUser;

@Repository("daouser")
public class DaoUser implements IDaoUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoUser.class);

    @Autowired
    private SqlSession session;
    

    @Override
    public ModelUser login(ModelUser user) {
        
        return session.selectOne("mapper.mysql.mapperTeam.login", user);
    }


    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mapper.mysql.mapperTeam.insertUser", user);
    }
    
    @Override
    public int updatePasswd(String email, String passwd, String newPasswd) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("newPasswd"    , newPasswd);
        map.put("passwd", passwd);
        map.put("email", email);
                
        return session.update("mapper.mysql.mapperTeam.updatePasswd", map);
    }
    
    @Override
    public int updateUserinfo(ModelUser updateValue,ModelUser searchValue) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("updateValue", updateValue);
        map.put("searcheValue", searchValue);
        return session.update("mapper.mysql.mapperTeam.updateUserinfo",map);
    }
    @Override
    public int deleteUser(ModelUser user) {
        
        return session.delete("mapper.mysql.mapperTeam.deleteUser",user);
    }
    
    @Override
    public ModelUser selectId(ModelUser team) {
        return session.selectOne("mapper.mysql.mapperTeam.selectId",team);
    }


    @Override
    public ModelUser selectPwd(ModelUser team) {
        return session.selectOne("mapper.mysql.mapperTeam.selectPwd",team);
    }
}
