package com.amal.vetements.repos;

 
import com.amal.vetements.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
