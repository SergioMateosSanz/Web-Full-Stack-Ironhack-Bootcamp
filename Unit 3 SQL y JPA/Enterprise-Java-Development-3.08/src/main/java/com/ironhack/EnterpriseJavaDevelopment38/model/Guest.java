package com.ironhack.EnterpriseJavaDevelopment38.model;

import com.ironhack.EnterpriseJavaDevelopment38.enums.StatusGuest;

import javax.persistence.*;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private StatusGuest statusGuest;

    @ManyToMany
    @JoinTable(name = "event_guests",
            joinColumns = {@JoinColumn(name = "guest_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private List<Event> eventList;

    public Guest() {
    }

    public Guest(String name, StatusGuest statusGuest) {
        this.name = name;
        this.statusGuest = statusGuest;
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

    public StatusGuest getStatusGuest() {
        return statusGuest;
    }

    public void setStatusGuest(StatusGuest statusGuest) {
        this.statusGuest = statusGuest;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
