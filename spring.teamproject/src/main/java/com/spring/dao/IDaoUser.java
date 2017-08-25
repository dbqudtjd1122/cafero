package com.spring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelUser;

@Repository
public interface IDaoUser {
    

    ModelUser login(ModelUser team);
    
    int insertUser(ModelUser user);

    int updateUserinfo(ModelUser updateValue, ModelUser searchValue);
    
    int updatePasswd(String email, String newPasswd, String passwd);
    
    int deleteUser(ModelUser user);
    
    ModelUser selectId(ModelUser team);

    ModelUser selectPwd(ModelUser team);

}
