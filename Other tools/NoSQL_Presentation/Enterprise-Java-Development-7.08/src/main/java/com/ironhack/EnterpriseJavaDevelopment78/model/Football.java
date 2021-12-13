package com.ironhack.EnterpriseJavaDevelopment78.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "football")
public class Football {

    @Id
    private String id;
    private String team;
    private String foundationYear;
    private Integer position;

    public Football() {
    }

    public Football(String team, String foundationYear, Integer position) {
        this.team = team;
        this.foundationYear = foundationYear;
        this.position = position;
    }


    public String getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Football{" +
                "id='" + id + '\'' +
                ", team='" + team + '\'' +
                ", foundationYear='" + foundationYear + '\'' +
                ", position=" + position +
                '}';
    }
}
