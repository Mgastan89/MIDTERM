
# CrossFitX Application

## Table of Contents

1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Database Schema](#database-schema)
4. [Setup Instructions](#setup-instructions)
5. [API Endpoints](#api-endpoints)
6. [Usage](#usage)
7. [Testing](#testing)
8. [Deployment](#deployment)
9. [Future Enhancements](#future-enhancements)
10. [Contributing](#contributing)
11. [License](#license)
12. [Contact](#contact)

## Introduction

The CrossFit application is designed to manage CrossFit activities, coaches, teams, and participants. This application provides a RESTful API for managing data the CrossFitX Competition Program, allowing users to perform CRUD operations on various entities.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (for testing)
- MySQL (for production)
- JUnit 5
- Maven

## Database Schema

The database schema consists of the following tables:

- **activity**: Stores different types of activities.
- **coach**: Stores information about coaches.
- **team**: Stores information about teams.
- **userParticipant**: Stores information about participants.

### Schema Representation

```sql
CREATE TABLE activity (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE coach (
  id INT AUTO_INCREMENT PRIMARY KEY,
  employee_number INT NOT NULL UNIQUE,
  activity_id INT,
  FOREIGN KEY (activity_id) REFERENCES activity(id),
  isTeamLead BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE team (
  id INT AUTO_INCREMENT PRIMARY KEY,
  country_name VARCHAR(255) NOT NULL,
  teamLead_id INT NOT NULL,
  FOREIGN KEY (teamLead_id) REFERENCES coach(id)
);

CREATE TABLE userParticipant (
  id INT AUTO_INCREMENT PRIMARY KEY,
  password VARCHAR(255),
  email VARCHAR(255),
  user_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES team(id)
);

#### Setup Instructions 

Prerequisites

- Java 17 or higher
- Maven
- MySQL

Steps to follow:
- Clone the repo
- Setup the MySQL databases
- Populate initial data
- Build the application

##### API Endpoints

The application exposes the following API endpoints for the various entities.

Activity Endpoints
GET /api/activities: Get all activities
GET /api/activities/{id}: Get activity by ID
POST /api/activities: Create a new activity
PUT /api/activities/{id}: Update an existing activity
DELETE /api/activities/{id}: Delete an activity
Coach Endpoints
GET /api/coaches: Get all coaches
GET /api/coaches/{id}: Get coach by ID
POST /api/coaches: Create a new coach
PUT /api/coaches/{id}: Update an existing coach
DELETE /api/coaches/{id}: Delete a coach
Team Endpoints
GET /api/teams: Get all teams
GET /api/teams/{id}: Get team by ID
POST /api/teams: Create a new team
PUT /api/teams/{id}: Update an existing team
DELETE /api/teams/{id}: Delete a team
UserParticipant Endpoints
GET /api/userParticipants: Get all user participants
GET /api/userParticipants/{id}: Get user participant by ID
POST /api/userParticipants: Create a new user participant
PUT /api/userParticipants/{id}: Update an existing user participant
DELETE /api/userParticipants/{id}: Delete a user participant


###### Usage

Use tools like Postman to interact with the API endpoints.


####### Testing

Run tests Using Maven inorder to make sure the application works as expected.

######## Deployment

Instructions to deploy the application in production environments.I will add steps to deploy to cloud provider or local server upon completion.

######### Future Enhancements

- Add user authentication and authorization.
- Implement more comprehensive erros handling procedures.
- Enhance UI/UX with a frontend framework.
- Add more detailed analytics and reporting features.

########## Contributing

- Contributions are welcome! please fork the repository and submit pull requests for any new features, bug fixes, or enhancements.

########### License

- This project is licensed under the MIT license.

############ Contact

For any questions or support, please contact Mgdagher19@gmail.com


