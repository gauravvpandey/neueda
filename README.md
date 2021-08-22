# Neueda Home Assignment

The project is created using jdk 8.

install.ps1 -> Run this script in power shell. This will do the following

a) Build all the services.

b) Use docker-compose to build images using project's dockerfile and bring the corresponding services up in individual containers.


**Tinyurl service:**

Tinyurl: This service provides following end-points

a) Create Tinyurl [POST] -> http://localhost:9001/tinyurl/create
	
	1. JSON Request Body:
	
	{
		"normalUrl" : "https://www.google.com/search?q=neueda+technologies&sxsrf=ALeKk009OmgZT-FyauyoyCzjYMtqEj3Q6w%3A1629457364852&source=hp&ei=1IsfYfHOMdes5OUPh5-MuAE&iflsig=AINFCbYAAAAAYR-Z5Mw_fmWm0EqpdhQfEpQVTkiBqvuh&gs_ssp=eJzj4tVP1zc0TDcyyCkvLEoxYLRSNagwsTBNNrE0MDCwNDW3SDZLsTKoSLIwMbBIMbY0Mbc0MkuxSPQSzkstTU1JVChJTc7Iy8_JT89MLQYAC0MWKQ&oq=neueda+te&gs_lcp=Cgdnd3Mtd2l6EAEYADIOCC4QgAQQxwEQrwEQkwIyBQgAEIAEMgYIABAWEB4yCQgAEMkDEBYQHjoHCCMQ6gIQJzoECCMQJzoLCAAQgAQQsQMQgwE6CAgAEIAEELEDOhEILhCABBCxAxCDARDHARDRAzoICAAQsQMQgwE6CAguEIAEELEDOg4ILhCxAxCDARDHARDRAzoOCC4QgAQQsQMQgwEQkwI6CwguEIAEEMcBEK8BOgUILhCABDoHCAAQgAQQCjoKCC4QxwEQrwEQJzoGCAAQBxAeUPInWMCPAWChoQFoAXAAeACAAZcBiAGLCZIBAzAuOZgBAKABAbABCg&sclient=gws-wiz",
		"user" : "gaurav"
	}

	2. Expected Response: Status 200 OK and response body will contain tinyurl for example: http://localhost:9001/tinyurl/b02d3f5b
  
b) Redirection [GET] -> http://localhost:9001/tinyurl/{id} 
	
	1. Example: http://localhost:9001/tinyurl/b02d3f5b

	2. Expected Response: Neueda Technologies will be shown in google search.

c) User Statistics [GET] -> http://localhost:9001/statistics/users 

	1. Expected Response: 
		{
			"User 1": number of URLs created,
			"User 2": number of URLs created,
			.
			.
			.
			"User n": number of URLs created,
		}
		
	Example:
		{
			"Mark Baker": 5,
			"Steven Johnson": 2
		}

d) Redirection Statistics [GET] -> http://localhost:9001/statistics/redirections

	1. Expected Response: 
		{
			"Tinyurl 1": number of redirections,
			"Tinyurl 2": number of redirections,
			.
			.
			.
			"Tinyurl n": number of redirections,
		}
	
	Example:
		{
			"http://localhost:9001/tinyurl/3941997e": 1,
			"http://localhost:9001/tinyurl/b02d3f5b": 3,
			"http://localhost:9001/tinyurl/d82f686e": 1
		}			

**Code coverge:** 

Run the following command in each project to check test code coverage:
  > mvnw clean jacoco:prepare-agent test jacoco:report
	

