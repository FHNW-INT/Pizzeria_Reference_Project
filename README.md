# Fly Around

[![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

FHNW - Internet Technology Project 2024  
Forked from the reference project:  [Pizzeria_Reference_Project](https://github.com/FHNW-INT/Pizzeria_Reference_Project)

Members:

- Franco D'Agostino -  <franco.dagostino@students.fhnw.ch>
- Christopher Court Rosa - <christopher.courtrosa@students.fhnw.ch>
- Fabian Stoll - <fabian.stoll@students.fhnw.ch>

> 🚧: **This is a template project**: Make sure you adapt this documentation and the source code in this project according to your needs and use case. Comments are provided with "🚧:". Do not leave these comments in your final submission!

## Contents

- [Fly Around](#fly-around)
  - [Contents](#contents)
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

> 🔍: To review

**Fly Around** is a small PoC project for the Internet Technology course at FHNW.
The project is about a simple web app to search for flights to cool destinations and create basic bookings.

The airline industry domain is wide, to keep the project simple we decided to limit the project scope to a minimal set of admin and user features which include for example: managing the flight schedule, searching flight by destination or interests, creating single passenger booking.

### User Stories

> 🚧: Todo

1. As an Admin, I want to have a Web app to use on different mobile devices and desktop computers.
2. As an Admin, I want to see a consistent visual appearance to navigate easily, and it should look consistent.
3. As an Admin, I want to use list views to explore and read my business data.
4. As an Admin, I want to use edit and create views to maintain my business data.
5. As an Admin, I want to log-in so that I can authenticate myself.
6. As a User, I want to use list views so that I can access public pages.
7. (Optional) As a User, I want to authenticate myself so that I can read my personal and confidential data.

### Use Case

> 🔍: To review

![use-case-diagram](https://www.plantuml.com/plantuml/png/TPJDQiCm48JlUeebHqD2VlfF24aiVCl5ngVIWx2sZeWZ1qa-bD9tRsKJixNbKrRC5p7iZBotJXZNN2jMuQS3LuDHvTc1L0OBfshDHE5g0mTvLVSvjsWOkudY8ag4fFewcBhH4huP0sWi5i8YpABeFO-NguyeWjYWS9xqLyz0M8YJCRhsQ8f2KZ0DW1iFvZSvk3CFe0yUvLZXVvG7q4UFdeGMvHs5h3YZR2fi_tDACiR0_y1siO0uWJVORfKkgaRYRaUaT5hAfoK-bCOMdyWoZtLzKRhijdaSiy_zDYcP1iWNiYFAycF0mYknmD4wfOLlIMU3Z_ZLihSnfDC0lIB93laymA-9zI7F0_o6P4nusmNCstnv5oyV1zKfwQIIJofyg8oj-QRslKDXYdDhAid-qAbUUINiwOSn_qfXFj_vTlHpIcPEvYHZxGjl3oTwQjUoHotzD-8N)


- **[UC01] Create Flight** - Admin can create flights.
- **[UC02] Read Flight** - Admin and user can create flights.
- **[UC03] Update Flight** - Admin can update flights.
- **[UC04] Delete Flight** - Admin can delete flights.
- **[UC05] Manage Flight Schedule** - Admin can use a dashboard to manage the flight schedule by creating, reading, updating, and deleteing flights.
- **[UC06] Create Booking** - User can create bookings.
- **[UC07] Read Booking** - User can read his/her own bookings.
- **[UC08] Delete Booking** - User can delete his/her own bookings.
- **[UC09] Create Destination** - Admin can create destinations.
- **[UC10] Read Destination** - Admin and user can read destinations.
- **[UC11] Update Destination** - Admin can update destinations.
- **[UC12] Delete Destination** - Admin can delete destinations.
- **[UC13] Manage Destinations** - Admin can use a dashboard to manage the destinations database by creating, reading, updating, and deleting destinations.
- **[UC14] Flight Search** - User can search flights by flight details (e.g. flight number and date) or by destination details (e.g. activity, or city). The result is presented with a list view which includes flight.

Remarks and assumptions:

- Once a booking is made, it is not possible to update it anymore, it can only be deleted.
- User doesn't have a dashboard with all his/her bookings. Each booking is accessed individually with the pair lastname and booking ID.
- For simplicity, we assumend that the admin cannot access or manage the user bookings.
  
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

![class-diagram](https://www.plantuml.com/plantuml/png/XLF1Yjim4BtxAuIFXOJs6af8sr08b59eVs1gZnqHMJAZoLwM_VSTAOgbQBFPc_JUqyoyD_RECn2V9zDq1hnNFuqUZwoU6wLqhpRgbxEZd8S8xz7hqG8x4kOlauvSZtCeGVXDq-o8XKid8O58Fu6vG-Lt__I4mko1up6_kaDewWY6M2WT1Vtlt4bcyM5UxVdhztJVDYzDaunTvSdQugm3OuAhqj7aUZGbu14uL3zOnX5f2MJfU8bD-gLsoMOLf9ABXGdBqXeOVhZ-5kl0rLYFdhK5riw6IFAjJBAU9qTP4pcOibIrzZni7g8ZFGTj2JFax7q4O-TB10kJ8YbxfqL9IiLAkYDsfuELhTykVvONQ2L-GVzSpqtQX60NQxbw5jKx7pHv_brvC_0MmmcqAO77NrfogDelhLgjLFjvlVxKfhdanK1kKjkFLEn44s-LP4bh4yV0NWsEr5OrsUSZlPUonQwJg93dV_G8GPp-c7S7TJCIC0Rf3cr_dimh)

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
> 🚧: Describe your views and what APIs is used on which view. If you don't have access to the Internet Technology class Budibase environment (https://inttech.budibase.app/), please write to Devid on MS teams.

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

- Back-end developer: Franco D'Gostino
- Front-end developer: Christopher Court Rosa
- Business Analyst: Fabian Stoll

### Milestones

> 🚧: Todo: create a board on github

1. **Analysis**: Scenario ideation, use case analysis and user story writing.
2. **Prototype Design**: Creation of wireframe and prototype.
3. **Domain Design**: Definition of domain model.
4. **Business Logic and API Design**: Definition of business logic and API.
5. **Data and API Implementation**: Implementation of data access and business logic layers, and API.
6. **Security and Frontend Implementation**: Integration of security framework and frontend realisation.
7. (optional) **Deployment**: Deployment of Web application on cloud infrastructure.

### Maintainer

- Franco D'Agostino -  <franco.dagostino@students.fhnw.ch>
- Christopher Court Rosa - <christopher.courtrosa@students.fhnw.ch>
- Fabian Stoll - <fabian.stoll@students.fhnw.ch>

### License

- [Apache License, Version 2.0](blob/master/LICENSE)
