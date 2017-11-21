package br.com.treinamento.repository;

import br.com.lab.treinamento.dao.managerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author furlan
 */
public class LancamentoRepository extends managerConnection {

    /**
     * Metodo salva os dados de lancamento
     * @param nome
     * @throws Exception
     */
    public void registerObject(String nome) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        StringBuilder sqlQuery;

        try {
            conn = getConnection();

            sqlQuery = new StringBuilder("INSERT INTO teste(nome) VALUES (?)");
            ps = conn.prepareStatement(sqlQuery.toString());

            ps.setString(1, nome);
            ps.executeQuery();

        } catch (Exception e) {
            throw e;

        } finally {
            removeConnection(conn, ps, null);
        }
    }
    
    /**
     * Metodo para obeter os valores do lancamento
     * @return Object
     * @throws Exception
     */
    public String getObjecst() throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        StringBuilder sqlQuery;
        ResultSet rs = null;
        String nome = "";

        try {
            conn = getConnection();

            sqlQuery = new StringBuilder("SELECT nome FROM teste"); 
            ps = conn.prepareStatement(sqlQuery.toString());
            rs = ps.executeQuery();

            if (rs.next()) {
               nome = rs.getString(nome);
            }
            
            return nome;

        } catch (Exception e) {
            throw e;

        } finally {
            removeConnection(conn, ps, rs);
        }
    }
}
