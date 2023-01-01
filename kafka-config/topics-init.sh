sh echo "starting test topic"
sh kafka-topics.sh --create --topic test --replication-factor 1 --partitions 1 --zookeeper zookeeper:2181
