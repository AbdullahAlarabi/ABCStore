# ABC Store Receipt

RESTful API to Calculate the total amount of the purchased items in addition to the discount amount. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the softwares and tools

```
Java jdk 1.8 
Eclipse Java ee 
Spring Boot 2.1.7
Spring Tool Suite (plugin)
MySQL DataBase 8.0
```

## Running the tests

Once you open the project there is a class with name AbcStoreApplication.Java ,
Just run it as (Spring Boot Application) you'll see the console log indicates that the app is running on embedded tomcat server,
Also you'll see that the Hibernate create the tables and relations between them if you have local MySql DB with schema name (abc_store).

Then you can open the Swagger UI on the following path : http://localhost:8080/swagger-ui.html# .

## Deployment

You need to packaging your app as war on maven file add <packaging>war</packaging>
then clean and update the maven project, finally deploy the war file into a tomcat server. 

## Built With

* [Spring](http://https://spring.io) - Spring Boot framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [Sawgger](https://swagger.io/) - API Documentation

## Authors

* **Abdullah Areedh** - *Initial work* - [AbdullahAlarabi](https://github.com/AbdullahAlarabi)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* You can use the app as any store type for discount feature.
