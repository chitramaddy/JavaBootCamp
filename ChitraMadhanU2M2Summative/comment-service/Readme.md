# Comment-Service

This service is run on localhost:6868

## Approach:

This microservice is responsible for Comment CRUD functionality. 

## Design:


### The comment service:

 - has MySql for data base.
 - Uses Spring Cloud Config Server
 - Registered with Eureka Service Registry
 - is a comment queue producer. Sends the comment using the comment-queue
 - Uses Feign for to send the generated comments to stwitter edge service
 
 
 ### Has following end points:
 
 * localhost:6868/comments - for creating comments
 * localhost:6868/comments - for getting all the comments
 * localhost:6868/comments/{comment_id} - for getting comments with the given id
 * localhost:1777/comments/post/{postId} for getting comments by postId
 * localhost:6868/comments/{comment_id} - for updating comments with the given id
 * localhost:6868/comments/{comment_id} - for deleting comments with the given id 
  
  ================================
 
create schema if not exists comment;
use comment;

create table if not exists comment (
	comment_id int not null auto_increment primary key,
    post_id int not null,
    create_date date not null,
    commenter_name varchar(50) not null,
    comment varchar(255)
);
