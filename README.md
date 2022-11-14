<p align="center">
  <img src="https://user-images.githubusercontent.com/104069112/201516383-6939ff92-784d-4683-b623-ec20d7d7fad7.gif" width="160" alt="animated" />
</p>
          
 <p align="center">              
- Exotic Cab Service Pvt.Ltd-
  <p/>
  
 #  Online Cab Booking System
This application is developed as a part of an Assignment for Web Application Development. It is a REST API for an Online Cab Booking. This API performs all the fundamental CRUD operations of any Online Cab Booking platform with user validation at every step.




### Technical Stacks

- Spring Boot 
- Spring Framework
- Spring Data JPA 
- MySQL 
- Hibernate
- Java
- Swagger UI
- Postman


### Modules
-  Login Module
-	Admin Module
-	Customer Module
-	Driver Management Module
-	Cab Management Module
-	Booking Management Module

### Features
- Customer, Driver and Admin authentication & validation with session uuid having
* Admin Features :-
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete driver or customer from main database
    * Admin can access the details of different customers, drivers and trip bookings
* Customer Features :-
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available cabs and booking a trip
    * Only logged in user can access his trip history, profile updation and other features    
* Cab Driver Features :-
    * Cab Driver can login in the application and update their information using their username and password
    * Cab driver can add and update their cab details
    * Cab Driver can mark their availability according to the trips status
    * Cab Driver can end the trip and application generates a bill for the trip

##   ER_Diagram                                            
![ER_Diagram](https://user-images.githubusercontent.com/104069112/201485913-289d5d89-fe19-4123-8852-6f0773aa9637.png)

### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
````
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/cabdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
    
````
## API Root Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui.html`


## API Module Endpoints

### Admin Module

* `POST /login` : Admin can login with username  and password provided at the time of registation
* `POST /insert/{key}` : Register a new admin with proper data validation and admin session
* `PUT /update/{key}` : Updates admin details
* `DELETE /delete/{id}` : Deletes the admin with passed id
* `GET /trips/{key}` : Get list of trips of all the trips
* `GET /tripsByCab/{type}` : Get list of trips by cab types
* `GET /tripsByDate/{date}` : Get list of trips by date
* `GET /tripsByCustomer/{id}` : Get list of all the customers trips by customer id
* `GET /tripsByCustomer/{id}/{date}` : Get list of all trips for the day by id and date


### Customer Module


* `POST /save` : Adding new customer
* `PUT /update` : Updates customer details 
* `DELETE /delete/{id}` : Deletes logged in user on the basis of id
* `GET /customer/{id}` : Getting customer on the basis of id
* `POST /validateCustome` : Checks valid coustomer


### Driver Module

* `POST /driver` : Register a new driver with proper data validation and admin session
* `PUT /driver` : Updates the driver details
* `DELETE /driver/{driverId}` : Deletes driver on the basis of id
* `GET /drivers` : Gets the best driver whose rating is over 4.5
* `GET /driver/{id}` : Get driver details by id
* `GET /listOfDrivers/{id}` : Gets list of all the drivers

### Cab Module

* `POST /cab` : Register a new cab 
* `PUT /cab` : Updates the cab details
* `DELETE /cab/{cId}` : Delete cab on the basis of cab id
* `GET /cabs/{carType}` : Gets the list of cabs on the basis of cab type
* `GET /countofcabs/{carType}` : Gets the total number of cabs on the basis of cab type

### Book a Trip


![Screenshot (793)](https://user-images.githubusercontent.com/104069112/201608930-22b7f222-9723-40a2-b3dc-c76b4a95e542.png)


#### This project is developed by team of 5 Back-End Developers during project week at Masai School
### Contributors

- [@Prateek Chauhan](https://github.com/PRA3EEK)
- [@Shreyas Vilas Medade](https://github.com/medadeshreyas)
- [@Ujjawal Prakash](https://github.com/ujjawalyt)
- [@Namdev Patil](https://github.com/namdevmanoharpatil)
- [@Sabira Farooq](https://github.com/Sab01123)
#### For any feedback, report, suggestions, you can contact with anyone of the team member
### THANK YOU
