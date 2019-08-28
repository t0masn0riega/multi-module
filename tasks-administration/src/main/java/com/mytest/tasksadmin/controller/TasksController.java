package com.mytest.tasksadmin.controller;

import com.mytest.common.models.Customer;
import com.mytest.common.models.Office;
import com.mytest.common.models.Tasks;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/api/v1/tasks")
public class TasksController {

  @Autowired
  RestTemplate restTemplate;

  @GetMapping
  public ResponseEntity<Tasks> search() {
    log.info("Search");

    log.info("About to search for customers");
    ResponseEntity<List<Customer>> customersRespEnt = restTemplate.exchange(
        "http://customer-service/api/v1/customers",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Customer>>() {}
    );
    log.info("customersRespEnt: " + customersRespEnt);

    log.info("About to search for offices");
    ResponseEntity<List<Office>> officesRespEnt = restTemplate.exchange(
        "http://support-service/api/v1/offices",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Office>>() {}
    );
    log.info("customersRespEnt: " + customersRespEnt);

    Tasks task = new Tasks(customersRespEnt.getBody(), officesRespEnt.getBody());
    log.info("task: " + task);

    return new ResponseEntity<>(task, HttpStatus.OK);
  }

}
