package com.apirest2.backends2Car.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest2.backends2Car.models.Carro; 

public interface CarroRepository extends JpaRepository<Carro, Long>{  
    List<Carro> findByCodigo(String codigo);
}