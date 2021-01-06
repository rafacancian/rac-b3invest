# b3invest

Project create to interact between microservices using the technologies
- Spring boot
- Spring cloud with 
    - Feign: for external server communications
    - Netflix:
    - Zuul:
    - Ribbon: load balance
    - Hystrix: fault tolerance e timeout
- JUnit: Tests
- Spock: Tests
- Lambok: Annotations helper
- Oauth 2 and JWT: Authentication system
- H2: database for tests
- Redis: cache 
- Eureka: Cloud server
- Docker: Imagens to run projects with dockerFiles

Steps

1 - Run Config Server 
- project is responsible for to get confidential configurations on github
 
2 - Run Eureka Server
- Project responsible for centralize the communication with 
- Default port 8761

3 - Run gateway Zuul
- Project responsible for
- Default port: 8765

4 - Run others projects 

5 - The Helper file - contains informations about
- Architecture
- Postman collection 



