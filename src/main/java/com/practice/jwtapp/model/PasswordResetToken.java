package com.practice.jwtapp.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

public class PasswordResetToken {
    @Value("${jwt.password-expiration}")
    private int passwordTokenExpiration;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date expiryDate;

    public int getPasswordTokenExpiration() {
        return passwordTokenExpiration;
    }

    public void setPasswordTokenExpiration(int passwordTokenExpiration) {
        this.passwordTokenExpiration = passwordTokenExpiration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
