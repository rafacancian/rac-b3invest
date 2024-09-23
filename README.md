<p align="center">
  <a href="https://github.com/rafacancian/b3invest">
    <img width="400px" src="https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/layouts/b3invest-logo.png" alt="B3Invest Logo">
  </a>
</p>
<br>

### DEPRECATED: a new project was created (Private repository)
### The project was developed to apply concepts and experiences using a microservice architecture based on simplified investment business rules of B3 (Brazilian Investment Exchange).
<br><br>


#### B3Invest Config Server
The module is responsible for centralizing the configuration access (these configurations are public because the project is used just to study). 
<br><br>

#### B3Invest Eureka Server
The module is responsible for the cloud server and service discovery.
```
  Default Port: 8761
``` 
<br>

#### B3Invest Gateway Zuul
The module is responsible for managing the request using intelligent routing when a requisition from the client Gateway Zuul is send it to the correct microservice.
 ```
  Default port: 8765
 ```
<br>
 
#### B3Invest Broker
The module represents the investment broker when the client has access and can view the B3 tickets and the respective values.
<br><br>
  
#### B3Invest Manager
The module that simulates the B3 Project, when the tickets are registered and controllers by the Brazilian investments.
<br><br>
  
#### B3Invest User
The module is responsible for the user registers.
<br><br>

#### B3Invest Oauth
The security module is responsible for controlling access from all the systems according to authentication and authorization of the user's rulers.
<br>


<br>

## System Technologies

- [Spring Boot]: Spring Boot makes it easy to create stand-alone, production-grade Spring Applications that you can "just run"
- [Spring Cloud]: providing both authentication and authorization 
  - [Feign]: for external server communications
  - [Netflix Zuul]:  Intelligent Routing
  - [Netflix Ribbon]: Client-side IPC library
  - [Eureka]: Cloud server and service discovery
  - [Hystrix]: fault tolerance e timeout
- [Spring Security]: providing authentication and authorization security
  - [oauth2]: oauth2 authentication bearer JWT token system 
- [JUnit]: Unit Test
- [Spock]: A wonderful Groovy framework for behavior-driven Development-BDD test
- [Lombok]: Annotations helper library
- [H2]: A fast database embedded for tests
- [Redis]: A open source in-memory data structure store used as a database and cache
- [Swagger]: Swagger open source and pro tools have helped millions of API developers, teams, and organizations deliver great APIs.
- [Docker]: The most famous container engine used to execute the B3Invest project with their external dependencies

<br>

## Architecture Design
![](https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/architecture/architecture.png)

<br>

## Security Authentication Flow
![](https://raw.githubusercontent.com/rafacancian/b3invest/main/helper/architecture/authenticationFlow.png)

<br>

## Steps to run
1. Run Config Server
2. Run Eureka Server
3. Run gateway Zuul
4. Run other projects

<br>

## Postman Collection
- [Postman collection][postman-file]

<br>

## Redis
https://redislabs.com/get-started-with-redis/#Option-C
Docker image available on docker-compose file

```
 Coomand: docker-compose up -d
```

## Swagger
- The generated swagger HTML page is available at the following address
```
    http://localhost:8080/swagger-ui/index.html
```
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

<br>

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

<br>

## TODO

- :heavy_check_mark: ~~Fix gateway communication with oauth to generate JWT Token~~ 
- :heavy_check_mark: ~~B3Invest-Manager~~ 
    - :heavy_check_mark: ~~Swagger~~ 
    - :heavy_check_mark: ~~Hateoas~~
    - :heavy_check_mark: ~~Pagination~~
    - :heavy_check_mark: ~~Redis~~
- :heavy_check_mark: ~~B3Invest-Broker~~
    - :heavy_check_mark: ~~Swagger~~
    - :heavy_check_mark: ~~Hateoas~~
    - :heavy_check_mark: ~~Pagination~~
- :ballot_box_with_check: B3Invest-User
    - :heavy_check_mark: ~~Swagger~~
    - :ballot_box_with_check: Unit Tests
- :heavy_check_mark: ~~Docker Projects~~
    - :heavy_check_mark: ~~ConfigServer~~
    - :heavy_check_mark: ~~GatewayZuul~~
    - :heavy_check_mark: ~~EurekaServer~~
    - :heavy_check_mark: ~~Oauth~~
    - :heavy_check_mark: ~~User~~  
    - :heavy_check_mark: ~~Manager~~  
    - :heavy_check_mark: ~~Broker~~
    - :heavy_check_mark: ~~Redis~~
    
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
[Swagger]: https://swagger.io/
[eureka]: https://github.com/Netflix/eureka
[docker]: https://www.docker.com/
[postman-file]: https://github.com/rafacancian/b3invest/tree/main/helper/postCollection
