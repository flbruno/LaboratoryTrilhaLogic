package br.com.lab.treinamento.local;

import br.com.lab.treinamento.model.Lancamento;
import br.com.lab.treinamento.remote.LancamentoRemote;
import javax.ejb.Local;

/**
 *
 * @author furlan
 */
@Local
public interface LancamentoLocal extends LancamentoRemote {

    Lancamento load() throws Exception;

    void register(Lancamento lancamento) throws Exception;

    String doGet() throws Exception ;
}
