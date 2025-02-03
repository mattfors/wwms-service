<h1 style="text-align: center;">WWMS Service</h1>


<p style="text-align: center;">
  <img src="assets/wwms-logo-275x100.png" alt="WWMS Logo">
  <br>
  <em>The</em> <strong>Wacky Warehouse Management System</strong> <em>is a custom WMS created purely for experimentation. Any resemblance to actual warehouse management systems, either living or dead, is purely coincidental. This system is the product of wild experimentation and should not be used for real-world logistics (unless you’re feeling adventurous).</em>
</p>

## Project Setup

### Prerequisites

- Docker
- Docker Compose
- Java 17
- Maven

### Starting the MySQL Server

1. Ensure Docker is installed and running on your machine.
2. Start the MySQL server using Docker Compose:

    ```sh
    docker-compose up -d
    ```

### Starting the Spring Boot Server

1. Ensure you have Java 17 and Maven installed on your machine.
2. Navigate to the root directory of your Spring Boot project.
3. Build the project using Maven:

    ```sh
    mvn clean install
    ```

4. Start the Spring Boot application:

    ```sh
    mvn spring-boot:run
    ```

Your Spring Boot application should now be running and connected to the MySQL database.