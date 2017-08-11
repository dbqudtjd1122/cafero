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
        service=context.getBean("serviceteam", IServiceUser.class);
    }


    private String email;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testLogin() {
        ModelUser test = new ModelUser("aa@nate.com", "123123");
        ModelUser result = service.login(test);
        
        test = new ModelUser("test2id", "test2pw");
        result = service.login(test);
        assertEquals(0, result);
    }
    
    @Test
    public void testGetTeamList() {
        ModelUser test = new ModelUser();
        List<ModelUser> result = service.getTeamList(test);
        
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }
    
    @Test
    public void testInsertTeam() {
        ModelUser team = new ModelUser("dbqudtjd1122@nate.com", "1231", "010-9928-9787", "서울시 중랑구 면목동11", "y", "n", "상어알");
        
        int result = service.insertTeam(team);
        
        assertSame(result, 1);
    }
    
    /*@Test
    public void testupdateUserinfo() {
        
        ModelUser updatevalue = new ModelUser("fsdf","fdsf","sdfsdf","sdfsd","fsdf","sdfsf");
        
        ModelUser searchValue = new ModelUser();
        searchValue.setEmail("aa@afsd");
        
        int result = service.updateUserinfo(updatevalue,searchValue);
        
        assertEquals(result, 1);
    }*/
    
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

    
}
