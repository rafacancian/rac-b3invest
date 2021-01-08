<p align="center">
  <a href="https://github.com/rafacancian/b3invest">
    <img width="400px" src="https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/layouts/b3invest-logo.png" alt="B3Invest Logo">
  </a>
</p>

>**Project developed for apply concepts and experiences using microservice architecture based on simplified investment business rules of B3 (Brazilian Investment exchange)**
> 
>**B3Invest Config Server** 
>>Module responsible to centralize the configuration access (this configurations are free because the project is used just to study)  
>
>**B3Invest Eureka Server** 
>>Module responsible to cloud server and service discover 
>
>**B3Invest Gateway Zuul**
>>Module responsible to manager the request using intelligent routing. When arrive a requisition from the client the gateway zuul will send to correct microservice
> 
>**B3Invest Broker**
>>Module represents the investment broker when the client has access and can view the B3 tickets and the respective values
>
>**B3Invest Manager**
>>Module that simulate the B3 Project, when the tickets are registers and controllers by the Brazilian investments
>
>**B3Invest User**
>>Module responsible from the user registers
>
>**B3Invest Oauth**
>>Security module responsible to control the access from all the systems according to authentication and authorizations users rulers
>

---

## System Technologies

- [Spring Boot]: Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"
- [Spring Cloud]: providing both authentication and authorization 
  - [Feign]: for external server communications
  - [Netflix Zuul]:  Intelligent Routing
  - [Netflix Ribbon]: Client-side IPC library
  - [Eureka]: Cloud server and service discovery
  - [Hystrix]: fault tolerance e timeout
- [Spring Security]: providing authentication and authorization security
  - [oauth2]: oauth2 authentication bearer JWT token system 
- [JUnit]: Unit Test
- [Spock]: A wonderful Groovy framework for Behaviour Driven Development-BDD test
- [Lombok]: Annotations helper library
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

---

## 5. The Postman Collection file

- [Postman collection][postman-file]

---

## Architecture Design
![](https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/architecture/architecture.png)

---

## Security Authentication Flow
![](https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/architecture/authenticationFlow.png)

---
## DockerFiles

### 1. Create network
```
docker network create b3invest-network
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

## CORS Configuration Test

Script used to test CORS 
```
fetch("http://localhost:8765/b3invest-broker/ticket", {
  "headers": {
    "accept": "*/*",
    "accept-language": "en-US,en;q=0.9,pt-BR;q=0.8,pt;q=0.7",
    "sec-fetch-dest": "empty",
    "sec-fetch-mode": "cors",
    "sec-fetch-site": "cross-site"
  },
  "referrer": "http://localhost:3000",
  "referrerPolicy": "no-referrer-when-downgrade",
  "body": null,
  "method": "GET",
  "mode": "cors",
  "credentials": "omit"
});
```

---

## TODO

- :heavy_check_mark: ~~Fix gateway communication with oauth to generate JWT Token~~
- :white_check_mark: B3Invest-Manager
  - :white_check_mark: Swagger
  - :white_check_mark: Hateoas
  - :white_check_mark: Pagination
  - :white_check_mark: Redis
- :white_check_mark: B3Invest-Broker
  - :white_check_mark: Swagger
  - :white_check_mark: Hateoas
  - :white_check_mark: Pagination
  - :white_check_mark: Redis
- :white_check_mark: B3Invest-User
  - :white_check_mark: Swagger
  - :white_check_mark: Unit Tests
- :white_check_mark: Docker Projects
  - :heavy_check_mark: ~~ConfigServer~~
  - :heavy_check_mark: ~~GatewayZuul~~
  - :heavy_check_mark: ~~EurekaServer~~
  - :white_check_mark: Oauth
  - :white_check_mark: User  
  - :white_check_mark: Manager  
  - :white_check_mark: Broker
  - :white_check_mark: Redis
    
[spring boot]: https://spring.io/projects/spring-boot
[spring cloud]: https://spring.io/projects/spring-cloud
[spring security]: https://spring.io/projects/spring-security 
[oauth2]: https://spring.io/projects/spring-security-oauth
[feign]: https://github.com/OpenFeign/feign
[netflix zuul]: https://github.com/Netflix/zuul/wiki
[netflix ribbon]: https://github.com/Netflix/ribbon
[hystrix]: https://github.com/Netflix/Hystrix
[junit]: https://junit.org/junit5/
[spock]: https://github.com/spockframework
[lombok]: https://github.com/rzwitserloot/lombok
[h2]: http://h2database.com/html/main.html
[redis]: https://redis.io/
[eureka]: https://github.com/Netflix/eureka
[docker]: https://www.docker.com/
[postman-file]: https://github.com/rafacancian/b3invest/tree/main/helper/postCollection
