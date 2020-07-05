package com.sda.party.email;

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
//    private Session session;
//
//    private void init() {
//        String from = "kanapka202006@wp.pl";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.wp.pl");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication("kanapka202006@wp.pl", "Kanapka1234!");
//                    }
//                });
//    }
//
//    public void sendEmail(User user) throws MessagingException {
//        init();
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("kanapka202006@wp.pl"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(user.getEmail()));
//            message.setSubject(user.getLogin());
//            message.setText(user.getLogin());
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
//
//    public void sendEmail(List<User> users) throws MessagingException {
//        for (User user : users) {
//            sendEmail(user);
//        }
//    }
//
//
//}
private Session session;
    // Recipient's email ID needs to be mentioned.
    String to = "dergax.s3@gmail.com";
    // Sender's email ID needs to be mentioned
    String from = "kanapka202006@wp.pl";
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
                        return new PasswordAuthentication("kanapka202006@wp.pl", "Kanapka1234!");
                    }
                });}
        public void sendEmail(User user){
            init();
            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);
                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));
                // Set To: header field of the header.
//                message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(user.getEmail()));
                // Set Subject: header field
                message.setSubject("This is the Subject Line!");
                // Now set the actual message
                message.setText("This is actual message");
                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }

    public void sendEmail(List<User> users) throws MessagingException{
        for (User user : users) {
            sendEmail(user);
        }
    }
    }


