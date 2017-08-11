package com.spring.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.ModelCafeReview;

public class CafeReviewTest {
    // SLF4J Logging
    private static ApplicationContext context = null;
    private static IServiceReview     service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext(
                "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("servicereview", IServiceReview.class);
    }
    
    @Test
    public void testInsertReview() {
        ModelCafeReview review = new ModelCafeReview();
        
        review.setContent("asfd");
        review.setGrade( 4.5);
        
        int result = service.insertReview(review);
        assertSame(result, 1);
    }
}
