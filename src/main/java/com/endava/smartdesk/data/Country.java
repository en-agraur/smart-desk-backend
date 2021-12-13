package com.endava.smartdesk.data;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    public static final String COLUMN_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = COLUMN_NAME)
    private String name;
    private String flag;

    public Country() {

    }

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
