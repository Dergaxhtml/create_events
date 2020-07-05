
package com.sda.party.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVT_ID")
    private int id;

    @Column(name = "EVT_name")
    @NotEmpty
    private String name;

    @Column(name = "EVT_city")
    @NotEmpty
    private String city;


//    @OneToMany(mappedBy = "event")
//    private List<Participation> participant;
//
//    @OneToMany(mappedBy = "event")
//    private List<Comment> comments;

    @Column(name = "EVT_date")
    @NotEmpty
    private LocalDate eventDate;

    @Column(name = "EVT_address")
    @NotEmpty
    private String address;

//    @Column(name = "EVT_access")
//    @NotEmpty
//    private Access access;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

