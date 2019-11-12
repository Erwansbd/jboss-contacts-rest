package fr.gtm.contacts.services.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.gtm.contacts.dao.ContactDAO;
import fr.gtm.contacts.dto.ContactDTO;
import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Contact;

@Path("/contacts")
public class ContactService {
	@EJB private ContactDAO contactDAO;

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> getAllContacts(){
		return contactDAO.getAllContact();
	}

	@DELETE
	@Path("/del/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteContact(@PathParam("id")String id) {
		long identifiant = Long.parseLong(id);
		contactDAO.delete(identifiant);
		return "ok";
		
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Contact contact) {
		contactDAO.create(contact);		
	}
	
	public List<Adresse> getAdrressesByContactId(long id){
		return contactDAO.getAdrressesByContactId(id);
	}
	
	@GET
	@Path("/alldto")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContactDTO> getAllContactDTOs(){
		return getAllContacts().stream()
					.map(c -> new ContactDTO(c))
					.collect(Collectors.toList());
	}

	public ContactDTO findContactDTO(long id) {
		Contact contact = contactDAO.findById(id);
		if(contact!=null)
			return new ContactDTO(contact);
		return null;
	}

	public ContactDTO findContactDTO(String id) {
		return this.findContactDTO(Long.parseLong(id));
	}

	public Contact findContact(String id) {
		return contactDAO.findById(Long.parseLong(id));
	}

	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Contact c) {
		contactDAO.update(c);
		
	}
}
