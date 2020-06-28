
package com.sda.party.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVT_ID")
    private int id;

    @Column(name = "EVT_data")
    @NotEmpty
    private String data;

    @Column(name = "EVT_address")
    @NotEmpty
    private String address;

    @Column(name = "EVT_access")
    @NotEmpty
    private String access;

    @Column(name = "EVT_organizator")
    @NotEmpty
    private String organizator;

}

