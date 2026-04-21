package com.carbonorural.carbonoruralapi.service;

import com.carbonorural.carbonoruralapi.model.Animal;
import com.carbonorural.carbonoruralapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public List<Animal> listar() {
        return repository.findAll();
    }

    public Animal buscarPorId(Long id) {
        Optional<Animal> animal = repository.findById(id);
        return animal.orElse(null);
    }

    public Animal criar(Animal animal) {
        return repository.save(animal);
    }

    public Animal atualizar(Long id, Animal novoAnimal) {
        Optional<Animal> existente = repository.findById(id);

        if (existente.isPresent()) {
            Animal animal = existente.get();
            animal.setNome(novoAnimal.getNome());
            animal.setEspecie(novoAnimal.getEspecie());
            return repository.save(animal);
        }

        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
