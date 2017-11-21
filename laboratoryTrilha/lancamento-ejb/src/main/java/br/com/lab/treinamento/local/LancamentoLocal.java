package br.com.lab.treinamento.local;

import br.com.lab.treinamento.remote.LancamentoRemote;
import javax.ejb.Local;

/**
 *
 * @author furlan
 */
@Local
public interface LancamentoLocal extends LancamentoRemote {

    String teste() throws Exception;

    void register(String nome) throws Exception;

    String doGet() throws Exception ;
}
