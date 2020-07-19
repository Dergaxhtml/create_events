package com.sda.party.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
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

    @ManyToOne
    @JoinColumn(name="EVT_ID")
    private Event event;

    @ManyToOne
    @JoinColumn(name="USR_ID")
    private User user;

    @Column(name = "COMT_Text")
    @Size(max = 500,message = "Comments can have up to 500 signs")
    private String text;
    private Date date;



}
