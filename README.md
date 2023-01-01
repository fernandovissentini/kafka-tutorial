# Tutorial for Apache Kafka

## commands
#### A non-default bridge network enables convenient name-to-hostname discovery
$ docker network create kafka-net

$ docker run -d --name zookeeper --network kafka-net zookeeper:3.4
$ docker run -d --name kafka --network kafka-net --env ZOOKEEPER_IP=zookeeper ches/kafka

$ docker run --rm --network kafka-net ches/kafka \
>   kafka-topics.sh --create --topic test --replication-factor 1 --partitions 1 --zookeeper zookeeper:2181
Created topic "test".

#### In separate terminals:
$ docker run --rm --interactive --network kafka-net ches/kafka \
>   kafka-console-producer.sh --topic test --broker-list kafka:9092
<type some messages followed by newline>

$ docker run --rm --network kafka-net ches/kafka \
>   kafka-console-consumer.sh --topic test --from-beginning --bootstrap-server kafka:9092
```

