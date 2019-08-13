# Stwitter-Service

This service is run on localhost:8080

## Approach:

This is the client-facing micro service for Post and Comment microservices. The service layer presents a post view model that has 
List<String> comments. 

Posts can be created, fetched by id and fetched by poster name. At the time of creation posts do not have any comments on them.
When posts are retrieved, their corresponding comments(strings) are fetched as well.

Comments can be created separately.

## Design:


### The stwitter service:

 - Uses Spring Cloud Config Server
 - Registered with Eureka Service Registry
 - Uses Feign for to send the generated comments to stwitter edge service
 - Uses Cache for quick retrieval of data
 - User JSR303 validation
  
 ### Has following end points:
 
 * localhost:8080/posts - for creating posts
 * localhost:8080/posts/{post_id} - for getting posts with the specific id and the corresponding comment strings
 * localhost:8080/posts/user/{poster_name} - for getting posts with the specific poster name and the corresponding comment strings
 * localhost:8080/comments - for creating comments 
 
 
 ===============
 
 Post:
int: post ID
String: post content
LocalDate: post date
String: poster name
List<String>: comments

Comment:
int: comment ID
int: post id
String: commenter name
LocalDate: comment date
String: comment content
