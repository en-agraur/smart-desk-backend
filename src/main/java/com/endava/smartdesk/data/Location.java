package com.endava.smartdesk.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
public class Location {

    public static final String COLUMN_LOCATION_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = COLUMN_LOCATION_NAME, nullable = false)
    private String name;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "city", referencedColumnName = "id")
    private City city;
}
