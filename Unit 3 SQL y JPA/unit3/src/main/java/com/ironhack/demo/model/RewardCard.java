package com.ironhack.demo.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "number")
public class RewardCard extends CreditCard {
    private int points;

    public RewardCard(int points) {
        this.points = points;
    }

    public RewardCard(String number, String owner, int balance, int limit, int points) {
        super(number, owner, balance, limit);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}