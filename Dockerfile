## Use an official Maven runtime as a base image
FROM maven:3.8.4-openjdk-17

# Set the working directory in the container
WORKDIR /app

# Copy the entire project to the container
COPY . .

# Run Maven to build the project and execute TestNG tests
CMD ["mvn", "clean", "test"]

