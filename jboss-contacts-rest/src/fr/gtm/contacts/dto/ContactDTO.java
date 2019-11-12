package fr.gtm.contacts.dto;
import fr.gtm.contacts.entities.Civilite;
import fr.gtm.contacts.entities.Contact;

public class ContactDTO {
	private long id;
	private Civilite civilite;
	private String nom;
	private String prenom;
	private String image;
	
	public ContactDTO(Contact contact) {
		this.id = contact.getId();
		this.civilite = contact.getCivilite();
		this.nom = contact.getNom();
		this.prenom = contact.getPrenom();
		this.image = contact.getImage();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
