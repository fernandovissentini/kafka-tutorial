package com.fvissentini.kafkatutorial.kafka;

import java.util.UUID;

public record Message(UUID id, String content) {

}
