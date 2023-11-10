# Taxi service 🚖
This is a **Taxi Service** project with a user-friendly ui interface and awesome functionality 

# Features
- Comfortable and simple management of cars, drivers and manufacturers
- Strong authentication system
- Fast and optimized application performance
- Smart site navigation

# How to run
- `git clone https://github.com/s-hrynus/taxi-service.git`
- `cd taxi-service`
- `mvn clean && mvn install`
- `mv target/taxi-service-1.0-SNAPSHOT.war /path/to/tomcat/webapps`
- Run tomcat and enjoy __Taxi Service__

#### Or
You can configure and run tomcat from intellij idea ultimate

# Structure
- Login page - `/login` - simple login page
- Main page - `/cars` - machine and manufacturer management
- All Drivers - `/drivers` - all drivers management
- My Drivers - `/drivers/my` - current driver's cars
- Add Driver - `/drivers/add` - add driver
- Car drivers - `/car/drivers?carId={id}` - management of drivers of the current car

# Used technologies
- java: 11
- tomcat: 9.0.73
- mysql-connector-java: 8.0.22
- javax.servlet-api: 4.0.1
- jstl: 1.2
