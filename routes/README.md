Java Spring Boot application demo with RESTful routing
- Defines dummy Graph data type (Game.java)
- Defines RESTful routes "/games" (GameController.java)
- DemoApplication.java to start Spring Application

Run locally, URL for game is localhost:8080/games

Get list of games in JSON format by sending get request:

	curl -v localhost:8080/games
	
Create/update/delete game by POST/PUT/DELETE request (I made these from Postman, didn't get the HTTP Request header 'Content-Type: application/json' working with curl command.

