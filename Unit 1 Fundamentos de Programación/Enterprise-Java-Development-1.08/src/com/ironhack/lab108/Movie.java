package com.ironhack.lab108;

public class Movie extends Video{
    private String director;
    private String[] oscarPrizes;

    public Movie(String name, String yearPublication, String[] actors, String company, String director, String[] oscarPrizes) {
        super(name, yearPublication, actors, company);
        this.director = director;
        this.oscarPrizes = oscarPrizes;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getOscarPrizes() {
        return oscarPrizes;
    }

    public void setOscarPrizes(String[] oscarPrizes) {
        this.oscarPrizes = oscarPrizes;
    }

    void goAhead() {
        System.out.println("Go ahead in Movie " + this.getName());
    }

    void goBack() {
        System.out.println("Go back in Movie " + this.getName());
    }

    void pause() {
        System.out.println("Pause reproduction in Movie " + this.getName());
    }

    void play() {
        System.out.println("Play in Movie " + this.getName());
    }
}
