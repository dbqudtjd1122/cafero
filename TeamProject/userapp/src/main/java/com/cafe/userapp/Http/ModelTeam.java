package com.cafe.userapp.Http;



public class ModelTeam {

    private String email = "";
    private String pw = "";
    private String phone = "";
    private String address = "";
    private Boolean sex = null;
    private Boolean emailselect = null;

    public ModelTeam(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    public ModelTeam() {
    }

    public ModelTeam(String email, String pw, String phone, String address, Boolean sex, Boolean emailselect) {
        this.email = email;
        this.pw = pw;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.emailselect = emailselect;
    }

    @Override
    public String toString() {
        return "ModelTeam{" +
                "email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", emailselect=" + emailselect +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getEmailselect() {
        return emailselect;
    }

    public void setEmailselect(Boolean emailselect) {
        this.emailselect = emailselect;
    }
}
