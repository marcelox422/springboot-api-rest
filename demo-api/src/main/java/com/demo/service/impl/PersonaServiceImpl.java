package com.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.model.Persona;
import com.demo.repo.IPersonaRepo;
import com.demo.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

  @Autowired
  private IPersonaRepo repo;

  @Override
  public Persona registrar(Persona p) {
    return repo.save(p);
  }

  @Override
  public Persona modificar(Persona p) {
    return repo.save(p);
  }

  @Override
  public void eliminar(int id) {
    repo.deleteById(id);
  }

  @Override
  public Optional<Persona> listarId(int id) {
    return repo.findById(id);
  }

  @Override
  public List<Persona> listar() {
    return repo.findAll();
  }

}
