# RESTful API Exception Handling

RESTful application to test exception handling practice.

This java web application follows JAX-RS API (implemented with [RESTEasy](http://resteasy.jboss.org/)) to provide RESTful endpoints.

The goal here is to practice server exception handling and how to build a meaningful response to the client.  
This is also an attempt to follow best practices of RESTful API design as well since it goes hand in hand with exception handling.

Please contribute with anything you think would turn this application into a better practice.

## Pre-requisites

* Java server application with 3.1 servlet spec (like [Tomcat 8](http://tomcat.apache.org/)).

**Unless explicitly told otherwise, all comands shown here are supposed to be run at the project's root folder.**

## Dev Environment Setup

* Run `gradlew build`;
* If using [Eclipse](https://eclipse.org/), run `gradlew eclipse` to generate wtp configuration.

To test REST services I recommend using [Postman](https://www.getpostman.com/).

# Using the web application

## Success responses

A sample success response can be fetched at `GET /api/entities01`.  
The response has a `200` http status code and the body (`application/json`) contains the data fetched.

## Business logic exception responses

A sample business logic exception can be fetched at `DELETE /api/entities01/{id}`.  
The response has a `400` (`bad request`) http status code and the body (`application/json`) contains more information about the exception (`stackTrace`), including a friendly message to the user (`message`).

There is a lot of discussion about what http status code best represents a business logic error.  
In my opinion all business exceptions boils down to a more meaningful http status code but the client will most likely ignore the code and only care about the user message.  
So adding status code mapping to the developer doesn't seem to pay off.

When there's a specific exception that the client could actually do something other than just showing a message to the user, a specific http status code could help there.  
For example `402` (`Unauthorized`) could be used by the client to redirect to a login page.

The client needs to be careful since it's possible to receive a `4XX` generated outside server exception handling and it wouldn't have the excepted information.

Please contribute to this discussion if you have a different approach on http status code usage so this aplication can turn into a better practice.

## Unexpected server exception responses

A sample unexpected server exception can be fetcher at `POST /api/entities01`. It expects to receive a JSON (`application/json`) containing the attributes of an entity.  
Example:  
```json
{
"description": "Test 01"
}
```

The response has a `500` (`Internal Server Error`) http status code and the body (`application/json`) contains more information about the exception (`stackTrace`) and a code (`id`) that can be presented to the user for better exception report and tracking.

The client needs to be careful since it's possible to receive a `5XX` generated outside server exception handling and it wouldn't have the excepted information.
