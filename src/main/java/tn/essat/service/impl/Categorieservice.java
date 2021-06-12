package tn.essat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.essat.model.Categorie;
import tn.essat.model.Event;
import tn.essat.repo.ICategorie;
import tn.essat.service.ICategorieservice;
@Service
public class Categorieservice implements ICategorieservice {
@Autowired
ICategorie cat;

	public Categorieservice(ICategorie cat) {
	
	this.cat = cat;
}

	@Override
	public List<Categorie> getall() {
		// TODO Auto-generated method stub
		return (List<Categorie>) cat.findAll();
	}

	@Override
	public void remove(int id) {
		cat.deleteById(id);
		
	}

	@Override
	public void save(Categorie c) {
cat.save(c);		
	}

	@Override
	public Optional<Categorie> getCategorieByid(int id) {
		// TODO Auto-generated method stub
		return cat.findById(id);
	}

	@Override
	public Categorie updateCategorie(Categorie e) {
return cat.save(e);
	}

	



}
