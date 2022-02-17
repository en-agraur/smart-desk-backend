package com.endava.smartdesk.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
public class Country {

    public static final String COLUMN_COUNTRY_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = COLUMN_COUNTRY_NAME, nullable = false)
    private String name;
}
