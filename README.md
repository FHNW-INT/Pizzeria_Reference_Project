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
    - [Design](#design-1)
    - [Wireframe](#wireframe)
    - [Prototype](#prototype)
    - [Domain Design](#domain-design)
    - [Backend Architecture](#backend-architecture)
    - [Business Logic](#business-logic)
  - [Implementation](#implementation)
    - [Backend Technology](#backend-technology)
    - [Frontend Technology](#frontend-technology)
  - [Project Management](#project-management)
    - [Roles](#roles)
    - [Milestones](#milestones)
    - [Maintainer](#maintainer)
    - [License](#license)

## Analysis

### Scenario

**Fly Around** is a small PoC project for the Internet Technology course at FHNW.
The project is about a simple web app to search for flights to cool destinations and create basic bookings.

The airline industry domain is wide, to keep the project simple we decided to limit the project scope to a minimal set of admin and user features which include for example: managing the flight schedule, searching flight by destination or interests, creating single passenger booking.

### User Stories


1. As an Admin, I want to have a Web app to use on different mobile devices and desktop computers.
2. As an Admin, I want to see a consistent visual appearance to navigate easily, and it should look consistent.
3. As an Admin, I want to use list views to explore and read my flights.
4. As an Admin, I want to use edit and create views to maintain my flights.
5. As an Admin, I want to log-in so that I can authenticate myself.
6. As a User, I want to use list views so that I can access public pages and search flights.
7. As a User, I want to authenticate myself so that I can view my bookings.

### Use Case


![use-case-diagram](https://www.plantuml.com/plantuml/png/TTBDQeD040Vm-pp5aAEGqE-F8fAeUCl5uAdqiEnETSbcDwphePI-UrsBOHlrvCZy79m_isqTiwuxAL3qwT0PjB9k70ffYJjfD33kZCMTECcnhbgo06V6ZwmcBDJNpffE2_m6GEnQugmbN4NHUvNTt7v44MQMcFFIZruXQp4hflJEqvAO264v0-yzhCxYQcOrGnyypKdHVvhFq4TFzqopUgHuu0s9Jj7mpRuu0A1_OBpPz1lW6yQnr5nrWf8aQ9NBhMgvbL-rPi9y2i9CZJbANV-bcKxjyoNDK9OpyYN8ABHv2Z3LhrwF-H2pl1bm7mxYqlxm0-2F1jVhnF_ifIw3EW_gVjfmSCEB3tvBMlH7-Wi0)


- **[UC01] Create Flight** - Admin can create flights.
- **[UC02] Read Flight** - Admin and user can create flights.
- ~~**[UC03] Update Flight** - Admin can update flights.~~
- **[UC04] Delete Flight** - Admin can delete flights.
- **[UC05] Manage Flight Schedule** - Admin can use a dashboard to manage the flight schedule by creating, reading, ~~updating~~, and deleteing flights.
- **[UC06] Create Booking** - User can create bookings.
- **[UC07] Read Booking** - User can read his/her own bookings.
- **[UC08] Delete Booking** - User can delete his/her own bookings.
- **[UC09] Flight Search** - User can search flights by flight details (e.g. flight number and date) or by destination details (e.g. activity, or city). The result is presented with a list view which includes flight.

Remarks and assumptions:

- Once a booking is made, it is not possible to update it anymore, it can only be deleted.
- User doesn't have a dashboard with all his/her bookings. Each booking is accessed individually with the pair lastname and booking ID.
- For simplicity, we assumend that the admin cannot access or manage the user bookings.
  
## Design

### Design

For our web app, we will adopt a simple, clean, and modern design. The goal is to create a user-friendly interface that is visually appealing and easy to navigate. We will use a minimalist approach, focusing on clear typography, ample white space, and intuitive user interactions. The color palette will be carefully chosen to create a harmonious and professional look. Our design will prioritize functionality and usability, ensuring that users can easily access the desired features and information. By adopting a modern design, we aim to provide a seamless and enjoyable user experience. 

### Wireframe

This wireframe design represents the initial idea for the user interface of our web app. It showcases the layout and structure we envision for the different pages and components.

![design1](/images/design1.png)
![design1](/images/design2.png)

### Prototype



![design1](/images/home-search.png)

### Domain Design

The `ch.fhnw.flyaround.data.domain` package contains the following domain objects / entities including getters and setters:

![class-diagram](https://www.plantuml.com/plantuml/png/XLF1IiD04BtlLomv2YrwBHAgLa4G4VG7nkma7Phibjcf5-c_EqatRbEBlSsyDpkyzoPPHW6MNTUQgeKOxLDBpLhijx6Md5tOb-0RhUi1Nc6aneC4LkPTc0REuRPVmNX7l0qiogLAIM2cBsZFKFdT1tMep0faAFEhCmHnnL2dHKEfw6S86zKIUxqKvVO-zQNP6vECZGecpgms7ZeyjaCWy13S5AiWd68Eev07eU1xZRaxjlOhwP1hcRsT4ljHQ1BV2oKt7g1QOxLvzfh4D93a_0opYyYF7L1xf7ch-z4to8gzZRL9nrNieCNarF9KoYr_4CHHNa-YQ-4lXXCD5uyrdgcuAUniPelh-VogICBqHSsXi-MbAGawaxhfo1ZkOf21pjQ1RMbDzldVVDIrPedUwV_o0m00)

Remarks:

- To reduce the complexity we assumend that a booking only contains 1 passenger and 1 flight.

### Backend Architecture

The following digram shows the high level architecture of the backend components.

![architecture diagram](https://www.plantuml.com/plantuml/png/TP11Jm9138NlyoiQJdhW3tWmBE0cdZIkD_KmsIqmSRQTT0gH6Fwxb04NY1xdVQ-lhpF9waNNVNJvCr3oudjekKzCIDheDY88jkff6T6v1SSE1KOlc3W7PTcEuDi1lDKnB5Swo1_WCzJsDbe5IIpNk3hXEMODv3KmNLdc1yjkMDoWR4AB5rkRTeNTEkAHbTNDfZN7b7b_rl8SJGtjt90vOrBX657-Z1rmIPwfnBFeApmr39OVI54MliNzTpqqhr0zF-PtkZcEtOuExYg5_uobHJxLA0Er3RZXbs0ylY_7NchbIcV4diVM9XPwUBfIrWGh0dU0NuapklfNhozqHwm8Ohs05oVuH74BLTS7SXEaRjt77m00)



### Business Logic

Based on the [UC09] Flight Search, the app will offer the option to search flights based on date, departure airport and arrival airport.

**Path**: [`/flights/search?departureAirportIataCode=&arrivalAirportIataCode=&flightDate`] 

**Param**: `departureAirportIataCode` Admitted value: IATA code for the airport stored in the DB.
**Param**: `arrivalAirportIataCode` Admitted value: IATA code for the airport stored in the DB.
**Param**: `flightDate` Admitted value: date.

**Method:** `GET`

## Implementation

### Backend Technology

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

- OTHER

  ```XML
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
  <dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>2.4.4</version>
  </dependency>
  ```

### Frontend Technology

This Web application was developed using Budibase and it is available for preview at https://flyaround.budibase.app/app/flyaound.


### Deployment to a PaaS
> 🚧: Deployment to PaaS is optional but recommended as it will make your application (backend) accessible without server restart and through a unique, constantly available link.  

Alternatively, you can deploy your application to a free PaaS like [Render](https://dashboard.render.com/register).
1. Refer to the Dockerfile inside the application root (FHNW-INT/Pizzeria_Reference_Project/pizza).
2. Adapt line 13 to the name of your jar file. The jar name should be derived from the details in the pom.xml as follows:<br>
`{artifactId}-{version}.jar` 
2. Login to Render using your GitHub credentials.
3. Create a new Web Service and choose Build and deploy from a Git repository.
4. Enter the link to your (public) GitHub repository and click Continue.
5. Enter the Root Directory (name of the folder where pom.xml resides).
6. Choose the Instance Type as Free/Hobby. All other details are default.
7. Click on Create Web Service. Your app will undergo automatic build and deployment. Monitor the logs to view the progress or error messages. The entire process of Build+Deploy might take several minutes.
8. After successful deployment, you can access your backend using the generated unique URL (visible on top left under the name of your web service).
9. This unique URL will remain unchanged as long as your web service is deployed on Render. You can now integrate it in Budibase to make API calls to your custom endpoints.

## Project Management

### Roles

- Back-end developer: Franco D'Gostino
- Front-end developer: Christopher Court Rosa
- Business Analyst: Fabian Stoll

### Milestones


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
