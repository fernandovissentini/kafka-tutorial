# Tutorial for Apache Kafka

This tutorial follows: https://www.youtube.com/watch?v=xCyW3S-vgGA&list=PLGRDMO4rOGcNLwoack4ZiTyewUcF6y6BU

Docker is not working yet, please use local installed kafka

## commands
#### A non-default bridge network enables convenient name-to-hostname discovery
$ docker network create kafka-net

$ docker run -d --name zookeeper --network kafka-net -p 2181:2181 -p 3888:3888 -p 2888:2888 zookeeper:3.8.0
$ docker run -d --name kafka --network kafka-net --env ZOOKEEPER_IP=zookeeper -p 9092:9092 -p 7203:7203 ches/kafka

$ docker run --rm --network kafka-net ches/kafka kafka-topics.sh --create --topic test --replication-factor 1 --partitions 1 --zookeeper zookeeper:2181
Created topic "test".

#### In separate terminals:
$ docker run --rm --interactive --network kafka-net ches/kafka kafka-console-producer.sh --topic test --broker-list kafka:9092
<type some messages followed by newline>

$ docker run --rm --network kafka-net ches/kafka kafka-console-consumer.sh --topic test --from-beginning --bootstrap-server kafka:9092
```

