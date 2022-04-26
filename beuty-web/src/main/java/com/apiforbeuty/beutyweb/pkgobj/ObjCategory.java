package com.apiforbeuty.beutyweb.pkgobj;

import lombok.Data;

import javax.persistence.*;

@Entity
//@Data

public class ObjCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Integer id;
    private String name;

//    getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    constructors

    public ObjCategory() {
    }

    public ObjCategory(ObjProduct objProduct) {
        this.id = id;
        this.name = name;
    }
}
