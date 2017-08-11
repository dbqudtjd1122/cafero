package com.spring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelUser;

@Repository
public interface IDaoUser {
    
<<<<<<< HEAD
    int login(ModelUser team);
    
=======
    ModelUser selectUserOne(int userno);
    ModelUser login(ModelUser team);
>>>>>>> f1eb6db7ddde5f6c858dba5d259e953130d472a4
    List<ModelUser> getTeamList(ModelUser team);
    
    int insertTeam(ModelUser team);
<<<<<<< HEAD
    
=======
    int updateUserinfo(ModelUser updateValue,ModelUser searchValue);
    int updatePasswd(String email, String newPasswd, String passwd);
    int deleteUser(ModelUser user);
>>>>>>> f1eb6db7ddde5f6c858dba5d259e953130d472a4
}
