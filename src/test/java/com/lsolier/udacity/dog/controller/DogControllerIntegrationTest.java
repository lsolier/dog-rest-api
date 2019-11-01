package com.lsolier.udacity.dog.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void getAllDogs() {
    String url = "http://localhost:" + port + "/dogs";
    ResponseEntity<List> response = this.restTemplate
        .withBasicAuth("admin","password")
        .getForEntity(url, List.class);
    Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

  @Test
  public void getDogBreed() {
    String url = "http://localhost:" + port + "/dogs/breed";
    ResponseEntity<List> response = this.restTemplate
        .withBasicAuth("admin","password")
        .getForEntity(url, List.class);
    Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

  @Test
  public void getDogNames() {
    String url = "http://localhost:" + port + "/dogs/name";
    ResponseEntity<List> response = this.restTemplate
        .withBasicAuth("admin","password")
        .getForEntity(url, List.class);
    Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

  @Test
  public void getDogBreedById() {
    String url = "http://localhost:" + port + "/1/breed";
    ResponseEntity<String> response = this.restTemplate
        .withBasicAuth("admin","password")
        .getForEntity(url, String.class);
    Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

}
