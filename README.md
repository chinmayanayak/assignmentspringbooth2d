It contain two controllers
1. Person
2. Address

Operations:

GET,POST,DELETE,PUT

You can hit those endpoints using postman .

Link for downloading postman :
Download the postman from link : https://www.postman.com/downloads/

Choose the machine architecture whether it's 32 bit or 64 it based on that download the
postman.

Open postman - create a free id or login using google id.

Steps to post a request:

1. Create a request .

2. Choose operation type - GET,POST,PUT,DELETE

3. In Headers add content type application/json

For example :

GET http://localhost:8080/person/1 - try to get the detail of person with pid 1

Create a New Person :

POST http://localhost:8080/person

body (raw - tpe JSON)

In body of request sample :


{
    "pid" : 1,
    "firstName" : "Hello ",
    "lastName" : "World"
}

you will get a response with status 201 created:

{
    "pid": 2,
    "firstName": "Hello ",
    "lastName": "World",
    "address": null
}

