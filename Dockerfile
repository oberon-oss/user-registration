# pre-fetch dependencies
FROM maven:3.9.9-eclipse-temurin-21-noble AS dependencies

WORKDIR /opt/app

COPY 100-data/130-repositories/pom.xml  100-data/130-repositories/pom.xml
COPY 100-data/120-entities/pom.xml      100-data/120-entities/pom.xml
COPY 100-data/pom.xml                   100-data/pom.xml
COPY 100-data/110-db/pom.xml            100-data/110-db/pom.xml

COPY 200-logic/230-controllers/pom.xml  200-logic/230-controllers/pom.xml
COPY 200-logic/pom.xml                  200-logic/pom.xml
COPY 200-logic/210-services/pom.xml     200-logic/210-services/pom.xml

COPY 300-appl/pom.xml                   300-appl/pom.xml
COPY 999-coverage/pom.xml               999-coverage/pom.xml
COPY pom.xml                            .

RUN mvn -B -e org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline -DexcludeArtifactIds=\
spring-demo-application,spring-demo-controllers,spring-demo-services,spring-demo-repo,spring-demo-entities,spring-demo-db

# build the jar
FROM maven:3.9.9-eclipse-temurin-21-noble AS builder

WORKDIR /opt/app
#Copy dependencies
COPY --from=dependencies /root/.m2 /root/.m2
COPY --from=dependencies /opt/app/ /opt/app

#Copy application sources.
COPY 200-logic/230-controllers/src  /opt/app/spring-demo/200-logic/230-controllers/src
COPY 200-logic/210-services/src     /opt/app/spring-demo/200-logic/210-services/src
COPY 100-data/130-repositories/src  /opt/app/spring-demo/100-data/130-repositories/src
COPY 100-data/120-entities/src      /opt/app/spring-demo/100-data/120-entities/src
COPY 100-data/110-db/src            /opt/app/spring-demo/100-data/110-db/src
COPY 300-appl/src                   /opt/app/spring-demo/300-appl/src

RUN mvn -B -e clean install -DskipTests

# prepeare runtime env
LABEL authors="TigerLilly64"
FROM openjdk:21-slim

WORKDIR /opt/app
COPY --from=builder /opt/app/300-appl/target/*.jar /app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]