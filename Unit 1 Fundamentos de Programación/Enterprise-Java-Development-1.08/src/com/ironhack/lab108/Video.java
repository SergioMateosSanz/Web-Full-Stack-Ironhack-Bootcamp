package com.ironhack.lab108;

/**
 * Suppose you are building a video streaming service. All Videos are either tv series or movies.
 * Create classes TvSeries and Movie which extend an Abstract class Video. Add a few methods and
 * properties to each
 */
public abstract class Video {
    String name;
    String yearPublication;
    String[] actors;
    String company;

    public Video(String name, String yearPublication, String[] actors, String company) {
        this.name = name;
        this.yearPublication = yearPublication;
        this.actors = actors;
        this.company = company;
    }

    abstract void goAhead();

    abstract void goBack();

    abstract void pause();

    abstract void play();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
