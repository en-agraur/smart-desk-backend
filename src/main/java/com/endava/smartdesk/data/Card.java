package com.endava.smartdesk.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "card")
@Data
public class Card {

    public static final String COLUMN_CARD_NUMBER = "cardNumber";
    public static final String COLUMN_CARD_IDENTIFIER = "cardIdentifier";
    public static final String COLUMN_CARD_STATE = "state";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = COLUMN_CARD_NUMBER, nullable = false)
    private Integer cardNumber;
    @Column(name = COLUMN_CARD_IDENTIFIER, nullable = false)
    private Integer cardIdentifier;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "location", referencedColumnName = "id")
    private Location location;
    @Column(name = COLUMN_CARD_STATE, nullable = false)
    private Integer state;
}
