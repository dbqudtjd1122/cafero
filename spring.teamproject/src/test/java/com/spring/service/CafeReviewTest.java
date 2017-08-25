package com.spring.service;

import static org.junit.Assert.*;

import java.util.List;

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
    public void testgetReviewList() {
        
        List<ModelCafeReview> result = service.getReviewList("1");
        
        assertNotNull(result);
    }
    
    @Test
    public void testinsertReview() {
        
        ModelCafeReview review = new ModelCafeReview();
        review.setCafeno(1);
        review.setGrade(3.5);
        review.setUsernickname("상어알2");
        review.setContent("맛이있었나");
        
        
        int result = service.insertReview(review);
        service.increaseReview(review.getCafeno());
        service.increaseAvg(review.getCafeno());
        
        assertSame(1, result);
        assertNotNull(result);
    }
    
    @Test
    public void testupdateReview() {
        
        ModelCafeReview review = new ModelCafeReview();
        review.setCommentno(27);
        review.setCafeno(1);
        review.setContent("상어알");
        
        
        int result = service.updateReview(review);
        
        assertSame(1, result);
        assertNotNull(result);
    }
    
    @Test
    public void testdeleteReview() {
        
        ModelCafeReview review = new ModelCafeReview();
        review.setCommentno(32);
        review.setCafeno(22);
        
        
        int result = service.deleteReview(review);
        
        assertSame(1, result);
        assertNotNull(result);
    }
}
