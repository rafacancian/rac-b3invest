FROM openjdk:13
VOLUME /tmp
EXPOSE 8761
ADD ./target/b3invest-eurekaserver-0.0.1-SNAPSHOT.jar b3invest-eurekaserver.jar
ENTRYPOINT ["java","-jar","/b3invest-eurekaserver.jar"]