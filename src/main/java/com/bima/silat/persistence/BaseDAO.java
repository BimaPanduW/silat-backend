package com.bima.silat.persistence;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface BaseDAO {

    @SqlUpdate("create table users (" +
            "id int primary key, " +
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

    void close();

}
