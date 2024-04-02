# Pizzeria Reference Project (PizzaRP)

This is a minimal Pizzeria Reference Project (PizzaRP) as a template for students. 

[![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

> 🚧: **This is a template project**: Make sure you adapt this documentation and the source code in this project according to your needs and use case. Comments are provided with "🚧:". Do not leave these comments in your final submission!

## Contents

> 🚧: Todo

- [Pizzeria Reference Project (PizzaRP)](#pizzeria-reference-project-pizzarp)
      - [Contents:](#contents)
  - [Analysis](#analysis)
    - [Scenario](#scenario)
    - [User Stories](#user-stories)
    - [Use Case](#use-case)
  - [Design](#design)
    - [Wireframe](#wireframe)
    - [Prototype](#prototype)
    - [Domain Design](#domain-design)
    - [Business Logic](#business-logic)
  - [Implementation](#implementation)
    - [Backend Technology](#backend-technology)
    - [Frontend Technology](#frontend-technology)
  - [Execution](#execution)
  - [Project Management](#project-management)
    - [Roles](#roles)
    - [Milestones](#milestones)
      - [Maintainer](#maintainer)
      - [License](#license)

## Analysis

> 🚧: You can reuse the analysis (you made) from other projects (e.g., requirement engineering), but it must be submitted according to the following template. 

### Scenario

> 🚧: Todo

PizzaRP (Pizzeria Reference Project) is the smallest possible and lightweight demonstration tool allowing the pizzaiolo (Role: Admin) to manage its pizza catalog. 

### User Stories
1. As an Admin, I want to have a Web app to use on different mobile devices and desktop computers.
2. As an Admin, I want to see a consistent visual appearance to navigate easily, and it should look consistent.
3. As an Admin, I want to use list views to explore and read my business data.
4. As an Admin, I want to use edit and create views to maintain my business data.
5. As an Admin, I want to log-in so that I can authenticate myself.
6. As a User, I want to use list views so that I can access public pages.
7. (Optional) As a User, I want to authenticate myself so that I can read my personal and confidential data.

### Use Case

> 🚧: In progress

![use-case-diagram](https:////www.plantuml.com/plantuml/png/POt1geCm44NtynM3UnTFNRbuw5FU1xJu0KESQZ0caamMfVJVsq05gRlBlOTpco3a9Qu63Dy4nQ7NqomuQizAjBD0Ifp7TborHGf8y6c6m3uL4M0ZjT34-6_kxRRX0n1ZO4M1CUikG_yUaZHaYH-wdzFUSn1jAVtjK764hanUpL-QygJvSsxHTjg12fvGKurv_fjU3xc0EkwvFEGA6hPZNCqB)

- UC-1 [CRUD Flights]: Admin can create, read, update and deletethe flights.
- UC-2 ...
- UC-3 ...
- UC-4 ...

## Design

> 🚧: Todo
> 🚧: Keep in mind the Corporate Identity (CI); you shall decide appropriately the color schema, graphics, typography, layout, User Experience (UX), and so on.

### Wireframe

> 🚧: Todo
> 🚧: It is suggested to start with a wireframe. The wireframe focuses on the website structure (Sitemap planning), sketching the pages using Wireframe components (e.g., header, menu, footer) and UX. You can create a wireframe already with draw.io or similar tools. 

Starting from the home page, we can visit different pages. Available public pages are visible in the menu...

### Prototype

> 🚧: Todo
> 🚧: A prototype can be designed using placeholder text/figures in Budibase. You don't need to connect the front-end to back-end in the early stages of the project development.

### Domain Design

> 🔍: To review

The `ch.fhnw.flyaround.data.domain` package contains the following domain objects / entities including getters and setters:

![class-diagram](https://www.plantuml.com/plantuml/png/XL9DQnmn3BtxLuWz5XBQwr2Mj0s5XH8AxH_GUZmJ4NyCihQN9V-zjXclFTEFtEIdPqdlIGzHaENYhD8MOuIlbkPdWQi2c4fu6c607yBaPqYWHcOo_2MCveRVk4yNTpQSy9CNCnjEYS0qaq_G9-8bi2HeD578er3OuqiUXSrFShdu8qe9Koet_ONsBmbYpJX9BhI6wbMfLKo5uDgelQ2Ynzf8i-ynbyJP7eW69NQoNbk3Cdojd-AzNnxTnYX2mRrvf35iiIRXiPcbhblpUY7xHeMecPPCx671EIlvHb4-nW8Us-otpAhhs0toEOINnCvIpoKwZQsiVZRwvUJJOhRxMT9Fu-To4zzhhDPh6TPZQqqQ9xTflxTA9-8eJpkv5l_4Z4EoMrFhmWuV3d1t1uVtz_Vl3lNe1vWuE3Y-nPAGEEMrfrIJ1ZYdo8mm1OOZgARhV_oOodRxhgJG-7Mm0SXhUnbD_bAl_5_ZXiKmIg6g1-F7YxE_0G00)

Remarks:

- To reduce the complexity we assumend that a booking only contains 1 passenger and 1 flight.
- We added a `Destination` class which serves as aggregator of airports and will help us in searching and displaying flights. 

### Business Logic

> 🚧: Todo
> 🚧: Describe the business logic for **at least one business service** in detail. If available, show the expected path and HTPP method. The remaining documentation of APIs shall be made available in the swagger endpoint. The default Swagger UI page is available at /swagger-ui.html.

Based on the UC-4, there will be two offers and a standard offer. Given a location, a message is shown accordingly:

- If the location is "Basel", the message is "10% off on all large pizzas!!!"
- If the location is "Brugg", the message is "two for the price of One on all small pizzas!!!"
- Otherwise, the message is "No special offer".

**Path**: [`/api/menu/?location="Basel"`] 

**Param**: `value="location"` Admitted value: "Basel","Brugg".

**Method:** `GET`

## Implementation

> 🚧: Todo
> 🚧: Briefly describe your technology stack, which apps were used and for what.

### Backend Technology

> 🚧: Todo
> 🚧: It is suggested to clone this repository, but you are free to start from fresh with a Spring Initializr. If so, describe if there are any changes to the PizzaRP e.g., different dependencies, versions & etc... Please, also describe how your database is set up. If you want a persistent or in-memory H2 database check [link](https://github.com/FHNW-INT/Pizzeria_Reference_Project/blob/main/pizza/src/main/resources/application.properties). If you have placeholder data to initialize at the app, you may use a variation of the method **initPlaceholderData()** available at [link](https://github.com/FHNW-INT/Pizzeria_Reference_Project/blob/main/pizza/src/main/java/ch/fhnw/pizza/PizzaApplication.java).

This Web application is relying on [Spring Boot](https://projects.spring.io/spring-boot) and the following dependencies:

- [Spring Boot](https://projects.spring.io/spring-boot)
- [Spring Data](https://projects.spring.io/spring-data)
- [Java Persistence API (JPA)](http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html)
- [H2 Database Engine](https://www.h2database.com)

To bootstrap the application, the [Spring Initializr](https://start.spring.io/) has been used.

Then, the following further dependencies have been added to the project `pom.xml`:

- DB:

  ```XML
  <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
  </dependency>
  ```

- SWAGGER:

  ```XML
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.3.0</version>
   </dependency>
  ```

### Frontend Technology

> 🚧: Todo
> 🚧: Describe your views and what APIs is used on which view. If you don't have access to the Internet Technology class Budibase environment(https://inttech.budibase.app/), please write to Devid on MS teams.

This Web application was developed using Budibase and it is available for preview at https://inttech.budibase.app/app/pizzeria. 

## Execution

> 🚧: Todo
> 🚧: Please describe how to execute your app and what configurations must be changed to run it. 

The codespace URL of this Repo is subject to change. Therefore, the Budibase PizzaRP webapp is not going to show any data in the view, when the URL is not updated or the codespace is offline. Follow these steps to start the webservice and reconnect the webapp to the new webservice url. 

> 🚧: This is a shortened description for example purposes. A complete tutorial will be provided in a dedicated lecture.

1. Clone PizzaRP in a new repository.
2. Start your codespace (see video guide at: [link](https://www.youtube.com/watch?v=_W9B7qc9lVc&ab_channel=GitHub))
3. Run the PizzaRP main available at PizzaApplication.java on your own codespace.
4. Set your app with a public port, see the guide at [link](https://docs.github.com/en/codespaces/developing-in-a-codespace/forwarding-ports-in-your-codespace).
5. Create an own Budibase app, you can export/import the existing Pizzeria app. Guide available at [link](https://docs.budibase.com/docs/export-and-import-apps).
6. Update the pizzeria URL in the datasource and publish your app.

## Project Management

> 🚧: Todo
> 🚧: Include all the participants and briefly describe each of their **individual** contribution and/or roles. Screenshots/descriptions of your Kanban board or similar project management tools are welcome.

### Roles

> 🚧: Todo

- Back-end developer: Charuta Pande 
- Front-end developer: Devid Montecchiari

### Milestones

> 🚧: Todo

1. **Analysis**: Scenario ideation, use case analysis and user story writing.
2. **Prototype Design**: Creation of wireframe and prototype.
3. **Domain Design**: Definition of domain model.
4. **Business Logic and API Design**: Definition of business logic and API.
5. **Data and API Implementation**: Implementation of data access and business logic layers, and API.
6. **Security and Frontend Implementation**: Integration of security framework and frontend realisation.
7. (optional) **Deployment**: Deployment of Web application on cloud infrastructure.

### Maintainer

> 🚧: Todo

- Charuta Pande
- Devid Montecchiari

### License

> 🚧: Todo

- [Apache License, Version 2.0](blob/master/LICENSE)
