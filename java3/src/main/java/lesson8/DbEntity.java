package lesson8;

import java.sql.*;

public class DbEntity {
    private Connection connection;
    private Statement stmt;
    private  String dbName;

    public DbEntity(String dbName) {
        this.dbName = dbName;
    }

    public void  connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:"+dbName);
        stmt = connection.createStatement();
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getRecIDs(String sqlStr)  throws SQLException{
        ResultSet rs = stmt.executeQuery(sqlStr);
        Integer res;
        if (rs.next())
            res = new Integer(rs.getInt(1));
        else
            res = null;
        return res;
    }
}
