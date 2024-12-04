package com.amal.vetements.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.amal.vetements.entities.Boutique;
import com.amal.vetements.entities.Vetement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amal.vetements.repos.ImageRepository;
import com.amal.vetements.repos.VetementRepository;

@Service
public class VetementServiceImpl implements VetementService {
	@Autowired
	VetementRepository vetementRepository;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public Vetement saveVetement(Vetement v) {

		return vetementRepository.save(v);
	}

	@Override
	public Vetement updateVetement(Vetement v) {
		// Long oldProdImageId =
		// this.getProduit(p.getIdProduit()).getImage().getIdImage();
		// Long newProdImageId = p.getImage().getIdImage();
		Vetement vetUpdated = vetementRepository.save(v);

		// if (oldProdImageId != newProdImageId) // si l'image a été modifiée
		// imageRepository.deleteById(oldProdImageId);
		return vetUpdated;
	}

	@Override
	public void deleteVetement(Vetement v) {
		vetementRepository.delete(v);
	}

	@Override
	public void deleteVetementById(Long id) {
		Vetement v = getVetement(id);
		if (v != null) {
			// Delete images associated with the vetement
			v.getImages().forEach(image -> {
				try {
					Files.delete(Paths.get(System.getProperty("user.home") + "/images/" + v.getImagePath()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			vetementRepository.delete(v);
			}

	}

	@Override
	public Vetement getVetement(Long id) {
		return vetementRepository.findById(id).get();
	}

	@Override
	public List<Vetement> getAllVetements() {

		return vetementRepository.findAll();
	}

	@Override
	public Page<Vetement> getAllVetementsParPage(int page, int size) {
		return vetementRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Vetement> findByMarqueVetement(String marque) {
		// TODO Auto-generated method stub
		return vetementRepository.findByMarqueVet(marque);
	}

	@Override
	public List<Vetement> findByMarqueVetementContains(String marque) {
		// TODO Auto-generated method stub
		return vetementRepository.findByMarqueVetContains(marque);
	}

	@Override
	public List<Vetement> findByMarquePrix(String marque, Double prix) {
		// TODO Auto-generated method stub
		return vetementRepository.findByMarquePrix(marque, prix);
	}

	@Override
	public List<Vetement> findByBoutique(Boutique boutique) {
		// TODO Auto-generated method stub
		return vetementRepository.findByBoutique(boutique);
	}

	@Override
	public List<Vetement> findByBoutiqueIdBou(Long id) {
		// TODO Auto-generated method stub
		return vetementRepository.findByBoutiqueIdBou(id);
	}

	@Override
	public List<Vetement> findByOrderByMarqueVetementAsc() {
		// TODO Auto-generated method stub
		return vetementRepository.findByOrderByMarqueVetAsc();
	}

	@Override
	public List<Vetement> trierVetementsMarquesPrix() {
		// TODO Auto-generated method stub
		return vetementRepository.trierVetementMarquePrix();
	}

}
