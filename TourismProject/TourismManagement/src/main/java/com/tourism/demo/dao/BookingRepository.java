package com.tourism.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tourism.demo.entity.Booking;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path="booking")

public interface BookingRepository extends JpaRepository<Booking, Long> {

	
}
