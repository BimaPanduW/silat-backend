package com.bima.silat.persistence.queries;

import com.bima.silat.persistence.domain.Event;
import com.bima.silat.persistence.domain.User;
import com.bima.silat.persistence.mapper.EventMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(EventMapper.class)
public interface EventQuery {
    String table = "event";

    @SqlUpdate("create table IF NOT EXISTS " + table + " (" +
            "id int primary key AUTO_INCREMENT, " +
            "name VARCHAR(50), " +
            "user_id int, " +
            "phone_number VARCHAR(50), " +
            "date_created DATETIME, " +
            "date_updated DATETIME, " +
            "is_active BIT" +
            ")")
    void createEventTable();

    @SqlUpdate("insert into " + table + " " +
            "(name, user_id, date_created, date_updated, is_active) " +
            "values (:name, :userId, :dateCreated, :dateUpdated, :isActive )")
    void insert(@BindBean Event event);

    @SqlQuery("select * from " + table + " where id = :id")
    User findById(@Bind("id") int id);
}
