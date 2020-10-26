package com.temp.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class PersonInfo {

    // 自增长id
    @Id(autoincrement = true)
    private Long id;

    // 姓名
    public String nickName;

    // 密码
    public String password;

    // 性别
    public String gender;

    // 头像路径
    public String avator;



    public PersonInfo(Long id,  String nickName, String gender) {
        this.id = id;
        this.nickName = nickName;
        this.gender = gender;
    }

    
    public PersonInfo() {
    }


    @Generated(hash = 769782658)
    public PersonInfo(Long id, String nickName, String password, String gender,
            String avator) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.gender = gender;
        this.avator = avator;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNickName() {
        return this.nickName;
    }


    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getPassword() {
        return this.password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getGender() {
        return this.gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getAvator() {
        return this.avator;
    }


    public void setAvator(String avator) {
        this.avator = avator;
    }

}
