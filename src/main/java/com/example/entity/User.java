package com.example.entity;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @author Adopat
 * @description 用户实体类
 * @date 2023-07-22 11:33
 */
@Table(name = "user")
@Entity
@ApiModel(value = "查询用户参数体合集",description = "查询用户参数体合集")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("创建时间")
    @Column(name = "create_time")
    private String createTime;

    public User() {
    }

    public User(Long id, String name, Integer age, String sex, String address, String phone, String createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {

        this.createTime = createTime;
    }


}
