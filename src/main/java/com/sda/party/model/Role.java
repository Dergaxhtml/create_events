package com.sda.party.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RO_ID")
    private int id;
    @Column(name ="RO_NAME")
    @NotNull
    private String name;
}
