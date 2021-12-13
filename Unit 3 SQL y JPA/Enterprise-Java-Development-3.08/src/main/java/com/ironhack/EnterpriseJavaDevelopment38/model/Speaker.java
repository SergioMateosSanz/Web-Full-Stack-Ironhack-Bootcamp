package com.ironhack.EnterpriseJavaDevelopment38.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "presentation_duration")
    private Time duration;

    @ManyToMany
    @JoinTable(name = "event_speakers",
            joinColumns = {@JoinColumn(name = "speaker_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private List<Event> eventList;

    public Speaker() {
    }

    public Speaker(String name, Time duration) {
        this.name = name;
        this.duration = duration;
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

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
