package com.lsolier.udacity.dog.repository;

import com.lsolier.udacity.dog.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

  String FIND_BREEDS = "Select d.id, d.breed from dog d";
  @Query(value = FIND_BREEDS, nativeQuery = true)
  List<String> findAllBreeds();

  String FIND_NAMES = "Select d.id, d.name from dog d";
  @Query(value = FIND_NAMES, nativeQuery = true)
  List<String> findAllDogNames();

  String FIND_BREED_BY_ID = "Select d.id, d.breed from dog d where d.id = :id";
  @Query(value = FIND_BREED_BY_ID, nativeQuery = true)
  String findBreedById(@Param("id") Long Id);

  String DELETE_DOG_BY_BREED = "delete from dog d where d.breed = :breed";
  @Query(value = DELETE_DOG_BY_BREED, nativeQuery = true)
  Boolean deleteDogBreed(@Param("breed") String breed);

  Dog findDogById(Long id);

}
