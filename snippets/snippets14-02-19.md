# To Do

* Create a class to model an Agent from the LITRealty App.
* Create the necessary views to:
   * Display all Agents.
   * Add a Agent (initially using a standard HTML form, but expanding it to use [Springs Tag Library](https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/view.html)
   * Delete an Agent
   * Edit an Agent.
* Create a Controller to handle client requests. 


# Useful code snippets for 14/02/2019 :cupid:

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

```

## AgentService class (AgentService.java)
```
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgentService {

    static List<Agent> agentList = new ArrayList();
    
    static {
        agentList.add(new Agent(1, "Sue Robert", "999-555-111", "78-45-56-51", "Sue.Roberts@litrealty.com"));
        agentList.add(new Agent(2, "Natasha Watkins", "999-555-112", "78-45-56-52", "Natasha.Watkins@litrealty.com"));
        agentList.add(new Agent(3, "Chris Clarkson", "999-555-113", "78-45-56-53", "Chris.Clarkson@litrealty.com"));
        agentList.add(new Agent(4, "Laura Blain", "999-555-114", "78-45-56-54", "Laura.Blain@litrealty.com"));
        agentList.add(new Agent(5, "Dave Lindale", "999-555-115", "78-45-56-55", "Dave.Lindale@litrealty.com"));   
    }
    
    public List<Agent> getAllAgents() {
       return agentList;
    }//end getAllAgents
    
    public void addAnAgent(Agent a) {
        agentList.add(a);
    }//end addAnAgent
    
    public void deleteAnAgent(int id) {
        System.out.println("auto wired baby!");
        Iterator<Agent> iterator = agentList.iterator();
        while (iterator.hasNext()) {
            Agent agent = iterator.next();
            if (agent.getId() == id) {
                iterator.remove();
            }
        }
    }//end deleteAnAgent
    
}//end AgentService

```

## JSP for displaying all agents (allAgents.jsp).
```
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Agents</title>
    </head>
    <body>
        <table style="width:100%">
            <tr>
             <th align="left">ID</th>
             <th align="left">Name</th>
             <th align="left">Fax</th>
             <th align="left">Phone</th>
             <th align="left">Email</th>
             <th align="left">Actions</th>
            </tr>
            <c:forEach items="${agentList}" var="agent"> 
                <tr>
                    <td>${agent.id}</td>
                    <td>${agent.name}</td>
                    <td>${agent.fax}</td>
                    <td>${agent.phone}</td>
                    <td>${agent.email}</td>
                    <td>
                        <a href="">Delete</a>
                        <a href="">Edit</a>
                        <a href="">Insert</a>
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
```

## Form to Add an Agent (addAgent.jsp)

```
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
       
    <head>
    </head>
  
        <h3>Enter The Agent Details!</h3>
        
        <form method="POST" action="/AgentsCRUD/addAgent">
                   
            <table>
                <tr>
                    <td><label name="id">ID</label></td>
                    <td><input name="id"/></td>
                </tr>
                <tr>
                    <td><label name="name">Name</label></td>
                    <td><input name="name"/></td>
                </tr>
                 <tr>
                    <td><label name="phone">Phone</label></td>
                    <td><input name="phone"/></td>
                </tr>
                <tr>
                    <td><label name="fax">Fax</label></td>
                    <td><input name="fax"/></td>
                </tr>
                <tr>
                    <td><label name="email">Email</label></td>
                    <td><input name="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit!"</td>
                </tr>
            </table>
        </form>

</html>
```
## Method for inclusion in the Controller to handle a get request to add an agent

```
@GetMapping("/add")
    public ModelAndView displayAgentAddForm() {
        return new ModelAndView("/addAgent", "agent", new Agent());
}
```
## Method signature for Controller method to handle submission of Add an Agent form

```
 //@RequestMapping(value = "/addAgent", method = RequestMethod.POST)
 @PostMapping("/addAgent")
 public ModelAndView addAnAgent(@FormParam("id") int id,
                                   @FormParam("name") String name,   
                                   @FormParam("phone") String phone,  
                                   @FormParam("fax") String fax,  
                                   @FormParam("email") String email) {
	//create the agent object
	//add the object to the list
	//route the user to the next page
}
```

## Method signature for Controller method to handle the deletion of an agent
```
//@RequestMapping(value = "/delete", method = RequestMethod.GET)
@GetMapping("/delete")
public ModelAndView deleteAnAgent(@QueryParam("id") int id) {
	//delete the agent
	//route the user to the next page
}
```    

## Revised form to add an agent (this form uses the Spring tag library)
```
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
    </head>
  
        <h3>Enter The Agent Details!</h3>
        
        <form:form method="POST" action="/AgentsCRUD/addAgent" modelAttribute="agent">
     
            <table>
                <tr>
                    <td><form:label path="id">ID</form:label></td>
                    <td><form:input path="id" required='true'/></td> 
               </tr>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                    <form:errors path="name"/>
                </tr>
                <tr>
                    <td><form:label path="phone">Phone</form:label></td>
                    <td><form:input path="phone"/></td>
                </tr>
                <tr>
                    <td><form:label path="fax">Fax</form:label></td>
                    <td><form:input path="fax"/></td>
                </tr>
               <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit!"/></td>
                </tr>
            </table>
        </form:form>
    
	
</html>
```
## Revised method to handle the submission of a form (that uses the Spring tag lib) to add an agent
```
    // @RequestMapping(value = "/addAgent", method = RequestMethod.POST)
    @PostMapping("/addAgent")
    public ModelAndView addAnAgent(@Valid @ModelAttribute("agent")Agent agent, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
                //display error page
        }
        //add the agent object to the list
        //route the user to the next page
    }
 ```
