package com.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.ModelCafeMenu;
import com.spring.model.ModelUser;

public class CafeMenuTest {
    private static ApplicationContext context = null;
    private static IServiceCafeMenu   service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("servicecafemenu", IServiceCafeMenu.class);
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testGetCafecd() {
        
        List<String> result = service.getCafecd("스타벅스");
        
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }
    
    @Test
    public void testGetCafeMenu() {
        
        List<ModelCafeMenu> result = service.getCafeMenu("커피", "스타벅스");
        
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }
    
}
