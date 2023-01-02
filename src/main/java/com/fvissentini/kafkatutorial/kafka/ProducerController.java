package com.fvissentini.kafkatutorial.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
@Slf4j
public class ProducerController {

  private final ProducerService service;

  @GetMapping
  public ResponseEntity<String> getProducer() {
    return ResponseEntity.ok("This is just a test");
  }

  @PostMapping
  public ResponseEntity<Void> sendMessage(@RequestBody RequestMessageDTO request) {
    log.info("\n***Received message {} to send\n", request.message());
    service.sendMessage(request.message());
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}

record RequestMessageDTO(String message) { }
