FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/*.jar billing_service.jar
EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java","-jar","billing_service.jar"]

#Build the Docker Image : docker build -t billing-service .
#Run the Docker Container : docker run -p 4001:4001 -p 9001:9001 billing-service


