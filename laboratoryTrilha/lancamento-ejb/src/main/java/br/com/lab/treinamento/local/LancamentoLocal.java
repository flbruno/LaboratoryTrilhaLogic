package br.com.lab.treinamento.local;

import br.com.lab.treinamento.remote.LancamentoRemote;
import javax.ejb.Local;

/**
 *
 * @author furlan
 */
@Local
public interface LancamentoLocal extends LancamentoRemote {
    
}
