package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelCafeinfo;

@Repository("daocafe")
public class DaoCafeinfo implements IDaoCafeinfo {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoCafeinfo.class);
    
    @Autowired
    private SqlSession session;
    
    @Override
    public List<ModelCafeinfo> getCafeList() {
        return session.selectList("mapper.mysql.mapperTeam.getCafeList");
    }
}
