# BUILD DA APLICAÇÃO
FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml  .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package

# BASE PARA CONSTRUÇÃO DA IMAGEM
FROM openjdk:21-jdk-slim AS runtime

# INFORMAÇÕES DO PROJETO
LABEL authors="Aclécio Cruz"
LABEL version="1.0.0"
LABEL description="Projeto de gestão de orçamento doméstico"

ENV ENVIRONMENT="prod"
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9092

ENTRYPOINT ["java", "-jar"]
CMD ["app.jar"]