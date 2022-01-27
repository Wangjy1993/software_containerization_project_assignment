FROM maven:3.8.4-jdk-8 AS build
COPY src /backendApp/src
COPY pom.xml /backendApp/
RUN mvn -f /backendApp clean package -Dmaven.test.skip=true
ARG DEPENDENCY=target/dependency
RUN mkdir -p ${DEPENDENCY} && (cd ${DEPENDENCY}; jar -xf ../*.jar;cd ../../)

COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

FROM openjdk:8-jdk-alpine
COPY --from=build /app /app/
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","net.vu.springboot.SpringbootBackendApplication"]