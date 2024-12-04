package com.amal.vetements.service;

import java.io.IOException;
import java.util.List;

import com.amal.vetements.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	Image uplaodImageVet(MultipartFile file, Long idVet) throws IOException;
	List<Image> getImagesParVet(Long vetId);

	Image getImageDetails(Long id) throws IOException;

	ResponseEntity<byte[]> getImage(Long id) throws IOException;

	void deleteImage(Long id);
}
