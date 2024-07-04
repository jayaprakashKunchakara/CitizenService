package com.example.microservices.EurekaServer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.EurekaServer.Entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer>{

	public List<Citizen> findByVaccinationCenterId(int vaccinationcenterId);
}
