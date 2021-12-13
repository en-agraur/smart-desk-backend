package com.endava.smartdesk.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Location location;
    private String visitorFirstName;
    private String visitorLastName;
    private String company;
    private String hostFirstName;
    private String hostLastName;
    private Date arrivalDate;
    private Date departureDate;
    private Date date;
    @Lob
    private String visitorSignature;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "visitor_card", referencedColumnName = "id")
    private Card visitorCard;
    /**
     * 0 - finished
     * 1 - active
     */
    private Integer state;

    public Visit() {
        // required empty constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getVisitorFirstName() {
        return visitorFirstName;
    }

    public void setVisitorFirstName(String visitorFirstName) {
        this.visitorFirstName = visitorFirstName;
    }

    public String getVisitorLastName() {
        return visitorLastName;
    }

    public void setVisitorLastName(String visitorLastName) {
        this.visitorLastName = visitorLastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHostFirstName() {
        return hostFirstName;
    }

    public void setHostFirstName(String hostFirstName) {
        this.hostFirstName = hostFirstName;
    }

    public String getHostLastName() {
        return hostLastName;
    }

    public void setHostLastName(String hostLastName) {
        this.hostLastName = hostLastName;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVisitorSignature() {
        return visitorSignature;
    }

    public void setVisitorSignature(String visitorSignature) {
        this.visitorSignature = visitorSignature;
    }

    public Card getVisitorCard() {
        return visitorCard;
    }

    public void setVisitorCard(Card visitorCard) {
        this.visitorCard = visitorCard;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
