package com.spring.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelCafeReview {
    // SLF4J Logging
    private static Logger logger  = LoggerFactory
            .getLogger(ModelCafeReview.class);
    
    private String        content = "";
    private Double        grade;
    private Integer       commentno;
    private Integer       userno;
    private Integer       cafeno;
    private Date          regdate;
    
    public ModelCafeReview() {
        super();
    }
    
    public ModelCafeReview(String content, Double grade, Integer commentno,
            Integer userno, Integer cafeno, Date regdate) {
        super();
        this.content = content;
        this.grade = grade;
        this.commentno = commentno;
        this.userno = userno;
        this.cafeno = cafeno;
        this.regdate = regdate;
    }
    
    @Override
    public String toString() {
        return "ModelCafeReview [content=" + content + ", grade=" + grade
                + ", commentno=" + commentno + ", userno=" + userno
                + ", cafeno=" + cafeno + ", regdate=" + regdate + "]";
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Double getGrade() {
        return grade;
    }
    
    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
    
    public Integer getCommentno() {
        return commentno;
    }
    
    public void setCommentno(Integer commentno) {
        this.commentno = commentno;
    }
    
    public Integer getUserno() {
        return userno;
    }
    
    public void setUserno(Integer userno) {
        this.userno = userno;
    }
    
    public Integer getCafeno() {
        return cafeno;
    }
    
    public void setCafeno(Integer cafeno) {
        this.cafeno = cafeno;
    }
    
    public Date getRegdate() {
        return regdate;
    }
    
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

   
    
}
