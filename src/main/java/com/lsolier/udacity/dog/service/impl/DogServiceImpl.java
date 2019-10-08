package com.lsolier.udacity.dog.service.impl;

import com.lsolier.udacity.dog.entity.Dog;
import com.lsolier.udacity.dog.repository.DogRepository;
import com.lsolier.udacity.dog.service.DogNotFoundException;
import com.lsolier.udacity.dog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

  private DogRepository dogRepository;

  @Autowired
  public DogServiceImpl(DogRepository dogRepository) {
    this.dogRepository = dogRepository;
  }

  @Override
  public List<String> retrieveDogBreed() {
    return dogRepository.findAllBreeds();
  }

  @Override
  public String retrieveDogBreedById(Long id) {
    Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
    String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
    return breed;
  }

  @Override
  public List<String> retrieveDogNames() {
    return dogRepository.findAllNames();
  }

  @Override
  public List<Dog> retrieveDogs() {
    return (List<Dog>) dogRepository.findAll();
  }
}
