package com.ch.ch6_1.entity;

import javax.persistence.*;
import java.io.Serializable;

//创建一个可以被rest操作的实体类
@Entity
@Table(name="student_table")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//主键

    //三个属性
    private String sno;
    private String sname;
    private String ssex;

    //构造方法
    public Student(String sno, String sname, String ssex){
        super();
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
    }



    public Student() {
        super();
    }


    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }


}
