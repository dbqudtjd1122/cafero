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
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testLogin() {
        ModelUser test = new ModelUser("bsyoo", "1231");
        int result = service.login(test);
        assertEquals(1, result);
        
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
    
    @Test
    public void testupdateUserinfo() {
        ModelUser updatevalue = new ModelUser();
        updatevalue.setEmail("sonyo@hanmail.net");
        updatevalue.setPasswd("14232");
        updatevalue.setSex("0");
        updatevalue.setUseraddr("건영백화점");
        updatevalue.setUsernickname("하계동보안관");
        updatevalue.setUserphone("일이삼사오");
       
        
        ModelUser searchvalue = new ModelUser();
        searchvalue.setUsernickname("상어알"); 
        
        int result = service.updateUserinfo(updatevalue, searchvalue);
        
        assertEquals(result, 1);
    }
    
    @Test
    public void testupdatePasswd() {
        
        ModelUser updatevalue = new ModelUser();
        updatevalue.setPasswd("56789");
        
        ModelUser searchvalue = new ModelUser();
        searchvalue.setEmail("aa@nate.com");
        
        int result = service.updatePasswd(updatevalue, searchvalue );
        
        assertEquals(result, 1);
    }

    
}
