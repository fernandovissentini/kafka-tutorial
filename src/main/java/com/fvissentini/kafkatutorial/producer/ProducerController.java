package com.fvissentini.kafkatutorial.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

  @GetMapping
  public ResponseEntity<String> getProducer() {
    return ResponseEntity.ok("This is just a test");
  }

}
