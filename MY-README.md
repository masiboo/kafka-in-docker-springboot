Steps by step

1.  docker-compose -f zk-single-kafka-single.yml up -d
2.  docker exec -it kafka1 /bin/bash
3.  kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic 'my-topic-name'
4.  kafka-topics --list --bootstrap-server localhost:9092
5.  Run the producer springboot app and publish message.
6.  kafka-console-cocnsumer -bootstrap-server localhost:9092 --topic my-topic-name