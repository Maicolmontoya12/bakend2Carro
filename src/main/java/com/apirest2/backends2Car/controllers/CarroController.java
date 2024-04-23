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
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public List<Carro> obtenerTodosLosCarros() {
        return carroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarroPorId(@PathVariable Long id) {
        Carro carro = carroRepository.findById(id).orElse(null);
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

    @PutMapping("/{id}")
    public Carro actualizarCarro(@PathVariable Long id, @RequestBody Carro carro){
        carro.setId(id);
        return carroRepository.save(carro);
    }

    @DeleteMapping("/{id}")
    public void borrarCarro(@PathVariable Long id ){
        carroRepository.deleteById(id);
    }
}
