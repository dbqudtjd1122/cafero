package com.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelCafeLike;

@Repository("daolike")
public class DaoLike implements IDaoLike {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoLike.class);
    
    @Autowired
    private SqlSession session;
    
    @Override
    public int insertBookmark(ModelCafeLike like) {
        
        return session.insert("mapper.mysql.mapperTeam.insertBookmark",like);
    }

    @Override
    public int getBookmark(int cafeno, int userno) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("cafeno", cafeno);
        map.put("userno", userno);
        return session.selectOne("mapper.mysql.mapperTeam.getBookmark",map);
    }

    @Override
    public int deleteBookmark(ModelCafeLike like) {
        
        return session.delete("mapper.mysql.mapperTeam.deleteBookmark",like);
    }

    @Override
    public int increaseLike(int cafeno) {

        return session.update("mapper.mysql.mapperTeam.increaseLike",cafeno);
    }
}
