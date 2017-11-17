package br.com.lab.treinamento;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author furlan
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.lab.treinamento.GenericResource.class);
        resources.add(br.com.lab.treinamento.LancamentoWebService.class);
    }
}
