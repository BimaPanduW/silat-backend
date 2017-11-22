package com.bima.silat.persistence.domain;

import java.sql.Timestamp;

public class Score {

    private long id;
    private String scoreBoard1;
    private String scoreBoard2;
    private String scoreBoard3;
    private String scoreBoard4;
    private String scoreBoard5;
    private long matchId;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;
    private boolean isActive;

    public Score(long id, long matchId, String scoreBoard1, String scoreBoard2, String scoreBoard3,
                 String scoreBoard4, String scoreBoard5, Timestamp dateCreated, Timestamp dateUpdated, boolean isActive) {
        this.id = id;
        this.matchId = matchId;
        this.scoreBoard1 = scoreBoard1;
        this.scoreBoard2 = scoreBoard2;
        this.scoreBoard3 = scoreBoard3;
        this.scoreBoard4 = scoreBoard4;
        this.scoreBoard5 = scoreBoard5;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isActive = isActive;
    }
}
