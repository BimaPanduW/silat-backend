package com.bima.silat.persistence.domain;

import java.sql.Timestamp;

public class Match {
    private long id;
    private long matchNumber;
    private String redContingent;
    private String redPlayer;
    private String blueContingent;
    private String bluePlayer;
    private long eventId;
    private int status;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;
    private boolean isActive;

    public Match(long id, long matchNumber, String redContingent, String redPlayer, String blueContingent, String bluePlayer, long eventId, int status, Timestamp dateCreated, Timestamp dateUpdated, boolean isActive) {

        this.id = id;
        this.matchNumber = matchNumber;
        this.redContingent = redContingent;
        this.redPlayer = redPlayer;
        this.blueContingent = blueContingent;
        this.bluePlayer = bluePlayer;
        this.eventId = eventId;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isActive = isActive;
    }
}
