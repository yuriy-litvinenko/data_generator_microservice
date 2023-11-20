# data_generator_microservice

## Описание проекта
Учебный проект, представляющий собой Spring Boot RESTful веб-сервис для генерации и отправки тестовых данных в Apache Kafka.

Общие возможности сервиса:
- Прием сообщений с последующей отправкой в Apache Kafka
- Автоматическая генерация сообщений с интервалом 3 секунды и отправкой в Apache Kafka

## Стек технологий
- **Java 17.0.4.1**
- **Spring Boot 3.1.5**
- **Lombok 1.18.28**
- **MapStruct 1.5.5**
- **Spring Kafka 3.0.12**
- **Reactor Kafka 1.3.21**
- **Jcabi XML 0.29.0**
- **SnakeYAML 2.0**

## Использованное окружение при тестировании сервиса
- **Java 17.0.4.1**
- **Maven 3.6.2**
- **Kafka 2.13-3.6.0**
- **Postman 10.19**

## Взаимодействие с приложением
1. **Запуск ZooKeeper**  
   .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
2. **Запуск Kafka**  
   .\bin\windows\kafka-server-start.bat .\config\server.properties
3. **Мониторинг поступивших в Kafka сообщений с заданным топиком**  
   .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic data-temperature --from-beginning
4. **Отправка сообщения в Kafka с использованием данного сервиса**  
   POST http://localhost:8081/api/v1/data/send  
   {
   "sensorId": 5,
   "timestamp": "2023-11-20T20:00:00",
   "measurement": 35.5,
   "measurementType": "TEMPERATURE"
   }
5. **Запуск сервиса автоматически генерирующего сообщения с последующей отправкой в Kafka**  
   POST http://localhost:8081/api/v1/data/test/send  
   {
   "delayInSeconds": 3,
   "measurementTypes": [
   "POWER",
   "VOLTAGE",
   "TEMPERATURE"
   ]
   }
