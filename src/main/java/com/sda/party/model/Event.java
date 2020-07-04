
package com.sda.party.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @Column
    @NotEmpty
    private String city;


//    @OneToMany(mappedBy = "event")
//    private List<Participation> participant;
//
//    @OneToMany(mappedBy = "event")
//    private List<Comment> comments;
//
//    @Column(name = "EVT_date")
//    @NotEmpty
//    private LocalDateTime eventDate;
//
//    @Column(name = "EVT_address")
//    @NotEmpty
//    private String address;
//
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

}

