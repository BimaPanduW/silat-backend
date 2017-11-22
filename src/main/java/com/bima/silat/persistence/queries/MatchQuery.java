package com.bima.silat.persistence.queries;

import com.bima.silat.persistence.domain.Event;
import com.bima.silat.persistence.domain.Match;
import com.bima.silat.persistence.domain.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface MatchQuery {
    String table = "match";

    @SqlUpdate("create table IF NOT EXISTS " + table + " (" +
            "id int primary key AUTO_INCREMENT, " +
            "match_number int, " +
            "red_contingent VARCHAR(100), " +
            "red_player VARCHAR(50), " +
            "blue_contingent VARCHAR(100), " +
            "blue_player VARCHAR(50), " +
            "event_id int, " +
            "status int, " +
            "date_created DATETIME, " +
            "date_updated DATETIME, " +
            "is_active BIT" +
            ")")
    void createEventTable();

    @SqlUpdate("insert into " + table + " " +
            "(match_number, red_contingent, red_player, blue_contingent, " +
            "blue_player, event_id, status, date_created, date_updated, is_active) " +
            "values (matchNumber, redContingent, redPlayer, blueContingent, " +
            "bluePlayer, eventId, status, :dateCreated, :dateUpdated, :isActive )")
    void insert(@BindBean Match match);

    @SqlQuery("select * from " + table + " where id = :id")
    User findById(@Bind("id") int id);
}
