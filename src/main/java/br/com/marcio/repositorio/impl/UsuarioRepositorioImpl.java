package br.com.marcio.repositorio.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.marcio.modelo.Usuario;
import br.com.marcio.repositorio.UsuarioRepositorio;

@ApplicationScoped
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

	@Inject
	private EntityManager em;
	
	@Override
	public void gravar(Usuario usuario) {
		try{
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
