package br.com.marcio.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAUtil {

	@Produces
	public EntityManager getManager(){
		return Persistence.createEntityManagerFactory("cdi").createEntityManager();
	}
	
	public void close(@Disposes EntityManager em){
		em.close();
	}
}
