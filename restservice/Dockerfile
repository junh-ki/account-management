# ----- 1. Jar Building Stage -----
FROM maven:3.8.1-jdk-11 AS build

# Copy the contents of the src directory
ADD src /usr/src/restservice/src/

# Copy the project file
COPY pom.xml /usr/src/restservice

# Copy the Dockerfile
COPY Dockerfile /usr/src/restservice

# Run Maven
RUN mvn -f /usr/src/restservice/pom.xml package -DskipTests

# ----- 2. Image Building Stage -----
FROM openjdk:11

# Set the work directory
WORKDIR /jardir

# Copy the built jar file from the previous stage to the current directory 
COPY --from=build /usr/src/restservice/target/restservice-0.0.1-SNAPSHOT.jar /jardir

# Set the entry point
ENTRYPOINT ["java", "-jar", "restservice-0.0.1-SNAPSHOT.jar"]

# ----- Docker Command Examples -----

# docker login --username=${DOCKER_HUB_USERNAME} --password=${DOCKER_HUB_PASSWORD}
# docker build -t ${DOCKER_HUB_USERNAME}/restservice-account-management .
# docker push ${DOCKER_HUB_USERNAME}/restservice-account-management
# docker pull ${DOCKER_HUB_USERNAME}/restservice-account-management
# docker run -p 8080:8080 -d -t ${DOCKER_HUB_USERNAME}/restservice-account-management

# You need to empty port 8080 to do this.
