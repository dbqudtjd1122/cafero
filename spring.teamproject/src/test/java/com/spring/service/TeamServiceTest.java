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

import com.spring.model.ModelTeam;

public class TeamServiceTest {
    
    private static ApplicationContext context = null;
    private static IServiceTeam service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean("serviceteam", IServiceTeam.class);
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testLogin() {
        ModelTeam test = new ModelTeam("bsyoo", "1231");
        int result = service.login(test);
        assertEquals(1, result);
        
        test = new ModelTeam("test2id", "test2pw");
        result = service.login(test);
        assertEquals(0, result);
    }
    
    @Test
    public void testGetTeamList() {
        ModelTeam test = new ModelTeam();
        List<ModelTeam> result = service.getTeamList(test);
        
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }
    
    @Test
    public void testInsertTeam() {
        ModelTeam team = new ModelTeam("dbqudtjd1122@nate.com", "1231", "010-9928-9787", "서울시 중랑구 면목동11", "y", "n");
        
        int result = service.insertTeam(team);
        
        assertSame(result, 1);
    }
}
