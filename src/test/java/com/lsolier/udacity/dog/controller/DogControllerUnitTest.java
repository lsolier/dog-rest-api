package com.lsolier.udacity.dog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.lsolier.udacity.dog.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DogService dogService;

  @WithMockUser(value = "admin")
  @Test
  public void getAllDogs() throws Exception {
    mockMvc.perform(get("/dogs"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(content().json("[]"));

    Mockito.verify(dogService, times(1)).retrieveDogs();
  }

  @WithMockUser(value = "admin")
  @Test
  public void getDogNames() throws Exception {
    mockMvc.perform(get("/dogs/name"))
        .andExpect(status().isOk());

    Mockito.verify(dogService, times(1)).retrieveDogNames();
  }

  @WithMockUser(value = "admin")
  @Test
  public void getDogBreed() throws Exception {
    mockMvc.perform(get("/dogs/breed"))
        .andExpect(status().isOk());

    Mockito.verify(dogService, times(1)).retrieveDogBreed();
  }

  @WithMockUser(value = "admin")
  @Test
  public void getDogBreedById() throws Exception {
    mockMvc.perform(get("/1/breed"))
        .andExpect(status().isOk());

    Mockito.verify(dogService, times(1)).retrieveDogBreedById(1L);
  }

}