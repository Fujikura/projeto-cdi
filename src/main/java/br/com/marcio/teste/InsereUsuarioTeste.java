package br.com.marcio.teste;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import br.com.marcio.modelo.Usuario;
import br.com.marcio.repositorio.UsuarioRepositorio;

public class InsereUsuarioTeste {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Márcio Fujikura");
		usuario.setEmail("marciofujikura@hotmail.com");
		usuario.setSenha("vinicius07");
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		UsuarioRepositorio repositorio = container.instance().select(UsuarioRepositorio.class).get();
		repositorio.gravar(usuario);
		
		System.out.println("Usuário cadastrado");
		
		weld.shutdown();

	}

}
