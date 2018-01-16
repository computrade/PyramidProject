# The Human Pyramid

Given a human pyramid with N levels. 

**Business logic:**
This project calculates each human the total weight that he has to bear on his back with the
following conditions.
1. Implement getHumanEdgeWeight (int level): weight
Where level is the pyramid level and the weight to be returned is the weight that the
human on edge has on his back.
2. Implement getHumanWeight (int level, int index): weight
Where level is the pyramid level, the index is a number of the human on that level and
the weight to be returned is the weight that the human on agde has on his back.

**Tech implementation:**
1. java8
2. Spring MVC for REST Service implementation.
3. Spring Boot.
4. Project was built with Maven.

**Production ready**

Solution is production ready from the following perspective:
  
  **Logging** - slf4j was used for logging.
    debug level can be configured in the application.properties
    
   
    logging.level.org.springframework.web=INFO
    logging.level.com.example=DEBUG
    logging.level.hello=DEBUG
   
  **Configuration:**
    Person’s weight is 50kg by default, but can also be provided as external configuration parameters.
    The Strategy to calculate the weight is also configurable.
    
    here is an example of such configuration in the application.properties: 
    
    pyramid.weight.strategy = com.example.pyramid.algorithm.IterativeHumanEdgeWeightStrategy
    pyramid.human.weight = 50
    
  **Error Handeling:**
    HTTP response code were updated according the exception. ( see: 'GlobalExceptionHandlingControllerAdvice' class )
    
    New Exceptions ware created to handle specific application exceptions. ( see in package 'com.example.pyramid.services.exception' )
  **Testing:**
    Tests were added to check a the stategies which implements the application logic
    Test were added to check the ReST layer.
  **Documentation:**
    The code is documented with Java Doc.
    The is a readme.md file for documentation.
 
 **Rest Sample code**
 
 `curl -X GET http://localhost:8080/pyramid/weight?leve2=1&index=0`

`curl -X GET http://localhost:8080/pyramid/weight/edge?level=3`


