package com.ironhack.lab108;

public class TvSeries extends Video {
    private byte season;

    public TvSeries(String name, String yearPublication, String[] actors, String company) {
        super(name, yearPublication, actors, company);
        this.season = 1;
    }

    public byte getSeason() {
        return season;
    }

    public void setSeason(byte season) {
        this.season = season;
    }

    void goAhead() {
        System.out.println("Go ahead in TvSeries " + this.getName());
    }

    void goBack() {
        System.out.println("Go back in TvSeries " + this.getName());
    }

    void pause() {
        System.out.println("Pause reproduction in TvSeries " + this.getName());
    }

    void play() {
        System.out.println("Play in TvSeries " + this.getName());
    }
}
