package tn.essat.model;
import tn.essat.model.Categorie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Event { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String description;
	private String date_debut;
	private String date_fin;
	private String heure_debut;
	private String heure_fin;
	@ManyToOne @JoinColumn(name="cat_id" ,referencedColumnName="id")
	private Categorie cat;
	private String small;
	private String etat ;
	public Event() {
		super();
	}
	
	public Event(Integer id, String nom, String description, String date_debut, String date_fin, String heure_debut,
			String heure_fin, Categorie cat, String small, String etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
		this.cat = cat;
		this.small = small;
		this.etat = etat;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public String getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(String heure_debut) {
		this.heure_debut = heure_debut;
	}
	public String getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(String heure_fin) {
		this.heure_fin = heure_fin;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public String getSmall() {
		return small;
	}
	public void setSmall(String small) {
		this.small = small;
	}
	
	
	

}
