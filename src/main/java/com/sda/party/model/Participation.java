package com.sda.party.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "participation")
@Data
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRT_ID")
    private int id;


    @ManyToOne
    @JoinColumn(name="EVT_ID")
    private Event event;


    @ManyToOne
    @JoinColumn(name="USR_ID")
    private User user;


    @Column(name = "PRT_organizator")
    @NotEmpty
    private OrganizationRole organizationRole;
}
