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
public class CarrController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public List<Carro> obtenerTodosLosCarros() {
        return carroRepository.findAll();
    }

    @GetMapping("/{carroId}")
    public ResponseEntity<Carro> obtenerPorId(@PathVariable Long carroId) {
        Carro carro = carroRepository.findById(carroId).orElse(null);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Carro crearCarro(@RequestBody Carro carro) {
        return carroRepository.save(carro);
    }

    @PutMapping("/{carroId}")
    public ResponseEntity<Carro> actualizarCarroPorId(@PathVariable Long carroId, @RequestBody Carro carro){
        carro.setId(carroId);
        Carro carroActualizado = carroRepository.save(carro);
        return ResponseEntity.ok(carroActualizado);
    }

    @DeleteMapping("/{carroId}")
    public ResponseEntity<Void> eliminarCarroPorId(@PathVariable Long carroId){
        carroRepository.deleteById(carroId);
        return ResponseEntity.noContent().build();
    }
}

