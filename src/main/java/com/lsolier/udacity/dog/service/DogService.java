package com.lsolier.udacity.dog.service;

import com.lsolier.udacity.dog.entity.Dog;

import java.util.List;

public interface DogService {

  List<String> retrieveDogBreed();

  String retrieveDogBreedById(Long id);

  List<String> retrieveDogNames();

  List<Dog> retrieveDogs();
}
