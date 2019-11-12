package fr.gtm.contacts.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import fr.gtm.contacts.entities.Adresse;


public class AdresseDAO extends AbstractDAO<Adresse, Long>{
	@PersistenceContext(name="contact") private EntityManager em;
	
	public AdresseDAO() {
		super(Adresse.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

}
