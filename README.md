# Spring Boot API with Design Patterns: Singleton, Strategy, and Facade

This project is a challenge from the [Digital Innovation One (DIO)](https://www.dio.me/) bootcamp **Cognizant - Architecture with Spring Boot and Cloud**. The objective of this project is to implement a RESTful API using **Spring Boot**, while applying **Design Patterns** such as **Singleton**, **Strategy**, and **Facade**. Additionally, the API documentation is generated using **Swagger OpenAPI**.

## Project Overview

The project involves the creation of a simple CRUD (Create, Read, Update, Delete) application. This API is designed with proper architectural principles in mind and leverages the following design patterns:

- **Singleton**: Ensures that a class has only one instance, and provides a global point of access to it.
- **Strategy**: Allows selecting an algorithm's implementation at runtime.
- **Facade**: Provides a unified interface to a set of interfaces in a subsystem, making the API simpler and easier to use.

## Features

- RESTful API with CRUD operations.
- Use of **Design Patterns** to enhance the application structure.
- Integrated with **Swagger OpenAPI** for API documentation.
- Proper use of **Spring Boot** capabilities such as dependency injection, and component-based architecture.

## Technologies Used

- **Java 17**: The programming language used for building the API.
- **Spring Boot 3.x**: The framework used to simplify application development.
- **Spring Web**: For building REST APIs.
- **Spring Data JPA**: To interact with the database.
- **H2 Database**: An in-memory database for testing and development.
- **Swagger OpenAPI**: For API documentation and testing endpoints.
- **Maven**: For dependency management and project build.

## Design Patterns Used

### Singleton
The Singleton pattern ensures that a class has only one instance throughout the application's lifecycle. This pattern is commonly used for classes such as configuration managers, connection pools, or any resource that should be globally accessible.

### Strategy
The Strategy pattern is applied to allow selecting different ways of performing an operation at runtime. For example, the API might use different strategies for various CRUD operations based on business requirements.

### Facade
The Facade pattern simplifies the interaction with complex subsystems by providing a unified interface. In this project, the Facade pattern abstracts away complex logic and makes it easier for the API to interact with services and layers.

## API Documentation

The project is integrated with **Swagger OpenAPI** for comprehensive API documentation.

