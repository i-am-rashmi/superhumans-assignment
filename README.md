#SuperHumans-Assignment
Rest service that adds and searches movie names. 

##Configurations
Database used : MongoDb
Database name : superhuman
Port : 8084

##APIS
1. Endpoint:/movies
   Method: POST
   Sample-Request: 
   {
    "movie":"The Imitation Game"
   }
   Response: 201 created

2. Endpoint:/movies/search/{prefix}/{limit}
   Method: GET
   Sample-Request:/movies/search/the/1
   Response: 200 OK 
   [
    {
        "movie":"The Imitation Game"
    }
   ]