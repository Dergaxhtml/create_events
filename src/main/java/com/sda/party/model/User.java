package com.sda.party.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
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

    @OneToMany(mappedBy = "user")
    private List<Participation> participant;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    private String passwordConfirm;

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Participation> getParticipant() {
        return participant;
    }

    public void setParticipant(List<Participation> participant) {
        this.participant = participant;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
