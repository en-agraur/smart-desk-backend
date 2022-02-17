package com.endava.smartdesk.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visit")
@Data
public class Visit {

    public static final String COLUMN_VISIT_VISITOR_FIRST_NAME = "visitorFirstName";
    public static final String COLUMN_VISIT_VISITOR_LAST_NAME = "visitorLastName";
    public static final String COLUMN_VISIT_VISITOR_SIGNATURE = "visitorSignature";
    public static final String COLUMN_VISIT_COMPANY = "company";
    public static final String COLUMN_VISIT_DATE = "date";
    public static final String COLUMN_VISIT_ARRIVAL_DATE = "arrivalDate";
    public static final String COLUMN_VISIT_STATE = "state";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = COLUMN_VISIT_VISITOR_FIRST_NAME, nullable = false)
    private String visitorFirstName;
    @Column(name = COLUMN_VISIT_VISITOR_LAST_NAME, nullable = false)
    private String visitorLastName;
    @Column(name = COLUMN_VISIT_COMPANY, nullable = false)
    private String company;
    private String hostFirstName;
    private String hostLastName;
    @Column(name = COLUMN_VISIT_ARRIVAL_DATE, nullable = false)
    private Date arrivalDate;
    private Date departureDate;
    @Column(name = COLUMN_VISIT_DATE, nullable = false)
    private Date date;
    @Lob
    @Column(name = COLUMN_VISIT_VISITOR_SIGNATURE, nullable = false)
    private String visitorSignature;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "visitor_card", referencedColumnName = "id")
    private Card visitorCard;
    @Column(name = COLUMN_VISIT_STATE, nullable = false)
    private Integer state;
}
