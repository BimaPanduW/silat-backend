package com.bima.silat.persistence.mapper;

import com.bima.silat.persistence.domain.Event;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements ResultSetMapper<Event> {
    @Override
    public Event map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Event(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getLong("user_id"),
                resultSet.getTimestamp("date_created"),
                resultSet.getTimestamp("date_updated"),
                resultSet.getBoolean("is_active")
        );
    }
}
