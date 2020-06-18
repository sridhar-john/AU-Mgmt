# AU-Mgmt
Opportunity Management project using Angular and Spring-boot with MySql DB
 
I)Spring boot Application

=> Project Structure of spring boot application:
	inside my src/main/java/com/accolite/
   
                             controller
                             service
                             model
                             repository
                             opportunity
			     exception
			     configuration
							 
=> All the Apis are created for CRUD(GET,POST,PUT,DELETE) operations of opportunity and user validation
	
	* getAllOpportunities
	
	* updateOpportunity
	
	* createOpportunity
	
	* deleteOpportunity
	
	* checkUser
	
=> GlobalExceptionHandling added.

=> Unit testing done for Service and Dao layer using Mockito-junit for the CRUD functions.

=> token is used for Authentication and its send from angular using http Interceptor


II)Angular Application:

=> Angular design Screen shots are attached.

=> Project structure of Angular appliaction:
	
	Inside my Angular/src
                      
				├───app
				│   ├───components
				│   │   ├───charts
				│   │   ├───login
				│   │   ├───opportunity
				│   │   │   ├───create-op
				│   │   │   └───search
				│   │   └───trends
				│   ├───core
				│   ├───models
				│   └───shared
				├───assets
				│   └───img
				└───environments
		       
		       
=> Angular-unit testing :

			implemented the form Validation testing

			implemented the Services testing

			implemented some component testing
			
=> Google login is used for Authentication and Token is send to spring boot for Validation

