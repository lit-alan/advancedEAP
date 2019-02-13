#To Do#

1. Create a class to model an Agent from the LITRealty App
2. Create the necessary views to:
   2.1. Display all Agents.
   2.2. Add a Agent (initially to use a standard HTML form, but expanding it to use [Spring's tag library] (https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/view.html).
   2.3. Delete an Agent
   2.4. Edit an Agent.
3. Create a Controller to handle client requests.


# Useful code snippets for 14/02/2019  :eyes:
## Create a Agent Bean ##
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

