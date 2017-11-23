package br.com.lab.treinamento.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.sql.DataSource;

/**
 *
 * @author furlan
 */
@SessionScoped
public class ManagerConnection implements Serializable {

    @Resource(lookup = "java:jboss/datasources/trilhadb")
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        try {
            Connection connection = dataSource.getConnection();
            
            return connection;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeConnection(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
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
