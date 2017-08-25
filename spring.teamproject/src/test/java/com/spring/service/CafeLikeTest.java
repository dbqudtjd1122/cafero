package com.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.ModelCafeLike;
import com.spring.model.ModelCafeReview;

public class CafeLikeTest {
    // SLF4J Logging
    private static ApplicationContext context = null;
    private static IServiceCafeLike     service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext(
                "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("servicerelike", IServiceCafeLike.class);
    }
    
    @Test
    public void testgetBookmark() {
        
        int result = service.getBookmark(1, 6);
        
        assertNotNull(result);
    }
    
    @Test
    public void testdeleteBookmark() {
        
        ModelCafeLike like = new ModelCafeLike();
        like.setCafeno(1);
        like.setUserno(4);
        
        int result = service.deleteBookmark(like);
        
        assertSame(1, result);
        assertNotNull(result);
    }
    
    @Test
    public void testinsertBookmark() {
        
        ModelCafeLike like = new ModelCafeLike();
        like.setCafeno(1);
        like.setUserno(4);
        
        int result = service.insertBookmark(like);
        
        assertSame(1, result);
        assertNotNull(result);
    }
    
    
    @Test
    public void testincreaseLike() {
        
        ModelCafeLike like = new ModelCafeLike();
        like.setCafeno(1);
        like.setUserno(4);
        
        int result = service.increaseLike(like.getCafeno());
        
        assertSame(1, result);
        assertNotNull(result);
    }
}
