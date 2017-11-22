package com.bima.silat.persistence.domain;

import java.sql.Timestamp;

public class Judge {
    private long id;
    private String name;
    private long eventId;
    private String phoneNumber;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;
    private boolean isActive;

    public Judge(long id, String name, long eventId, Timestamp dateCreated, Timestamp dateUpdated, boolean isActive) {
        this.id = id;
        this.name = name;
        this.eventId = eventId;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isActive = isActive;
    }
}
