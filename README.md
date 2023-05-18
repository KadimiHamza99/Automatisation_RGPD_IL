# Automatisation_RGPD_IL

## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
- [Usage](#usage)

## About <a name="about"></a>

The goal of our project is to assist software engineering to ensure privacy protection. The main idea is to provide a method that assists software engineers in managing users' personal data and ensuring compliance with relevant regulations during the development or maintenance of new or existing applications.

This project consists of microservices developed using different technologies (ExpressJS, SpringBoot, Flask, Angular). To run them, follow the steps in the specified order.

Our microservices architecture is developed in SpringBoot and includes a Eureka registration service, a Spring Cloud Config server for centralizing configurations, and a Zuul proxy service to intercept requests from the front-end application.

First, execute the configuration service, then the registration service, followed by the proxy service, and finally the remaining microservices in any order.

## Getting Started <a name="getting-started"></a>

### Configuration file

First, copy the 'cloud-conf' directory to any desired location on your local machine. Then navigate to that directory and execute the following commands:
git init
git add .

Next, update the file path in the configuration file of the configuration service ('service-configuration') as follows:
- Open the file `./service-configuration/src/main/resources/application.properties`
- Set the value of the property `spring.cloud.config.server.git.uri` to the path of the 'cloud-conf' directory you chose (e.g., `file://${user.home}/cloud-conf`)

### Run configuration service

Navigate to the 'target' directory of the 'service-configuration' project and execute the command:
java -jar service-configuration-0.0.1-SNAPSHOT


### Run registry service

Navigate to the 'target' directory of the 'service-register' project and execute the command:

java -jar service-register-0.0.1-SNAPSHOT

### Run proxy service

Navigate to the 'target' directory of the 'service-proxy' project and execute the command:
java -jar service-proxy-0.0.1-SNAPSHOT


### Run processing service

Navigate to the 'target' directory of 

### Run consent service

Navigate to the 'target' directory of the 'Consent-service' project. First, modify the database configurations in the 'bdd.py' file. Then, execute the following commands:
the 'service-processing' project and execute the command:
pip install py-eureka-client
pip install mysql-connector-python
py ./bdd.py
py ./app.py

java -jar service-company-0.0.1-SNAPSHOT


### Run Data & DataSubject service

- Create a MySQL database.
- Fill in the `.env` file in `GDPR_HELPER/API/`:
  - Set `DATABASE_URL` to the authentication URL of the database (e.g., `mysql://username:password@host:port/DatabaseName`).
  - Set `ADMIN_API_KEY` as the key for external client access to GDPRMS.
  - Set `API_ENDPOINT_PROCESS_DATA_REQUEST_ANSWERS` to the address of the Provider Application API endpoint used by the server to notify the Provider server about new data request answers.
- Run the following commands:
cd GDPR_HELPER/API/
npm install
npx prisma db push
npm run start

### Launch the test server

Navigate to the 'JSON_SERVER4TEST' directory and run the command:

### Prerequisites

You will need the following:

1. Node.js installed
2. Maven installed
3. Java 11+ installed
4. Python installed
5. pip installed
6. (Optional) Eclipse installed for running Spring Boot microservices

## Usage <a name="usage"></a>

To verify that all the services in the architecture are running correctly, check if they are detectable by the Eureka registration service (Eureka Clients) by navigating to the URL: `http://localhost:8760`
