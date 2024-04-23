package com.apirest2.backends2Car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest2.backends2Car.models.Carro;

public interface CarrRepository extends JpaRepository<Carro, Long>{

}

