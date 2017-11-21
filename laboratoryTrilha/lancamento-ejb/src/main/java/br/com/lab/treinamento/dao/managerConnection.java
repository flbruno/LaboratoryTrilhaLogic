package br.com.lab.treinamento.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author furlan
 */
public class managerConnection implements Serializable {

    private static final String URLDB = "jdbc:hsqldb:hsql:file:db/trilhadb";
    private static final String DRIVERDB = " org.hsqldb.jdbc.JDBCConnection";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVERDB);

            return DriverManager.getConnection("jdbc:hsqldb:hsql:file:db/trilhadb", "sa", "");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            }
        return null;
    }

    protected void removeConnection(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (conn != null) {
            conn.close();
        }
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
    }
}
