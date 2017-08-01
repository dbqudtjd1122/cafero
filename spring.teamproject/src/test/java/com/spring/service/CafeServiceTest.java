package com.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.ModelCafe;


public class CafeServiceTest extends ServiceCafe {
   
    private static ApplicationContext context = null;
    private static IServiceCafe service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean("servicecafe", IServiceCafe.class);
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testgetListCafe() {
        List<ModelCafe> result = service.getCafeList();
        
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }
}
