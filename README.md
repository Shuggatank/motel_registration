





## System Tools Used

|                 |                              |
|-----------------|:-----------------------------|
| Spring Boot     | IntelliJ IDEA/Java 11 and 17 |
| Apache Maven    | PostgreSQL                   |
| Postman         | testcontainers               |
| Lucid App       | Duck Duck Go                 |
| Json Web Tokens | Docker                       |
<img alt="Spring-Boot" height="50" src="images/spring-boot-logo.png"/>
<img alt="IntelliJ-idea" height="50" src="images/intellij-idea-logo.png"/>
<img alt="Java" height="50" src="images/java-logo.png"/>
<img alt="PostgreSQL" height="50" src="images/postgresql-logo.png"/>
<img alt="Postman" height="50" src="images/postman-logo.png"/>
<img alt="testcontainers" height="50" src="images/testcontainers.png"/>
<img alt="Lucid charts" height="33" src="images/lucidcharts.png"/>
<img alt="Duck Duck Go" height="50" src="images/duckduckgo-logo.png"/>
<img alt="JSON" height="50" src="images/json-logo.png"/>
<img alt="Docker" height="50" src="images/docker-logo.png"/>



## Endpoints



| Request Type | URL                                 | Request Body                                                                                                      | Request Header            |
|--------------|:------------------------------------|:------------------------------------------------------------------------------------------------------------------|---------------------------|
| POST         | /auth/managers/register             | name, password                                                                                                    |                     |
| POST         | /auth/managers/login                | name, password                                                                                                    |                        |
| GET          | /api/registrations                  |                                                                                                                   | Authorization Bearer TOKEN |
| GET          | /api/registrations/{room}           |                                                                                                                   | Authorization Bearer TOKEN |
| POST         | /api/registrations                  | customerName, customerIdNumber, dateOfBirth, customerAddress, <br/>payment, roomNumber, checkInDate, checkOutDate | Authorization Bearer TOKEN |
| PUT          | /api/registrations/{room}           | customerName, customerIdNumber, dateOfBirth, customerAddress, <br/>payment, roomNumber, checkInDate, checkOutDate | Authorization Bearer TOKEN |
| PATCH        | /api/registrations/{room}           | customerName, customerIdNumber, dateOfBirth, customerAddress, <br/>payment, roomNumber, checkInDate, checkOutDate | Authorization Bearer TOKEN |
| DELETE       | /api/registrations/{room}           |                                                                                                                   |    Authorization Bearer TOKEN                       |
| GET          | /api/rooms                          |                                                                                                                   |                           |
| GET          | /api/rooms/{roomId}                 |                                                                                                                   |                           |
| POST         | /api/rooms                          | roomNumber, numberOfBeds, rate, clean, empty                                                                      |                           |
| PUT          | /api/rooms/{roomId}                 | roomNumber, numberOfBeds, rate, clean, empty                                                                                                                     |                           |
| PATCH        | /api/rooms/{roomId}                 | roomNumber, numberOfBeds, rate, clean, empty                                                                                                                     |                           |
| DELETE       | /api/rooms/{roomId}                 |                                                                                                                   |                           |
| GET          | /api/customers                      |                                                                                                                   |                           |
| GET          | /api/customers/{customerId}         |                                                                                                                   |                           |
| POST         |        /api/customers                              |                                                                                                                   |                           |
| PUT          | /api/customers/{customerId}                                     |                                                                                                                   |                           |
| PATCH        | /api/customers/{customerId}                                     |                                                                                                                   |                           |
| DELETE       | /api/customers/{customerId}                                     |                                                                                                                   |                           |
|              |                                     |                                                                                                                   |                           |
|              |                                     |                                                                                                                   |                           |
|              |                                     |                                                                                                                   |                           |
|              |                                     |                                                                                                                   |                           |
|              |                                     |                                                                                                                   |                           |
|              |                                     |                                                                                                                   |                           |
