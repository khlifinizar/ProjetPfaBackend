package tn.essat.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	private String nom ;
	  @JsonIgnore
		@OneToMany(cascade = CascadeType.ALL,mappedBy = "cat")
		private List <Event> liste;
	
	
	public List<Event> getListe() {
		return liste;
	}

	public void setListe(List<Event> liste) {
		this.liste = liste;
	}

	public Categorie(Integer id, String nom, List<Event> liste) {
		super();
		this.id = id;
		this.nom = nom;
		this.liste = liste;
	}

	public Categorie() {
		super();
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

	
}

