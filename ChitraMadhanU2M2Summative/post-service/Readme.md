# Post-Service

This service is run on localhost:1777

## Approach:

This microservice is responsible for Post CRUD functionality. 

## Design:


### The post service:

 - has MySql for data base.
 - Uses Spring Cloud Config Server
 - Registered with Eureka Service Registry
 - Uses Feign for Edge Services
 
 ### Has following end points:
 
 * localhost:1777/posts - for creating posts
 *  localhost:1777/posts - for getting all the posts
 * localhost:1777/posts/{post_id} - for getting posts with id
 * localhost:1777/posts/user/{poster_name} for getting posts by user
 *  localhost:1777/posts/{post_id} - for updating a post
  localhost:1777/posts/{post_id} - for deleting a post with the given id
  
  ================================
 
 create schema if not exists post;
use post;

create table if not exists post (
	post_id int not null auto_increment primary key,
    post_date date not null,
    poster_name varchar(50) not null,
    post varchar(255)
);
