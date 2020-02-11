# Estefanie's Individual Project Poke Habits

This repository will serve as an example for Madison College's Enterprise Java Class. 

### Problem Statement

This application will help you meet your lifestyle goals using Pokemon!
This application will have have a fun twist on creating healthy habits from 
drinking water, getting enough sleep, exercising and more. It can be difficult to track
your habits or find easy ways to develop new habits. This application will help you 
have fun while developing healthy life choices. When you achieve 
a goal you get rewarded with a pokemon. After improving over time you can 
evolve your pokemon!

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: create goals, track habits, collect pokemon 
  * All: Users must be authenticated, all have access to basic home page
* Database
  * MySQL
  * Store users and roles
  * Store all data for the trails and reports
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* CSS 
  * Bootstrap 
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Poke API
  * Hibernate Validation
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA


### Design

* [User Stories](designDocuments/userStories.md)
* [Screen Design](designDocuments/Screens.md)

### [Project Plan](ProjectPlan.md)

### [Weekly Refelection](timeLog.md)