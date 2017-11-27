package br.com.treinamento.repository;

import br.com.lab.treinamento.dao.ManagerConnection;
import br.com.lab.treinamento.model.Lancamento;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author furlan
 */
@Stateless
public class LancamentoRepository implements Serializable {

    @Inject
    private ManagerConnection connection;

    /**
     * Metodo salva os dados de lancamento
     *
     * @param lancamento
     * @throws Exception
     */
    public void registerObject(Lancamento lancamento) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        StringBuilder sqlQuery;

        try {
            conn = connection.getConnection();

            sqlQuery = new StringBuilder("INSERT INTO lancamento(nome, datalancamento, valor, tipolancamento)").
                    append(" VALUES (?,?,?,?)");
            ps = conn.prepareStatement(sqlQuery.toString());

            ps.setString(1, lancamento.getNome());
            ps.setString(2, lancamento.getData());
            ps.setDouble(3, lancamento.getValor());
            ps.setInt(4, lancamento.getTipoLancamento());
            ps.executeQuery();

        } catch (Exception e) {
            throw e;

        } finally {
            connection.removeConnection(conn, ps, null);
        }
    }

    /**
     * Metodo para obeter os valores do lancamento
     *
     * @return Object
     * @throws Exception
     */
    public Lancamento getLoadData() throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        StringBuilder sqlQuery;
        ResultSet rs = null;
        Lancamento lancamento = null;

        try {
            conn = connection.getConnection();

            sqlQuery = new StringBuilder("SELECT * FROM lancamento");
            ps = conn.prepareStatement(sqlQuery.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                lancamento = new Lancamento();
                lancamento.setNome(rs.getString("nome"));
                lancamento.setData(rs.getString("datalancamento"));
                lancamento.setValor(rs.getDouble("valor"));
                lancamento.setTipoLancamento(rs.getInt("tipolancamento"));
            }

            return lancamento;

        } catch (Exception ex) {
            throw ex;

        } finally {
            connection.removeConnection(conn, ps, rs);
        }
    }

    public String doGets() throws Exception {
        return "Passei Aqui....";
    }
}
