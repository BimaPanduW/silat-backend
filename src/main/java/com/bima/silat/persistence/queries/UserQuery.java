package com.bima.silat.persistence.queries;

import com.bima.silat.persistence.domain.User;
import com.bima.silat.persistence.mapper.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UserMapper.class)
public interface UserQuery {
    String table = "users";

    @SqlUpdate("create table IF NOT EXISTS "+table+" (" +
            "id int primary key AUTO_INCREMENT, " +
            "name VARCHAR(50), " +
            "password VARCHAR(10), " +
            "role VARCHAR(10), " +
            "email varchar(50), " +
            "phone_number VARCHAR(50), " +
            "date_created DATETIME, " +
            "date_updated DATETIME, " +
            "is_active BIT" +
            ")")
    void createUserTable();

    @SqlUpdate("insert into "+table+" " +
            "(name, password, role, email, phone_number, date_created, date_updated, is_active) " +
            "values (:name, :password, :role, :email, :phoneNumber, :dateCreated, :dateUpdated, :isActive )")
    void insert(@BindBean User user);

    @SqlQuery("select * from "+table+" where id = :id")
    User findById(@Bind("id") int id);
}
