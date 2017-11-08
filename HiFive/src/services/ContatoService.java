package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import persistence.ContatoDao;

import com.google.gson.Gson;

import entity.ContatoEntity;

@Path("/serv/contatos")
public class ContatoService {
	
	private static final String api_version = "1.1";
	
	@GET
	@Produces("application/json")
	public String leContatos () throws Exception {
		
		List<ContatoEntity> lista;
		
		lista = new ArrayList<ContatoEntity>();
		ContatoDao cd = new ContatoDao();
		lista = cd.getLista();
		
		System.out.println("resultado:"+ new Gson().toJson(lista));

		return new Gson().toJson(lista);
	}
	

	@Path("/adicionarContato/{nome}/{telefone}/{operadora}")
	@POST
	@Produces(MediaType.TEXT_HTML)
	public void gravarContato(@PathParam("nome") String nome, @PathParam("telefone") String telefone, @PathParam("operadora") int operadora) throws Exception {
		ContatoDao cd = new ContatoDao();
		boolean ok = cd.adicionarContato(nome, telefone,operadora);
		if (ok)
			leContatos();
}

	@Path("/alterarContato/{id}/{nome}/{telefone}/{operadora}")
	@POST
	@Produces(MediaType.TEXT_HTML)
	public void alterarContato(@PathParam("id") int id, @PathParam("nome") String nome, @PathParam("telefone") String telefone, @PathParam("operadora") int operadora) throws Exception {
		ContatoDao cd = new ContatoDao();
		boolean ok = cd.alterarContato(id, nome, telefone,operadora);
		if (ok)
			leContatos();
}

	@Path("/apagarContato/{id}")
	@POST
	@Produces(MediaType.TEXT_HTML)
	public void apagarContato(@PathParam("id") Integer id) throws Exception {

		ContatoDao cd = new ContatoDao();
		boolean ok = cd.apagarContato(id);
		
		if (ok)
			leContatos();
	}



}
