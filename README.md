The business idea is to create a platform that not only provides information about people and their hobbies but also offers a matchmaking service. Users can input their hobbies and interests, and the platform can connect them with like-minded individuals or groups in their local area. This would add a social networking element to the service and encourage people to explore new hobbies together, fostering real-world connections.

JPA
JPQL
Java Streams API
Java Generics
Maven
JDK 17^
JUnit 5
Docker
PostgresSQL
pgAdmin
Lombok


[US-1] As a user I want to get all the information about a person
[US-2] As a user I want to get all phone numbers from a given person
[US-8] As a user I want to get all the information about a person (address, hobbies etc.) given a phone number
[US-10] As a user I want to see all people on an address with a count on how many hobbies each person has (Use Java Streams for this one)
(Satisfied in UserInfoDAO) - [US-11] … Add more meaningful services of your own choice - mostly here


[US-3] As a user I want to get all persons with a given hobby
[US-4] As a user I want to get the number of people with a given hobby
[US-5] As a user I want to get a list all hobbies + a count of how many are interested in each hobby
(Satisfied in HobbyDAO)

[US-6] As a user I want to get all persons living in a given city (i.e. 2800 Lyngby)
[US-7] As a user I want to get a list of all postcodes and city names in Denmark
(Satisfeid in ZipcodeDAO)

[US-9] - satisfied by methods in genericDAO implemented in all other DAO classes.
Create and Update: The save method can handle both creating a new entity and updating an existing one.
Read: findById and findAll provide capabilities to read single entities by their ID or to retrieve all entities of a given type, respectively.
Delete: delete and deleteById allow for removing entities either by passing the entity itself or by its ID.


# HoppyProject
