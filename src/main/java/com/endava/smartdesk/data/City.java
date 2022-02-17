package com.endava.smartdesk.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
public class City {

    public static final String COLUMN_CITY_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = COLUMN_CITY_NAME, nullable = false)
    private String name;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "country", referencedColumnName = "id")
    private Country country;
}
