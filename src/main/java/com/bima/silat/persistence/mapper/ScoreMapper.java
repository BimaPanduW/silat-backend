package com.bima.silat.persistence.mapper;

import com.bima.silat.persistence.domain.Score;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreMapper implements ResultSetMapper<Score> {
    @Override
    public Score map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Score(resultSet.getLong("id"),
                resultSet.getLong("match_id"),
                resultSet.getString("score_board_1"),
                resultSet.getString("score_board_2"),
                resultSet.getString("score_board_3"),
                resultSet.getString("score_board_4"),
                resultSet.getString("score_board_5"),
                resultSet.getTimestamp("date_created"),
                resultSet.getTimestamp("date_updated"),
                resultSet.getBoolean("is_active"));
    }
}
