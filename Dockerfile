FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG OUTPUT_FOLDER=build/libs/
COPY ${OUTPUT_FOLDER} /app/lib
WORKDIR /app/lib
ENTRYPOINT ["java","-jar","lab6-0.0.1-SNAPSHOT.jar"]