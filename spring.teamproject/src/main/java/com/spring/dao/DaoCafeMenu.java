package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelCafeMenu;


@Repository("daocafemenu")
public class DaoCafeMenu implements IDaoCafeMenu {
    // SLF4J Logging
    
    private static Logger logger = LoggerFactory.getLogger(DaoCafeMenu.class);

    @Autowired
    private SqlSession session;
    
    @Override
    public List<String> getCafecd(String brand) {
        return session.selectList("mapper.mysql.mapperTeam.getCafecd", brand);
    }

    @Override
    public List<ModelCafeMenu> getCafeMenu(String menucd, String brand) {
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("menucd", menucd);
        map.put("brand", brand);
        
        return session.selectList("mapper.mysql.mapperTeam.getCafeMenu", map);
    }
    
    

}
