package com.apirest2.backends2Car.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest2.backends2Car.models.Carro;
import com.apirest2.backends2Car.repositories.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    
    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public List<Carro> obtenerTodosLosCarros() {
        return carroRepository.findAll();
    }

    @GetMapping("/{carroId}")
    public ResponseEntity<Carro> obtenerCarroPorId(@PathVariable Long carroId) {
        Carro carro = carroRepository.findById(carroId).orElse(null);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Carro crearCarro(@RequestBody Carro nuevoCarro) {
        return carroRepository.save(nuevoCarro);
    }

    @PutMapping("/{carroId}")
    public Carro actualizarCarro(@PathVariable Long carroId, @RequestBody Carro carro){
        carro.setId(carroId);
        return carroRepository.save(carro);
    }

    @DeleteMapping("/{carroId}")
    public void borrarCarro(@PathVariable Long carroId ){
        carroRepository.deleteById(carroId);
    }
}