package fr.gtm.contacts.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Civilite;
import fr.gtm.contacts.entities.Contact;

@Singleton
public class ContactDAO extends AbstractDAO<Contact, Long>{
	@PersistenceContext(name="contact") private EntityManager em;
	
	public ContactDAO() {
		super(Contact.class);
	}
	
	public List<Contact> getContactsWithAddresses(){
		List<Contact> contacts = em.createNamedQuery("Contact.getWithAddress", Contact.class)
										.getResultList();
		return contacts;
	}
	
	public List<Contact> getContactsByCivilite(Civilite civilite){
		String sql = "SELECT c FROM Contact c WHERE c.civilite= :foo";
		List<Contact> contacts = em.createQuery(sql, Contact.class)
										.setParameter("foo", civilite)
										.getResultList();
		return contacts;
	}
	
	public List<Contact> getContactsByNom(String nom){
		List<Contact> contacts = em.createNamedQuery("Contact.getByNom", Contact.class)
										.setParameter("nom", nom+"%")
										.getResultList();
		return contacts;
	}

	public List<Contact> getAllContact() {
		List<Contact> contacts = em.createNamedQuery("Contact.getAll", Contact.class)
										.getResultList();
		return contacts;
	}

	public List<Adresse> getAdrressesByContactId(long id) {
		Contact contact = em.find(Contact.class, id);
		List<Adresse> adresses = contact.getAdresses()
											.stream()
											.collect(Collectors.toList());
		return adresses;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
