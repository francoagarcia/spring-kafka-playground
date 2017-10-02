# PoC with Spring Boot and Apache Kafka
## Run
### 1. Start Zookeeper
```
bin/zookeeper-server-start.sh config/zookeeper.properties
``` 

### 2. Start a Broker
```
bin/kafka-server-start.sh config/server.properties
```

### 3. Create the Topic
```
bin/kafka-topics.sh --create --topic playground.req --zookeeper localhost:2181 --partitions 1 --replication-factor 1
```

### 4. Start our Spring Boot application
```
mvn clean install 
mvn spring-boot:run
```

### 5. Start a Producer and produce a Json Message
```
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic playground.req
> {"data":{"username": "franco", "password": "franco"}}
```