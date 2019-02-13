#To Do

* Create a class to model an Agent from the LITRealty App.
* Create the necessary views to:
   * Display all Agents.
   * Add a Agent (initially to use a standard HTML form, but expanding it to use [Spring's tag library] (https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/view.html).
   * Delete an Agent
   * Edit an Agent.
* Create a Controller to handle client requests.


# Useful code snippets for 14/02/2019  :eyes:

## Create a Agent Bean 
```
 public class Agent {
    
    private int id;
    private String name;
    private String fax;
    private String phone;
    private String email;
	
	//generate getters/setters and constructors
	//possibly override toString()
	
}

