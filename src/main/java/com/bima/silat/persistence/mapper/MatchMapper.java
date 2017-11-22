package com.bima.silat.persistence.mapper;

import com.bima.silat.persistence.domain.Match;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchMapper implements ResultSetMapper<Match> {

    @Override
    public Match map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Match(
                resultSet.getLong("id"),
                resultSet.getLong("match_number"),
                resultSet.getString("red_contingent"),
                resultSet.getString("red_player"),
                resultSet.getString("blue_contingent"),
                resultSet.getString("blue_player"),
                resultSet.getLong("event_id"),
                resultSet.getInt("status"),
                resultSet.getTimestamp("date_created"),
                resultSet.getTimestamp("date_updated"),
                resultSet.getBoolean("is_active")
        );
    }
}
