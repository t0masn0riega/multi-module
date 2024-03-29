package com.mytest.office.controller;

import com.mytest.common.models.Office;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/offices")
public class OfficeController {

  private List<Office> offices;

  @PostConstruct
  public void init() {
    log.info("Initialize");
    offices = new ArrayList<>();
    offices.add(new Office(UUID.randomUUID(), "Office Name_" + 0));
    offices.add(new Office(UUID.randomUUID(), "Office Name_" + 1));
    offices.add(new Office(UUID.randomUUID(), "Office Name_" + 2));
    offices.add(new Office(UUID.randomUUID(), "Office Name_" + 3));
    offices.add(new Office(UUID.randomUUID(), "Office Name_" + 4));
    offices.add(new Office(UUID.randomUUID(), "Office Name_" + 5));
  }

  @GetMapping
  public ResponseEntity<List<Office>> search() {
    log.info("Search");
    return new ResponseEntity<>(offices, HttpStatus.OK);
  }

}
