package com.ironhack.EnterpriseJavaDevelopment38.model;

import com.ironhack.EnterpriseJavaDevelopment38.enums.EventType;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_event")
    private Date eventDate;
    private Time duration;
    private String location;
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_event")
    private EventType eventType;

    @ManyToMany
    @JoinTable(name = "event_guests",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "guest_id")})
    private List<Guest> guestList;

    @ManyToMany
    @JoinTable(name = "event_speakers",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "speaker_id")})
    private List<Speaker> speakerList;

    public Event() {
    }

    public Event(Date eventDate, Time duration, String location, String title, EventType eventType) {
        this.eventDate = eventDate;
        this.duration = duration;
        this.location = location;
        this.title = title;
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }
}
