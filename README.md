# springbootRestJspApp

### Quick description
* This is Spring boot application that use MySQL for storing data and Java Servlet Page (JSP) for presentation. Although it is not used Spring boot Security, admin part of application is still secured using Session (after every unauthorised request application redirect to login page).
* This is simple application with simple CRUD operations.
* The purpose of this application is to show how to use spring boot and JSP togeder.
* Also, this is Single page aplication (SPA) – although the application has several different views, there are only two html pages in which JSP code is embedded.

### Used thechnologies
* Spring boot,
* JSP,
* JPA (Hibernate),
* MySQL.

### Database manegement system
* MySQL for storing data.
* In application.properties file are defined credential values for datasource url, username and password.

###  Models – Entities
* There are one entity (Korisnik). This entity is annotated with @Entity and has No-args-constructor method, With-args-constructor method, Get and Set methods and ToString method. Also, in this entity is used next annotations: @Id and @GeneratedValue.

### Entities relations
* There are no entity relations in this small application.

### Repository
* For Korisnik entity threre is 1 interfaces that extends CrudRepository class (KorisnikDAO). These interface is annotated with @Repository annotation. Gist for this repositories is to communicate with database.

### Controllers
* There is 1 Controller (AppController). This controller communicate with database through Service. This controller is annotated with @Controller annotation and also are used next annotatioins: @RequestMapping, @ModelAttribute, @RequestParam.

### Services
* For 1 entity there is 1 Service class (KorisnikService). Thise class is annotated with @Service annotations. Gist for thise service is to make easy communication with database through mentioned repository.

### View – styling
* For styling html files used custom and pure css file (no bootstpap)

### Application executable
* JAR file

### Security
* Custom security through Session – not used Spring boot Security

### Introduction for cloning
* *git clone* https://github.com/milberonja/springbootCRUDJspApp.git
* In your MySQL or another Database manegement system create database with name sampledb
* In application.properties file change username and password (type your credential data for these fields)
