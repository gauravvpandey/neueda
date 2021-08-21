The project is created using jdk 8.
====================================================================================================================================

install.ps1 -> Run this script in power shell. This will do the following
a) build all the services.
b) use docker-compose to build images using project's dockerfile and bring the corresponding services up in individual containers.

=====================================================================================================================================

There is a single tinyurl service:
=============================

Tinyurl: This provide following APIs

a) Create Tinyurl -> [POST Request] http://localhost:9001/tinyurl/create
	{
		"normalUrl" : "https://www.google.com/search?q=neueda+technologies&sxsrf=ALeKk009OmgZT-FyauyoyCzjYMtqEj3Q6w%3A1629457364852&source=hp&ei=1IsfYfHOMdes5OUPh5-MuAE&iflsig=AINFCbYAAAAAYR-Z5Mw_fmWm0EqpdhQfEpQVTkiBqvuh&gs_ssp=eJzj4tVP1zc0TDcyyCkvLEoxYLRSNagwsTBNNrE0MDCwNDW3SDZLsTKoSLIwMbBIMbY0Mbc0MkuxSPQSzkstTU1JVChJTc7Iy8_JT89MLQYAC0MWKQ&oq=neueda+te&gs_lcp=Cgdnd3Mtd2l6EAEYADIOCC4QgAQQxwEQrwEQkwIyBQgAEIAEMgYIABAWEB4yCQgAEMkDEBYQHjoHCCMQ6gIQJzoECCMQJzoLCAAQgAQQsQMQgwE6CAgAEIAEELEDOhEILhCABBCxAxCDARDHARDRAzoICAAQsQMQgwE6CAguEIAEELEDOg4ILhCxAxCDARDHARDRAzoOCC4QgAQQsQMQgwEQkwI6CwguEIAEEMcBEK8BOgUILhCABDoHCAAQgAQQCjoKCC4QxwEQrwEQJzoGCAAQBxAeUPInWMCPAWChoQFoAXAAeACAAZcBiAGLCZIBAzAuOZgBAKABAbABCg&sclient=gws-wiz",
		"user" : "gaurav"
	}

Expected Response: Status 200 OK and Tinyurl For ex: http://localhost:9001/tinyurl/b02d3f5b
  
b) Redirect Url -> [GET Request] http://localhost:9001/tinyurl/{id} Ex: http://localhost:9001/tinyurl/b02d3f5b

Expected Response: Neueda Technologies should be shown in google search.

======================================================================================================================================

Code coverge: 

Run the following command in each project to check test code coverage -> 
mvnw clean jacoco:prepare-agent test jacoco:report
	
