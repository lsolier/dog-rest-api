package com.lsolier.udacity.dog.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lsolier.udacity.dog.entity.Dog;
import com.lsolier.udacity.dog.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

  private DogRepository dogRepository;

  public Query(DogRepository dogRepository) {
    this.dogRepository = dogRepository;
  }

  public Iterable<Dog> findAllDog() {
    return dogRepository.findAll();
  }

  public List<String> findAllBreeds() {
    return dogRepository.findAllBreeds();
  }

  public List<String> findAllDogNames() {
    return dogRepository.findAllDogNames();
  }

  public String findBreedById(Long id) {
    return dogRepository.findBreedById(id);
  }

  public Dog findDogById(Long id) {
    return dogRepository.findDogById(id);
  }

}
