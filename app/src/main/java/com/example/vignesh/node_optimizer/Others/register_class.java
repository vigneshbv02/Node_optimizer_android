package com.example.vignesh.node_optimizer.Others;

public class register_class {

    private String name="",phone_no="",email="",password="";

    public register_class(String name, String phone_no, String email, String password)
    {
        this.name=name;
        this.phone_no=phone_no;
        this.email=email;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
