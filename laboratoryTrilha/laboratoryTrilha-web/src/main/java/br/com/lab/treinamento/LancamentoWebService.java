package br.com.lab.treinamento;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author furlan
 */
@Path("Lancamento")
@RequestScoped
public class LancamentoWebService {

    @Context
    private UriInfo context;

    public LancamentoWebService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscar")
    public String getBuscar() {
        return "vai Curinthia";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
