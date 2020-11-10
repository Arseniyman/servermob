package com.av.psytest.server.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "password", length = 255)
    private String password;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "sex")
    private Boolean sex;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_register")
    private Date dateOfRegister;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_online")
    private Date lastOnline;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String email) {
        this.email = email;
    }

    public User(Long id, String email, String password, Date dateOfBirth,
                Boolean sex, Date dateOfRegister) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.dateOfRegister = dateOfRegister;
    }

    public User(Long id, String email, String password, Date dateOfBirth, Boolean sex,
                Date dateOfRegister, Date lastOnline) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.dateOfRegister = dateOfRegister;
        this.lastOnline = lastOnline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(Date dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    public Date getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(Date lastOnline) {
        this.lastOnline = lastOnline;
    }
}