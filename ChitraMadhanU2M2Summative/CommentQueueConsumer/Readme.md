# Comment-Queue-Consumer

This is a RabbitMQ queue service that cosumes comments.
This uses feign to send comments to the create comment end point of comment-service.

Queue Name: comment-queue

Exchange Name: comment-exchange

Routing Key: comment.create.#
