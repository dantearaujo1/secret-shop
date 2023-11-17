FROM maven:3.9.5-eclipse-temurin-17-focal as maven_build
# FROM openjdk:17

RUN echo "Projeto de Banco de Dados"
WORKDIR /app
# Copiando pom.xml
COPY pom.xml .
# Resolvendo dependencias do maven
RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r target/
COPY src ./src

# RUN mvn clean package -Dmaven.test.skip
# RUN mvn compile
RUN mvn package -Dmaven.test.skip
ENTRYPOINT ["java", "-jar", "./target/may-k-shop.jar"]
EXPOSE 6969

