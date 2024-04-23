package com.apirest2.backends2Car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest2.backends2Car.models.Carro;

public interface CarrosRepository extends JpaRepository<Carro, Long> {
    
}
