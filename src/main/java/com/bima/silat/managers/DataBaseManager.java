package com.bima.silat.managers;

import com.bima.silat.persistence.BaseDAO;
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

        BaseDAO baseDAO = dbi.open(BaseDAO.class);

        baseDAO.createUserTable();

        baseDAO.close();
    }
}
