package com.cafe.adminapp.Model;

public class ModelUser {
    
    private Integer userno;
    private String email = "";
    private String pw = "";
    private String userphone = "";
    private String useraddr = "";
    private String sex = "";
    private String emailselect = "";
    private String usernickname = "";
    
    
    public Integer getUserno() {
        return userno;
    }
    public void setUserno(Integer userno) {
        this.userno = userno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
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
        return "ModelUser [userno=" + userno + ", email=" + email + ", pw=" + pw
                + ", userphone=" + userphone + ", useraddr=" + useraddr
                + ", sex=" + sex + ", emailselect=" + emailselect
                + ", usernickname=" + usernickname + "]";
    }

    public ModelUser(String email, String pw, String userphone, String useraddr, String sex, String emailselect, String usernickname) {
        this.email = email;
        this.pw = pw;
        this.userphone = userphone;
        this.useraddr = useraddr;
        this.sex = sex;
        this.emailselect = emailselect;
        this.usernickname = usernickname;
    }

    public ModelUser(Integer userno, String email, String pw, String userphone,
                     String useraddr, String sex, String emailselect,
                     String usernickname) {
        super();
        this.userno = userno;
        this.email = email;
        this.pw = pw;
        this.userphone = userphone;
        this.useraddr = useraddr;
        this.sex = sex;
        this.emailselect = emailselect;
        this.usernickname = usernickname;
    }
    public ModelUser() {
        super();
    }
    public ModelUser(String email, String pw) {
        super();
        this.email = email;
        this.pw = pw;
    }
    
    
   
    
    
    
    
    
  
 
    
  
   
}
