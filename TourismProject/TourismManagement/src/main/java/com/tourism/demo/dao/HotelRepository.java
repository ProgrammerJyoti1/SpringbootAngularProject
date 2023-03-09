package com.tourism.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tourism.demo.entity.Hotel;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path="hotel")
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
