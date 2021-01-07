<p align="center">
  <a href="https://github.com/rafacancian/b3invest">
    <img width="400px" src="https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/layouts/b3invest-logo.png" alt="B3Invest Logo">
  </a>
</p>

> This project was developed for apply concepts and experiences using > the microservice architecture.
> Based on simplified investment business rules of B3 (Brazilian Investment exchange)

- [Spring Boot]
- [Spring Cloud] with
  - [Feign]: for external server communications
  - [Netflix Zuul]
  - [Netflix Ribbon]: Client-side IPC library
  - [Eureka]: Cloud server and service discovery
  - [Hystrix]: fault tolerance e timeout
- [JUnit]: For Unit Test
- [Spock Framework]: A wonderful Groovy framework for Behaviour Driven Development-BDD test
- [Project Lombok]: Annotations helper library
- Oauth 2 and JWT: Authentication bearer token system
- [H2]: A very fast database embedded for tests
- [Redis]: A open source in-memory data structure store used as a database and cache
- [Docker]: The most famous container engine used to execute the B3Invest project with their external dependencies

---

## Steps to run

### 1. Run Config Server

> Project is responsible for to get confidential configurations on Github

### 2. Run Eureka Server

> Project responsible for centralize the communication with

```
Default Port: 8761
```

### 3. Run gateway Zuul

> Project responsible for

```
Default port: 8765
```

### 4. Run others projects

### 5. The Postman Collection file

- [Postman collection][postman-file]

### Architecture Design
![](https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/architecture/architecture.png)

Authentication flow
![](https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/architecture/auth2.PNG)

![](https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/architecture/credentials.PNG)

---
## DockerFiles

### 1. Create network
```
docker network create b3invest-network
docker logs -f <container-id>
```

### 2. Config Server
```
mvnw clean package -DskipTests
docker build -t b3invest-configserver:v1 .
docker run -p 8888:8888 --name b3invest-configserver --network b3invest-network -e GITHUB_USER=rafacancian -e GITHUB_PASS=? b3invest-configserver:v1
```

### 3. Eureka Server
```
mvnw clean package -DskipTests
docker build -t b3invest-eurekaserver:v1 .
docker run -p 8761:8761 --name b3invest-eurekaserver --network b3invest-network b3invest-eurekaserver:v1
```

### 4. Gateway Zuul
```
mvnw clean package -DskipTests
docker build -t b3invest-gatewayzuul:v1 .
docker run -p 8765:8765 --name b3invest-gatewayzuul --network b3invest-network b3invest-gatewayzuul:v1
```

### Utils commands
```
docker logs -f <container-id>
docker run -p <external-port>:<internal-port> --name <container-name> --network <network-name> <image-name:tag>
```

---

## TODO

- :heavy_check_mark: Update helper architecture

- :heavy_check_mark: Update README repo file

- :white_check_mark: Fix gateway communication with oauth to generate JWT Token

- :white_check_mark: B3Invest-Manager
  - :white_check_mark: Swagger
  - :white_check_mark: Hateoas
  - :white_check_mark: Pagination
  - :white_check_mark: Redis
  - :white_check_mark: Swagger
- :white_check_mark: B3Invest-Broker
  - :white_check_mark: Swagger
  - :white_check_mark: Hateoas
  - :white_check_mark: Pagination
  - :white_check_mark: Redis
  - :white_check_mark: Swagger
- :white_check_mark: B3Invest-User
  - :white_check_mark: Swagger
  - :white_check_mark: Unit Tests
- :white_check_mark: Docker Projects

[spring boot]: https://spring.io/projects/spring-boot
[spring cloud]: https://spring.io/projects/spring-cloud
[feign]: https://github.com/OpenFeign/feign
[netflix zuul]: https://github.com/Netflix/zuul/wiki
[netflix ribbon]: https://github.com/Netflix/ribbon
[hystrix]: https://github.com/Netflix/Hystrix
[junit]: https://junit.org/junit5/
[spock framework]: https://github.com/spockframework
[project lombok]: https://github.com/rzwitserloot/lombok
[h2]: http://h2database.com/html/main.html
[redis]: https://redis.io/
[eureka]: https://github.com/Netflix/eureka
[docker]: https://www.docker.com/
[postman-file]: https://github.com/rafacancian/b3invest/tree/main/helper/postCollection
