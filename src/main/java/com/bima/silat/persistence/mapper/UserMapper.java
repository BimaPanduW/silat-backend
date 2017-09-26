package com.bima.silat.persistence.mapper;

import com.bima.silat.persistence.domain.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User>{
    @Override
    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("password"),
                resultSet.getString("role"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getTimestamp("date_created"),
                resultSet.getTimestamp("date_updated"),
                resultSet.getBoolean("is_active")
                );
    }
}
