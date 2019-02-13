#To Do

* Create a class to model an Agent from the LITRealty App.
* Create the necessary views to:
   * Display all Agents.
   * Add a Agent (initially using a standard HTML form, but expanding it to use [Springs Tag Library](https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/view.html)
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

```

## JSP for displaying all agents.
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
                        <a href="\AgentsCRUD\delete?id=${agent.id}">Delete</a>
                        <a href="\AgentsCRUD\edit?id=${agent.id}">Edit</a>
                        <a href="\AgentsCRUD\add">Insert</a>
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
```
