package com.lsolier.udacity.dog.exception.graphql;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundExceptionGraphql extends RuntimeException implements GraphQLError {

  private Map<String, Object> extensions = new HashMap<>();

  public DogNotFoundExceptionGraphql(String message, Long invalidDogId) {
    super(message);
    extensions.put("invalidDogId", invalidDogId);
  }

  public DogNotFoundExceptionGraphql(String message, String breed) {
    super(message);
    extensions.put("invalidDogBreed", breed);
  }

  @Override
  public Map<String, Object> getExtensions() {
    return extensions;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.DataFetchingException;
  }
}
