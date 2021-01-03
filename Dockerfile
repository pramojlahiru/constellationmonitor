FROM openjdk:8

ADD target/constellationmonitor-0.0.1-SNAPSHOT.jar constellationmonitor.jar
EXPOSE 7777

ENTRYPOINT ["java","-jar","constellationmonitor.jar"]
