package br.com.treinamento.ejb;

import br.com.lab.treinamento.local.LancamentoLocal;
import br.com.lab.treinamento.remote.LancamentoRemote;
import br.com.treinamento.repository.LancamentoRepository;
import javax.ejb.Stateless;

/**
 *
 * @author furlan
 */
@Stateless
public class LancamentoBean extends LancamentoRepository implements LancamentoRemote, LancamentoLocal {

    @Override
    public String teste() throws Exception {
        try {
            return getObjecst();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void register(String nome) throws Exception {
        try {
            if (!nome.isEmpty()) {
                registerObject(nome);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String doGet() throws Exception {
        try {

            return doGets();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
