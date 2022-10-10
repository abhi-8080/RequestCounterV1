# Getting Started

This application is a simple REST based counter , built in Spring boot and Kotlin. 
On every GET request to the webserver a number in the response body will increase with one for every request.
The webservice will log the number sent in the response for every request. The log will be written to std
out in numerical order

## Requirements

For building and running the application you need:
- JDK 17
- Docker compose
- Apache workbench

## Building the application locally
For building the application run the mvn wrapper command, from project root, to create a runnable jar:

```shell
.\mvnw clean install
```
## Running the application on local Docker
The easiest way to deploy the sample application on docker locally is to run:

```shell
docker-compose up --build
```

You can then make a call to application from browser [http://localhost:8080/count](http://localhost:8080/count)

To generate load you can use the following apache workbench request:

```shell
.\ab -n10 -c10 http://localhost:8080/count
```

## Troubleshooting
In case docker container does not start, check the container logs. 
Verify there are no port clashes. If required make changes in `docker-compose.yml` to set the correct host port.

## Updating releases
To keep dependencies updated at all times use the following maven commands
```shell
.\mvnw versions:update-parent 
.\mvnw versions:use-latest-releases  
```
