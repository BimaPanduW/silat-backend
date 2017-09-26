package com.bima.silat.managers;

import com.bima.silat.persistence.domain.User;
import com.bima.silat.persistence.queries.UserQuery;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Calendar;


public class DataBaseManager {
    private Logger logger = LoggerFactory.getLogger(DataBaseManager.class);

    public DataBaseManager() {
        MysqlDataSource mysqlDataSource = new MysqlConnectionPoolDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/silat");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");

        DBI dbi = new DBI(mysqlDataSource);

        UserQuery userQuery = dbi.onDemand(UserQuery.class);

        userQuery.createUserTable();

        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

        userQuery.insert(new User(1, "bima", "1234",
                "admin", "bima@email.com", "08887779",
                currentTimestamp, currentTimestamp, true));

        User user = userQuery.findById(1);

        logger.info(user.toString());
    }
}
