package com.lsolier.udacity.dog.mutator;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lsolier.udacity.dog.entity.Dog;
import com.lsolier.udacity.dog.exception.graphql.DogNotFoundExceptionGraphql;
import com.lsolier.udacity.dog.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

  private DogRepository dogRepository;

  public Mutation(DogRepository dogRepository) {
    this.dogRepository = dogRepository;
  }

  public Dog newDog(String name, String breed, String origin) {
    Dog dog = new Dog(name, breed, origin);
    dogRepository.save(dog);
    return dog;
  }

  public boolean deleteDog(Long id) {
    dogRepository.deleteById(id);
    return true;
  }

  public Dog updateDogName(String name, Long id) {
    Optional<Dog> dogOptional = dogRepository.findById(id);
    if (dogOptional.isPresent()) {
      Dog dog = dogOptional.get();
      dog.setName(name);
      return dogRepository.save(dog);
    } else {
      throw new DogNotFoundExceptionGraphql("Dog not found", id);
    }
  }

  public boolean deleteDogBreed(String breed) {
    boolean deleted = false;
    Iterable<Dog> allDogs = dogRepository.findAll();
    for (Dog dog : allDogs) {
      if (breed.equals(dog.getBreed())) {
        dogRepository.delete(dog);
        deleted = true;
      }
    }

    if (!deleted) {
      throw new DogNotFoundExceptionGraphql("Breed nof found", breed);
    }
    return deleted;
  }

}
