FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/*.jar patient-service.jar
EXPOSE 4000
ENTRYPOINT ["java","-jar","patient-service.jar"]

#Build the Docker Image : docker build -t patient-management-service .
#Run the Docker Container : docker run -p 4000:4000 patient-management-service


