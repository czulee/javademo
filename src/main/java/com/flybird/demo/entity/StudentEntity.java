package com.flybird.demo.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "学号不能为空")
    @Length(min = 8, max = 8, message = "学号长度必须为8")
    @Digits(message = "学号必须是数字", integer = 8, fraction = 0)
    private String no;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
