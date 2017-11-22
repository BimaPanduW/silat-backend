package com.bima.silat.persistence.domain;

import java.sql.Timestamp;

public class Event {
    private long id;
    private String name;
    private long userId;
    private String phoneNumber;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;
    private boolean isActive;

    public Event(long id, String name, long userId, Timestamp dateCreated, Timestamp dateUpdated, boolean isActive) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isActive = isActive;
    }
}
