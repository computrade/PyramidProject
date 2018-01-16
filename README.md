# The Human Pyramid Project

**Business logic:**

This project calculates for each human in the pyramid the total weight that he has to bear on his back.

There are two methods to calculate the weight:

1.  `getHumanEdgeWeight (int level): weight`
Where the input level is the pyramid level (starting from 0) and the weight to be returned is the weight that the
human on **edge** has on his back.
2.  `getHumanWeight (int level, int index): weight`
Where level (starting from 0) is the pyramid level, the index (starting from 0) is a number of the human on that level.
The weight to be returned is the weight that the human on that index has on his back.

**The following technologies were used in this implementation:**
1. Java 8
2. Spring MVC for REST Service implementation.
3. Spring Boot.
4. Project is built using Maven.
5. Test:
  * SpringBootTest was used to test Rest ( see: WeightControllerTests ) 
  * Junit with '@Parameters' was used to test the different algorithms. ( see: HumanWeightStrategyTest ) 

**Production ready**

Solution is production ready from the following perspective:
  
  **Logging:** 
  slf4j was used for logging.
  debug level can be configured in the application.properties as such:
    
    logging.level.org.springframework.web=INFO
    logging.level.com.example=DEBUG
   
  **Configuration:**
  Person’s weight is 50kg by default, but can also be provided as external configuration parameters.
  The Strategy to calculate the weight is also configurable.  
  Here is an example of such configuration in the application.properties: 
    
    pyramid.weight.strategy = com.example.pyramid.algorithm.IterativeHumanEdgeWeightStrategy
    pyramid.human.weight = 50
    
  **Spring Configuration:**
  Spring beans are configurable using the `spring-beans.xml` configuration files.
    
  **Error Handeling:**
  New Exceptions were created to handle specific application exceptions. ( see in package 'com.example.pyramid.services.exception' )
  HTTP response code were updated according the exception. ( see: 'GlobalExceptionHandlingControllerAdvice' class )
    
  **Testing:**
  Tests were added to check a the stategies which implements the application logic. ( see: HumanWeightStrategyTest )
  Tests were added to check the ReST layer. ( see: WeightControllerTests ) 
  
  **Documentation:**
  The code interface is documented with Java Doc.
  There is a readme.md file for additional documentation.
 
 **Rest Services Sample:**
 
 `curl -X GET http://localhost:8080/pyramid/weight?level=3&index=2`
 
 Sample json result:  {"id":2,"weight":106.25}

`curl -X GET http://localhost:8080/pyramid/weight/edge?level=3`

Sample json result {"id":3,"weight":43.75}
