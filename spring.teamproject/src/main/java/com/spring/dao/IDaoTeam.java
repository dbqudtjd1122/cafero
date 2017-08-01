package com.spring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelTeam;

@Repository
public interface IDaoTeam {
    
    int login(ModelTeam team);
    List<ModelTeam> getTeamList(ModelTeam team);
    int insertTeam(ModelTeam team);
}
