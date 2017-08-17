package com.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.ModelCafeinfo;


public class CafeinfoServiceTest extends ServiceCafeinfo {
   
    private static ApplicationContext context = null;
    private static IServiceCafeinfo service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean("servicecafe", IServiceCafeinfo.class);
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testgetListCafe() {
        ModelCafeinfo cafebigtype = new ModelCafeinfo();
        cafebigtype.setCafebigtype("카페");
        String orderKind = "review_count";
        List<ModelCafeinfo> result = service.getCafeList(cafebigtype, orderKind);
        
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }
    
    @Test
    public void testgetAddrListCafe() {
        
        String name = "노원구";
        List<ModelCafeinfo> result = service.getCafeListName(name);
        
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }
    
   
}
