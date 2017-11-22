package com.bima.silat.persistence.queries;

import com.bima.silat.persistence.domain.Score;
import com.bima.silat.persistence.domain.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface ScoreQuery {
    String table = "event";

    @SqlUpdate("create table IF NOT EXISTS " + table + " (" +
            "id int primary key AUTO_INCREMENT, " +
            "score_board_1 MEDIUMTEXT, " +
            "score_board_2 MEDIUMTEXT, " +
            "score_board_3 MEDIUMTEXT, " +
            "score_board_4 MEDIUMTEXT, " +
            "score_board_5 MEDIUMTEXT, " +
            "match_id long, " +
            "date_created DATETIME, " +
            "date_updated DATETIME, " +
            "is_active BIT" +
            ")")
    void createEventTable();

    @SqlUpdate("insert into " + table + " " +
            "(match_id, date_created, date_updated, is_active) " +
            "values (:matchId, :dateCreated, :dateUpdated, :isActive )")
    void insert(@BindBean Score score);

    @SqlQuery("select * from " + table + " where id = :id")
    User findById(@Bind("id") int id);
}
