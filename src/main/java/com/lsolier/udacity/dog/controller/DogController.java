package com.lsolier.udacity.dog.controller;

import com.lsolier.udacity.dog.entity.Dog;
import com.lsolier.udacity.dog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

  private DogService dogService;

  @Autowired
  public DogController(DogService dogService) {
    this.dogService = dogService;
  }

  @GetMapping("/dogs")
  public ResponseEntity<List<Dog>> getAllDogs() {
    List<Dog> dogs = dogService.retrieveDogs();
    return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
  }

  @GetMapping("/dogs/breed")
  public ResponseEntity<List<String>> getDogBreed() {
    List<String> dogBreedList = dogService.retrieveDogBreed();
    return new ResponseEntity<List<String>>(dogBreedList, HttpStatus.OK);
  }

  @GetMapping("/dogs/name")
  public ResponseEntity<List<String>> getDogNames() {
    List<String> dogNames = dogService.retrieveDogNames();
    return new ResponseEntity<List<String>>(dogNames, HttpStatus.OK);
  }

  @GetMapping("/{id}/breed")
  public ResponseEntity<String> getDogBreedById(@PathVariable Long id){
    String dog = dogService.retrieveDogBreedById(id);
    return new ResponseEntity<String>(dog, HttpStatus.OK);
  }

}
