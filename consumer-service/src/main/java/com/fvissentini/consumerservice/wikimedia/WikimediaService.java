package com.fvissentini.consumerservice.wikimedia;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WikimediaService {

  private final WikimediaRepository repository;

  @SneakyThrows
  public WikimediaData getById(long id) {
    return repository.findById(id)
        .orElseThrow(() -> new Exception("Error: not found"));
  }

  public void save(WikimediaData data) {
    repository.save(data);
  }

}
