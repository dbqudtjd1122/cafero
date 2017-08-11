package com.spring.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ModelUser {
    
    private Integer userno;
    private Integer userlevel;
    private String  email        = "";
    private String  passwd       = "";
    private String  userphone    = "";
    private String  useraddr     = "";
    private String  sex          = "";
    private String  emailselect  = "";
    private String  usernickname = "";
    
    public Integer getUserno() {
        return userno;
    }
    
    public void setUserno(Integer userno) {
        this.userno = userno;
    }
    
    public Integer getUserlevel() {
        return userlevel;
    }
    
    public void setUserlevel(Integer userlevel) {
        this.userlevel = userlevel;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPasswd() {
        return passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public String getUserphone() {
        return userphone;
    }
    
    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
    
    public String getUseraddr() {
        return useraddr;
    }
    
    public void setUseraddr(String useraddr) {
        this.useraddr = useraddr;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getEmailselect() {
        return emailselect;
    }
    
    public void setEmailselect(String emailselect) {
        this.emailselect = emailselect;
    }
    
    public String getUsernickname() {
        return usernickname;
    }
    
    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }
    
    @Override
    public String toString() {
        return "ModelUser [userno=" + userno + ", userlevel=" + userlevel
                + ", email=" + email + ", passwd=" + passwd
                + ", userphone=" + userphone + ", useraddr=" + useraddr
                + ", sex=" + sex + ", emailselect=" + emailselect
                + ", usernickname=" + usernickname + "]";
    }

    public ModelUser() {
        super();
    }

    public ModelUser(String passwd) {
        super();
        this.passwd = passwd;
    }
    

    public ModelUser(String email, String passwd) {
        super();
        this.email = email;
        this.passwd = passwd;
    }

}
