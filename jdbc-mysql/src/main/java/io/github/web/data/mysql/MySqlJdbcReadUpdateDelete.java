package io.github.web.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlJdbcReadUpdateDelete {

    public static void main(String[] args) throws Exception {
        // Connection to MySql
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test", "root", "");

        // Read row
        String selectSql = "SELECT ID_USER FROM USER WHERE USERNAME='johndoe'";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        rs.last();
        int id = rs.getInt("ID_USER");
        rs.close();
        statement.close();

        // Update row
        String updateSql = "UPDATE USER SET AGE=35 WHERE ID_USER=" + id;
        statement = connection.createStatement();
        statement.execute(updateSql);
        statement.close();

        // Delete row
        String deleteSql = "DELETE FROM USER WHERE ID_USER=" + id;
        statement = connection.createStatement();
        statement.execute(deleteSql);
        statement.close();

        // Close connection
        connection.close();
    }

}
