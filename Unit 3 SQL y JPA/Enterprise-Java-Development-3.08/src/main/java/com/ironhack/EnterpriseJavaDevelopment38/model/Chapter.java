package com.ironhack.EnterpriseJavaDevelopment38.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapterId;
    private String name;
    private String district;

    @OneToOne
    @JoinColumn(name = "president")
    private Member president;

    @OneToMany(mappedBy = "chapter")
    private List<Member> memberList;

    public Chapter() {
    }

    public Chapter(String name, String district) {
        this.name = name;
        this.district = district;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        this.president = president;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}
