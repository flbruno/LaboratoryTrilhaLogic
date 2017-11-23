package br.com.treinamento.ejb;

import br.com.lab.treinamento.local.LancamentoLocal;
import br.com.lab.treinamento.remote.LancamentoRemote;
import br.com.treinamento.repository.LancamentoRepository;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author furlan
 */
@Stateless
public class LancamentoBean implements LancamentoRemote, LancamentoLocal {

    @Inject
    private LancamentoRepository lancamentoDao;

    @Override
    public String teste() throws Exception {
        try {
            return lancamentoDao.getObjecst();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void register(String nome) throws Exception {
        try {
            if (!nome.isEmpty()) {
                lancamentoDao.registerObject(nome);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String doGet() throws Exception {
        try {

            return lancamentoDao.doGets();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
