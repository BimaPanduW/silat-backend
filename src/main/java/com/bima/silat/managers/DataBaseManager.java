package com.bima.silat.managers;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;


public class DataBaseManager {

    public DataBaseManager() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/silat");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");

        DBI dbi = new DBI(mysqlDataSource);

        Handle handle = dbi.open();
        handle.execute("create table users (" +
                "id int primary key, " +
                "name VARCHAR(50), " +
                "password VARCHAR(10), " +
                "role VARCHAR(10), " +
                "email varchar(50), " +
                "phone_number VARCHAR(50), " +
                "date_created DATETIME, " +
                "date_updated DATETIME, " +
                "is_active BIT" +
                ")");

        handle.close();
    }
}
