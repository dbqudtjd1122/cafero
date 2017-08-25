package com.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.ModelUser;

public class UserServiceTest {
    
    private static ApplicationContext context = null;
    private static IServiceUser service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean("serviceuser", IServiceUser.class);
    }


    private String email;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testLogin() {
        ModelUser user = new ModelUser();
        user.setEmail("123123");
        user.setPasswd("qqq");
        
        user = service.login(user);
    }
    
   
    @Test
    public void testInsertUser() {
        ModelUser user = new ModelUser();
        
        int result = service.insertUser(user);
        
        assertSame(result, 1);
    }
    
    @Test
    public void testupdateUserinfo() {
        
        ModelUser updatevalue = new ModelUser();
        updatevalue.setEmailselect(1);
        updatevalue.setPasswd("1325");
        updatevalue.setSex("남");
        updatevalue.setUseraddr("상계동");
        updatevalue.setUserlevel(1);
        updatevalue.setUsernickname("ㅁㄴㅇㄹ");
        updatevalue.setUserno(1);
        updatevalue.setUserphone("010111111");
        
        ModelUser searchValue = new ModelUser();
        searchValue.setEmail("aa@afsd");
        
        int result = service.updateUserinfo(updatevalue,searchValue);
        
        assertEquals(result, 1);
    }
    
    @Test
    public void testupdatePasswd() {
        
    }

    
    @Test
    public void testdeleteUser() {
        ModelUser user = new ModelUser();
        user.setEmail("dshhi89@nate.com");
       
        int result = service.deleteUser(user);
        assertEquals(result, 1);
        
    }

    @Test
    public void testselectId() {
        ModelUser team = new ModelUser();
        team.setUserphone("010-1234-5678");
        
        ModelUser result = service.selectId(team);
        
        assertEquals(result, 1);
    }
    
    @Test
    public void testselectPwd() {
        ModelUser team = new ModelUser();
        team.setEmail("bbb");
        
        ModelUser result = service.selectPwd(team);
        
        assertEquals(result, 1);
    }
    
}
