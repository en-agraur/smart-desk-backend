package com.endava.smartdesk.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String officeCountry;
    private String officeLocation;
    private String officeName;
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
    @Lob
    private String hostSignature;

    public Visit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfficeCountry() {
        return officeCountry;
    }

    public void setOfficeCountry(String officeCountry) {
        this.officeCountry = officeCountry;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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

    public String getHostSignature() {
        return hostSignature;
    }

    public void setHostSignature(String hostSignature) {
        this.hostSignature = hostSignature;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", officeLocation='" + officeLocation + '\'' +
                ", officeName='" + officeName + '\'' +
                ", visitorFirstName='" + visitorFirstName + '\'' +
                ", visitorLastName='" + visitorLastName + '\'' +
                ", company='" + company + '\'' +
                ", hostFirstName='" + hostFirstName + '\'' +
                ", hostLastName='" + hostLastName + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", date=" + date +
                ", visitorSignature='" + visitorSignature + '\'' +
                ", hostSignature='" + hostSignature + '\'' +
                '}';
    }
}
