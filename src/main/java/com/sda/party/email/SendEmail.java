package com.sda.party.email;


import com.sda.party.model.Event;
import com.sda.party.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {

    private Session session;

    private String from = "kanapka202006@wp.pl";


    public void init() {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.wp.pl");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, "Kanapka1234!");
                    }
                });
    }

    public void sendEmail(User user,Event newEvent) {
        init();
        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("New Event has been created");

            message.setText("New event "
            +newEvent.getName()+" in "
            +newEvent.getCity()+" on "
            +newEvent.getAddress()+ " on date "
            +newEvent.getEventDate()+" by "
            +user.getLogin()+"!");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void sendEmail(List<User> users,Event newEvent) throws MessagingException {
        for (User user : users) {
            sendEmail(user, newEvent);
        }
    }
}


