package com.fvissentini.consumerservice.wikimedia;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wikimedia")
@AllArgsConstructor
public class WikimediaController {

  private final WikimediaService service;

  @GetMapping("/{id}")
  public ResponseEntity<WikimediaData> getById(String id) {
    return ResponseEntity.ok(service.getById(Long.parseLong(id)));
  }

}
