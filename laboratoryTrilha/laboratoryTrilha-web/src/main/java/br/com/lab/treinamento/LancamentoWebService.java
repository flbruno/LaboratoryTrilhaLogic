package br.com.lab.treinamento;

import br.com.lab.treinamento.local.LancamentoLocal;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscar")
    public Response getBuscar() throws Exception {
        try {
            return Response.ok(lancamentoService.teste()).build();
        } catch (Exception ex) {
            throw new Exception("asdasdasdasdas ERRO", ex);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("register/{nome}")
    public Response putJson(@PathParam(value = "nome") String nome) throws Exception {
        try {
            lancamentoService.register(nome);

            return Response.ok().build();
        } catch (Exception ex) {
            throw new Exception("asdasdasdasdas ERRO", ex);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("doGet")
    public Response doGet() throws Exception {
        try {
            return Response.ok(lancamentoService.doGet()).build();
        } catch (Exception ex) {
            throw new Exception("asdasdasdasdas ERRO", ex);
        }
    }
}
