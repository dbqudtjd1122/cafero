package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<ModelCafeinfo> getCafeList(ModelCafeinfo cafebigtype, String orderKind) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("searchValue", cafebigtype);
        map.put("orderKind", orderKind);
        
        
        return session.selectList("mapper.mysql.mapperTeam.getCafeList", map);
    }

    @Override
    public List<ModelCafeinfo> getCafeListName(String name) {
                
        return session.selectList("mapper.mysql.mapperTeam.getCafeListName", name);
    }

    @Override
    public List<ModelCafeinfo> getCafeListAddr(String addr) {
        
        return session.selectList("mapper.mysql.mapperTeam.getCafeListAddr", addr);
    }
    
    @Override
    public ModelCafeinfo getCafeOne(ModelCafeinfo cafeinfo) {
        
        return session.selectOne("mapper.mysql.mapperTeam.getCafeOne", cafeinfo);
    }
 
}
