

## User Stories

---
   - [x] As a manager I would like to create a new customer through registration
   - [x] As a manager I would like to be able to login
   - [x] As a manager I would like to check on the status of each room
   - [x] As a manager I would like to be able to update customer information
   - [x] As a manager I would like to view daily reports
   - [x] As a manager I would like to view monthly reports
   - [x] As a manager I would like to assign the customer a room
   - [x] As a manager I would to assign a customer a check in and check out date
   - [ ] As a manager I would like to check customer history
   - [ ] As a manager I would like to choose different payment type (cash or credit card)


   - [ ] As an admin I would full access to the system
   - [ ] As an admin I would like to be able to edit permissions
   - [ ] As an admin I would like to view system reports and logs


## Entity Relationship Diagram (ERD)

---

### Initial ERD
<img alt="Original ERD Diagram" width="65%" src="images/ERD - Page 1.png"/>

### Project ERD

<img alt="IntellJ ERD Diagram" width="65%" src="images/entityManagerFactory(EntityManagerFactoryBuilder).png"/>

## System Tools Used

|                 |                              |
|-----------------|:-----------------------------|
| Spring Boot     | IntelliJ IDEA/Java 11 and 17 |
| Apache Maven    | PostgreSQL                   |
| Postman         | testcontainers               |
| Lucid App       | Duck Duck Go                 |
| Json Web Tokens | Docker                       |


<img alt="Spring-Boot" height="50" src="images/spring-boot-logo.png"/> <img alt="IntelliJ-idea" height="50" src="images/intellij-idea-logo.png"/> <img alt="Java" height="50" src="images/java-logo.png"/> <img alt="PostgreSQL" height="50" src="images/postgresql-logo.png"/> <img alt="Postman" height="50" src="images/postman-logo.png"/> <img alt="testcontainers" height="50" src="images/testcontainers.png"/> <img alt="Lucid charts" height="33" src="images/lucidcharts.png"/> <img alt="Duck Duck Go" height="50" src="images/duckduckgo-logo.png"/> <img alt="JSON" height="50" src="images/json-logo.png"/> <img alt="Docker" height="50" src="images/docker-logo.png"/>












## Endpoints

----


| Request Type | URL                                        | Request Body                                                                                                 | Request Header             |
|--------------|:-------------------------------------------|:-------------------------------------------------------------------------------------------------------------|----------------------------|
| POST         | /auth/managers/register                    | name, password                                                                                               |                            |
| POST         | /auth/managers/login                       | name, password                                                                                               |                            |
| GET          | /api/registrations                         |                                                                                                              | Authorization Bearer TOKEN |
| GET          | /api/registrations/{room}                  |                                                                                                              | Authorization Bearer TOKEN |
| POST         | /api/registrations                         | customerName, customerIdNumber, dateOfBirth, customerAddress, payment, roomNumber, checkInDate, checkOutDate | Authorization Bearer TOKEN |
| PUT          | /api/registrations/{room}                  | customerName, customerIdNumber, dateOfBirth, customerAddress, payment, roomNumber, checkInDate, checkOutDate | Authorization Bearer TOKEN |
| PATCH        | /api/registrations/{room}                  | customerName, customerIdNumber, dateOfBirth, customerAddress, payment, roomNumber, checkInDate, checkOutDate | Authorization Bearer TOKEN |
| DELETE       | /api/registrations/{room}                  |                                                                                                              | Authorization Bearer TOKEN |
| GET          | /api/rooms                                 |                                                                                                              | Authorization Bearer TOKEN |
| GET          | /api/rooms/{roomId}                        |                                                                                                              | Authorization Bearer TOKEN |
| POST         | /api/rooms                                 | roomNumber, numberOfBeds, rate, clean, empty                                                                 | Authorization Bearer TOKEN |
| PUT          | /api/rooms/{roomId}                        | roomNumber, numberOfBeds, rate, clean, empty                                                                 | Authorization Bearer TOKEN |
| PATCH        | /api/rooms/{roomId}                        | roomNumber, numberOfBeds, rate, clean, empty                                                                 | Authorization Bearer TOKEN |
| DELETE       | /api/rooms/{roomId}                        |                                                                                                              | Authorization Bearer TOKEN |
| GET          | /api/customers                             |                                                                                                              | Authorization Bearer TOKEN |
| GET          | /api/customers/{customerId}                |                                                                                                              | Authorization Bearer TOKEN |
| POST         | /api/customers                             | customerName, customerIdNumber, dateOfBirth, customerAddress                                                 | Authorization Bearer TOKEN |
| PUT          | /api/customers/{customerId}                | customerName, customerIdNumber, dateOfBirth, customerAddress                                                 | Authorization Bearer TOKEN |
| PATCH        | /api/customers/{customerId}                | customerName, customerIdNumber, dateOfBirth, customerAddress                                                 | Authorization Bearer TOKEN |
| DELETE       | /api/customers/{customerId}                |                                                                                                              | Authorization Bearer TOKEN |
| GET          | /api/registration_history                  |                                                                                                              | Authorization Bearer TOKEN |
| GET          | /api/registration_history/{registrationId} |                                                                                                              | Authorization Bearer TOKEN |
| PATCH        | /api/registration_history/{registrationId} | customerName, customerIdNumber, dateOfBirth, customerAddress, payment, roomNumber, checkInDate, checkOutDate | Authorization Bearer TOKEN |


##Project Structure


```├── HELP.md
├── images
│   ├── docker-logo.png
│   ├── duckduckgo-logo.png
│   ├── entityManagerFactory(EntityManagerFactoryBuilder).png
│   ├── ERD - Page 1.png
│   ├── intellij-idea-logo.png
│   ├── java-logo.png
│   ├── json-logo.png
│   ├── lucidcharts.png
│   ├── motel_registration_class_diagram.png
│   ├── postgresql-logo.png
│   ├── postman-logo.png
│   ├── spring-boot-logo.png
│   └── testcontainers.png
├── motel_registration.iml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── motelreg
│   │   │           └── motel_registration
│   │   │               ├── controller
│   │   │               │   ├── CustomerController.java
│   │   │               │   ├── ManagerController.java
│   │   │               │   ├── RegistrationController.java
│   │   │               │   ├── RegistrationHistoryController.java
│   │   │               │   └── RoomController.java
│   │   │               ├── exceptions
│   │   │               │   ├── InformationExistsException.java
│   │   │               │   ├── InformationNotFoundException.java
│   │   │               │   └── NotReady.java
│   │   │               ├── model
│   │   │               │   ├── Customer.java
│   │   │               │   ├── Manager.java
│   │   │               │   ├── RegistrationHistory.java
│   │   │               │   ├── Registration.java
│   │   │               │   ├── Request
│   │   │               │   │   └── LoginRequest.java
│   │   │               │   ├── Response
│   │   │               │   │   └── LoginResponse.java
│   │   │               │   └── Room.java
│   │   │               ├── MotelRegistrationApplication.java
│   │   │               ├── repository
│   │   │               │   ├── CustomerRepository.java
│   │   │               │   ├── ManagerRepository.java
│   │   │               │   ├── RegistrationHistoryRepository.java
│   │   │               │   ├── RegistrationRepository.java
│   │   │               │   └── RoomRepository.java
│   │   │               ├── security
│   │   │               │   ├── MyUserDetails.java
│   │   │               │   ├── MyUserDetailsService.java
│   │   │               │   └── SecurityConfigurer.java
│   │   │               └── service
│   │   │                   ├── CustomerService.java
│   │   │                   ├── JwtRequestFilter.java
│   │   │                   ├── JWTUtils.java
│   │   │                   ├── ManagerService.java
│   │   │                   ├── RegistrationHistoryService.java
│   │   │                   ├── RegistrationService.java
│   │   │                   └── RoomService.java
│   │   └── resources
│   │       ├── application-dev.properties
│   │       ├── application.properties
│   │       ├── application-test.properties
│   │       └── test-customer-data.sql
│   └── test
│       └── java
│           └── com
│               └── motelreg
│                   └── motel_registration
│                       ├── containertests
│                       │   ├── BaseContainerTest.java
│                       │   ├── CustomerRepositoryContainerTest.java
│                       │   ├── ManagerRepositoryContainerTest.java
│                       │   ├── RegistrationHistoryRepositoryContainerTest.java
│                       │   ├── RegistrationRepositoryContainerTest.java
│                       │   └── RoomRepositoryContainerTest.java
│                       ├── CustomerRepositoryTest.java
│                       ├── ManagerRepositoryTest.java
│                       ├── MotelRegistrationApplicationTests.java
│                       ├── RegistrationHistoryRepositoryTest.java
│                       ├── RegistrationRepositoryTest.java
│                       └── RoomRepositoryTest.java
└── target
    ├── classes
    │   ├── application-dev.properties
    │   ├── application.properties
    │   ├── application-test.properties
    │   ├── com
    │   │   └── motelreg
    │   │       └── motel_registration
    │   │           ├── controller
    │   │           │   ├── CustomerController.class
    │   │           │   ├── ManagerController.class
    │   │           │   ├── RegistrationController.class
    │   │           │   ├── RegistrationHistoryController.class
    │   │           │   └── RoomController.class
    │   │           ├── exceptions
    │   │           │   ├── InformationExistsException.class
    │   │           │   ├── InformationNotFoundException.class
    │   │           │   └── NotReady.class
    │   │           ├── model
    │   │           │   ├── Customer.class
    │   │           │   ├── Manager.class
    │   │           │   ├── Registration.class
    │   │           │   ├── RegistrationHistory.class
    │   │           │   ├── Request
    │   │           │   │   └── LoginRequest.class
    │   │           │   ├── Response
    │   │           │   │   └── LoginResponse.class
    │   │           │   └── Room.class
    │   │           ├── MotelRegistrationApplication.class
    │   │           ├── repository
    │   │           │   ├── CustomerRepository.class
    │   │           │   ├── ManagerRepository.class
    │   │           │   ├── RegistrationHistoryRepository.class
    │   │           │   ├── RegistrationRepository.class
    │   │           │   └── RoomRepository.class
    │   │           ├── security
    │   │           │   ├── MyUserDetails.class
    │   │           │   ├── MyUserDetailsService.class
    │   │           │   └── SecurityConfigurer.class
    │   │           └── service
    │   │               ├── CustomerService.class
    │   │               ├── JwtRequestFilter.class
    │   │               ├── JWTUtils.class
    │   │               ├── ManagerService.class
    │   │               ├── RegistrationHistoryService.class
    │   │               ├── RegistrationService.class
    │   │               └── RoomService.class
    │   ├── customer.sql
    │   ├── test-customer-data.sql
    │   └── test-manager-data.sql
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    └── test-classes
        └── com
            └── motelreg
                └── motel_registration
                    ├── containertests
                    │   ├── BaseContainerTest.class
                    │   ├── CustomerRepositoryContainerTest.class
                    │   ├── ManagerRepositoryContainerTest.class
                    │   ├── RegistrationHistoryRepositoryContainerTest.class
                    │   ├── RegistrationRepositoryContainerTest.class
                    │   └── RoomRepositoryContainerTest.class
                    ├── CustomerRepositoryTest.class
                    ├── ManagerRepositoryTest.class
                    ├── RegistrationHistoryRepositoryTest.class
                    ├── RegistrationRepositoryTest.class
                    └── RoomRepositoryTest.class

 ```
<br></br>

##Installation



- Install [PostgreSQL](https://www.postgresql.org/download/). Using the localhost with port 5432, create a database named motel_records.
- Update application-dev.properties with your username and password.
- To test endpoints use [Postman](https://www.postman.com/). You may import the Motel_Registration.postman_collection.json file into Postman to get all endpoints.
- For container testing, install [Docker](https://docs.docker.com/engine/install/). After docker is installed, you need to install the [Postgres docker image](https://hub.docker.com/_/postgres/).

