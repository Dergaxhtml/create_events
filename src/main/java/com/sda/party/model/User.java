package com.sda.party.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;
    @Column(name = "USR_login")
    @NotEmpty
    private String login;
    @Column(name = "USR_password")
    @Size(min=8)
    private String password;
    @Column(name = "USR_email")
    @Email
    private String email;

}
