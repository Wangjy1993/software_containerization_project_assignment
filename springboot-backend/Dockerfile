FROM maven:3.8.4-jdk-8 AS build
WORKDIR /backendApp
COPY src /backendApp/src
COPY pom.xml /backendApp/
RUN mvn clean package -Dmaven.test.skip=true
RUN mkdir -p /app/lib && mkdir -p /app/META-INF
RUN jar -xf target/*.jar && cp -R BOOT-INF/lib /app/lib  && cp -R META-INF /app/META-INF  && cp -R BOOT-INF/classes /app

FROM openjdk:8-jdk-alpine
COPY --from=build /app /app/
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","net.vu.springboot.SpringbootBackendApplication"]
