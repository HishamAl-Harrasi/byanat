
  

# byanat Cell Tower Data API

  

This repository contains the solution to the backend challenge by **byanat**. It aims to create a REST API for parsing and filtering cell tower-related data. This is my first ever experience using Java and Spring (just learnt it the past week), so I'm probably not following all the best practices or I'm doing stuff the wrong way, but it's functioning as it should so hopefully its not *too* bad.

  

## Introduction

  

This project hosts a REST API that allows users to retrieve and filter cell tower information based on various criteria. The API is hosted at [https://byanat.hishamalharrasi.com](https://byanat.hishamalharrasi.com).

  

## Technologies Used

  

- Java (openjdk 20.0.1)

- Spring Boot

- Spring Data JPA

- PostgreSQL

- Docker

- Nginx

  

## Getting Started

Just use the hosted version to test, or otherwise run this script provided by executing: 	`sh start_project.sh`
  

## API Documentation

  

The API provides the following endpoints:

  

-  `GET /api/towers/all`: Retrieves all cell tower data.

-  `GET /api/towers`: Retrieves cell tower data, but with filtering options. Filtering options are optional, and they are to be passed as query strings in the URL. Options include:

- `?id=`

- `?operator=`

- `?technology=`

- `?tower_type=`

  

You can also import the Postman collection in the `docs/` directory.

  

A Swagger UI was also added, and can be found in the URL path: `/swagger-ui/index.html`

  

## Conclusion

  

For any questions or feedback, please reach out to [hisham@harrasi.dev](mailto:hisham@harrasi.dev).

  

Thank you!
