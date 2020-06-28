
package com.sda.party.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVT_ID")
    private int id;

    @Column(name = "EVT_date")
    @NotEmpty
    private LocalDateTime eventDate;

    @Column(name = "EVT_address")
    @NotEmpty
    private String address;

    @Column(name = "EVT_access")
    @NotEmpty
    private Access access;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVT_USR_LOGIN", referencedColumnName = "USR_login")
    private User organizator;


}

