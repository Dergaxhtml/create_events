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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "event",
            joinColumns = {@JoinColumn(name = "PRT_EVT_ID")})
    private Set<Event> events = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user",
            joinColumns = {@JoinColumn(name = "PRT_USR_ID")})
    private Set<User> users = new HashSet<>();

    @Column(name = "PRT_organizator")
    @NotEmpty
    private OrganizationRole organizationRole;
}
