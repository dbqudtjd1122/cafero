package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelCafeMenu;


@Repository("daocafemenu")
public class DaoCafeMenu implements IDaoCafeMenu {
    // SLF4J Logging
    
    
    @Autowired
    private SqlSession session;
   
    private static Logger logger = LoggerFactory.getLogger(DaoCafeMenu.class);

    @Override
    public List<ModelCafeMenu> getCafeMenu(int cafeno) {
        return session.selectList("mapper.mysql.mapperTeam.getCafeMenu", cafeno);
    }

}
