package com.bima.silat.persistence.mapper;

import com.bima.silat.persistence.domain.Judge;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JudgeMapper implements ResultSetMapper<Judge> {
    @Override
    public Judge map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Judge(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getLong("event_id"),
                resultSet.getTimestamp("date_created"),
                resultSet.getTimestamp("date_updated"),
                resultSet.getBoolean("is_active")
        );
    }
}
