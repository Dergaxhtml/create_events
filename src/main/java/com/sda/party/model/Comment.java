package com.sda.party.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
@Data
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMT_ID")
    private int id;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "event",
            joinColumns = {@JoinColumn(name = "COMT_EVT_ID")})
    private Set<Event> events = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user",
            joinColumns = {@JoinColumn(name = "COMT_USR_ID")})
    private Set<User> users = new HashSet<>();

    @Column(name = "COMT_Text")
    private String text;



}
