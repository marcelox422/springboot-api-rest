package com.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.exception.ModeloNotFoundException;
import com.demo.model.Persona;
import com.demo.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {


  @Autowired
  private IPersonaService service;

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<Persona>> listar() {
    List<Persona> personas = service.listar();
    return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public Optional<Persona> listarId(@PathVariable("id") Integer id) {
    Optional<Persona> per = service.listarId(id);
    if (!per.isPresent()) {
      throw new ModeloNotFoundException("ID: " + id + " no encontrado");
    }
    return per;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<Persona> registrar(@RequestBody Persona persona) {
    Persona personaNew = service.registrar(persona);
    return new ResponseEntity<Persona>(personaNew, HttpStatus.CREATED);
  }

  @PutMapping(consumes = "application/json", produces = "application/json")
  public Persona actualizar(@RequestBody Persona persona) {
    return service.modificar(persona);
  }

  @DeleteMapping(value = "/{id}")
  public void eliminar(@PathVariable("id") Integer id) {
    service.eliminar(id);
  }


}
