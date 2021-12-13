package com.ironhack.EnterpriseJavaDevelopment38.model;

import com.ironhack.EnterpriseJavaDevelopment38.enums.StatusMember;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private StatusMember statusMember;
    private Date renewalDate;

    @OneToOne(mappedBy = "president")
    private Chapter president;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter")
    private Chapter chapter;

    public Member() {
    }

    public Member(String name, StatusMember statusMember, Date renewalDate) {
        this.name = name;
        this.statusMember = statusMember;
        this.renewalDate = renewalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusMember getStatusMember() {
        return statusMember;
    }

    public void setStatusMember(StatusMember statusMember) {
        this.statusMember = statusMember;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Chapter getPresident() {
        return president;
    }

    public void setPresident(Chapter president) {
        this.president = president;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
