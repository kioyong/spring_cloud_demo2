port:
  yong-authorizationServer: 8081
  yong-gateway: 8082
  yong-kafka-receive: 8003
  yong-kafka-send: 8004
  yong-mark-api: 8080
  yong-mark-service: 9001,9002
  mongoDB: 27017
  kafka: 9092
  zookeeper: 2181

kafkaConfig:
  startKafka: 'kafka-server-start.bat D:\Users\z1125\SoftWare\kafka\config\server.properties'
  startZookeeper: 'zkserver.cmd'
