package com.bima.silat.persistence.queries;

import com.bima.silat.persistence.domain.Event;
import com.bima.silat.persistence.domain.User;
import com.bima.silat.persistence.mapper.JudgeMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(JudgeMapper.class)
public interface JudgeQuery {
    String table = "judge";

    @SqlUpdate("create table IF NOT EXISTS " + table + " (" +
            "id int primary key AUTO_INCREMENT, " +
            "name VARCHAR(50), " +
            "event_id int, " +
            "date_created DATETIME, " +
            "date_updated DATETIME, " +
            "is_active BIT" +
            ")")
    void createEventTable();

    @SqlUpdate("insert into " + table + " " +
            "(name, event_id, date_created, date_updated, is_active) " +
            "values (:name, :eventId, :dateCreated, :dateUpdated, :isActive )")
    void insert(@BindBean Event event);

    @SqlQuery("select * from " + table + " where id = :id")
    User findById(@Bind("id") int id);
}
