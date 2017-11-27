package br.com.treinamento.ejb;

import br.com.lab.treinamento.local.LancamentoLocal;
import br.com.lab.treinamento.model.Lancamento;
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
    public Lancamento load() throws Exception {
        try {
            return lancamentoDao.getLoadData();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void register(Lancamento lancamento) throws Exception {
        try {
            if (lancamento != null) {
                lancamentoDao.registerObject(lancamento);
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
