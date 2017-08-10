package com.spring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelUser;

@Repository
public interface IDaoUser {
    
    ModelUser selectUserOne(int userno);
    ModelUser login(ModelUser team);
    List<ModelUser> getTeamList(ModelUser team);
    int insertTeam(ModelUser team);
    int updateUserinfo(ModelUser updateValue,ModelUser searchValue);
    int updatePasswd(String newPasswd, String currentPasswd, String email);
    int deleteUser(ModelUser user);
}
