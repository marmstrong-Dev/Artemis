package com.artemis.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Keepers")
public class Keeper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "keeper_id")
    private Integer id;

    @Column(name = "keeper_first_name", nullable = false)
    private String firstName;

    @Column(name = "keeper_last_name", nullable = false)
    private String lastName;

    @Column(name = "keeper_start_date")
    private Date startDate;

    @Column(name = "keeper_phone")
    private String phoneNumber;

    @Column(name = "keeper_email")
    private String emailAddress;

    public Keeper() {}

    public Keeper(
            Integer id, String firstName, String lastName,
            Date startDate, String phoneNumber, String emailAddress
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
