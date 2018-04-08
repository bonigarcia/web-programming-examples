package io.github.web.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySqlJdbcInsert {

    public static void main(String[] args) throws Exception {
        // Connection to MySql
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test", "root", "");

        // Insert row
        java.util.Date now = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        String insertSql = "INSERT INTO USER (USERNAME, AGE, CREATED_DATE) "
                + "VALUES ('johndoe', 30, '" + sqlDate + "')";
        Statement statement = connection.createStatement();
        statement.execute(insertSql);
        statement.close();

        // Close connection
        connection.close();
    }

}
