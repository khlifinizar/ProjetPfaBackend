package tn.essat.service;

import java.util.List;
import java.util.Optional;

import tn.essat.model.Categorie;


public interface ICategorieservice {
	public List<Categorie> getall();
	public void remove( int id );
	  public void save( Categorie c);
	  public  Optional<Categorie> getCategorieByid(int id);
	  public  Categorie updateCategorie(Categorie e);


}
