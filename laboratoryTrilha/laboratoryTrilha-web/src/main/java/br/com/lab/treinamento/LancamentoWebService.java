package br.com.lab.treinamento;

import br.com.lab.treinamento.local.LancamentoLocal;
import br.com.lab.treinamento.model.Lancamento;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author furlan
 */
@Singleton
@Path("Lancamento")
public class LancamentoWebService {

    @Context
    private UriInfo context;
    @EJB
    private LancamentoLocal lancamentoService;

    public LancamentoWebService() {
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obterDados")
    public Response getLoadData() throws Exception {
        try {
            return Response.ok(lancamentoService.load()).build();
        } catch (Exception ex) {
            throw new Exception("ERRO", ex);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("register")
    public Response registerData(Lancamento lancamento) throws Exception {
        try {
           lancamentoService.register(lancamento);
           
           return Response.ok("SUcesso").build();
        } catch (Exception ex) {
            throw new Exception("ERRO", ex);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("doGet")
    public Response doGet() throws Exception {
        try {
            return Response.ok(lancamentoService.doGet()).build();
        } catch (Exception ex) {
            throw new Exception("ERRO", ex);
        }
    }
}
