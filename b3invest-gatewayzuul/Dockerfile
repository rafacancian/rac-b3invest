FROM openjdk:13
VOLUME /tmp
EXPOSE 8765
ADD ./target/b3invest-gatewayzuul-0.0.1-SNAPSHOT.jar b3invest-gatewayzuul.jar
ENTRYPOINT ["java","-jar","/b3invest-gatewayzuul.jar"]