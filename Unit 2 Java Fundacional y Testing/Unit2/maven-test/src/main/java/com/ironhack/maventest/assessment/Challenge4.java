package com.ironhack.maventest.assessment;

/*
Enums Challenge
This challenge tests your understanding of enums.

Requirements
You have the following class in your project in the forms outlined below:

enum SubscriptionType {
    GOLD,
    SILVER,
    FREE
}
public class Player {
    private String name;
    private String email;
    private int points;
    private SubscriptionType subscriptionType;

    // constructor, getters and setters omitted for brevity
}
This class is part of a videogame you are developing. In this game we will have a christmas
event where every player will be rewarded with points depending of his subscription.

Gold players will have the reward x3
Silver players will have the reward x2
Free players will have the stantard reward
Banned players can't receive rewards

Create a new subscription type called BANNED and create a method inside the Player class called
applyReward that gets an int reward as parameter and sum the rewards to the player points depending on the type of subscription the player has.
 */
enum SubscriptionType {
    GOLD,
    SILVER,
    FREE,
    BANNED
}

public class Challenge4 {
    private String name;
    private String email;
    private int points;
    private SubscriptionType subscriptionType;

    public void applyReward(int reward) {
        if (reward >= 0) {
            switch (this.subscriptionType) {
                case GOLD:
                    this.points = this.points + (reward * 3);
                    break;
                case SILVER:
                    this.points = this.points + (reward * 2);
                    break;
                case FREE:
                    this.points = this.points + reward;
                    break;
                case BANNED:
                    break;
                default:
                    break;
            }
        }

    }

    public Challenge4(String name, String email, int points, SubscriptionType subscriptionType) {
        this.name = name;
        this.email = email;
        this.points = points;
        this.subscriptionType = subscriptionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
