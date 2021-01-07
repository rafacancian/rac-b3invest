FROM openjdk:13
VOLUME /tmp
EXPOSE 8888
ADD ./target/b3invest-configserver-0.0.1-SNAPSHOT.jar b3invest-configserver.jar
ENTRYPOINT ["java","-jar","/b3invest-configserver.jar"]