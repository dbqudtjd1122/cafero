package com.spring.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class ModelCafeReview {


    private Integer commentno;
	private String usernickname;
	private Integer cafeno;
	private String content;
	private double grade;
    private Date regdate;
	private Date updateDate;


    @Override
    public String toString() {
        return "ModelCafeReview{" +
                "commentno=" + commentno +
                ", usernickname='" + usernickname + '\'' +
                ", cafeno=" + cafeno +
                ", content='" + content + '\'' +
                ", grade=" + grade +
                ", regdate=" + regdate +
                ", updateDate=" + updateDate +
                '}';
    }

    public ModelCafeReview() {
    }

    public ModelCafeReview(Integer commentno, String usernickname, Integer cafeno, String content, double grade, Date regdate, Date updateDate) {
        this.commentno = commentno;
        this.usernickname = usernickname;
        this.cafeno = cafeno;
        this.content = content;
        this.grade = grade;
        this.regdate = regdate;
        this.updateDate = updateDate;
    }

    public Integer getCommentno() {
        return commentno;
    }

    public void setCommentno(Integer commentno) {
        this.commentno = commentno;
    }

    public String getUsernickname() {
        return usernickname;
    }

    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }

    public Integer getCafeno() {
        return cafeno;
    }

    public void setCafeno(Integer cafeno) {
        this.cafeno = cafeno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
