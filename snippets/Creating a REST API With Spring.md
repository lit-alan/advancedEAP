
# Useful code snippets for creating a REST API with Spring :point_down:

## Add the web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0">
    <session-config>
        <session-timeout>
            30
        </session-timeout>
    </session-config>
    
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/sd4-config.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
 
 
</web-app>

 


```

## Add the Spring Config File

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">
    <context:component-scan base-package="lit.sd4.controllers" />


    <mvc:annotation-driven />
    <bean
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix">
            <value>/views</value>
        </property>
        <property name="suffix">
            <value>.jsp</value>
        </property>
    </bean>  
</beans>
```

## Create the Agent class
```java
public class Agent  {
 
  
    private int agentID;
    private String name;
    private String fax;
    private String phone;
    private String email;
    private String gender;
    private Date dateJoined;
    private double averageSaleThisYear;
    
    //constructors, getters, setters and toString omitted
    
```

## Create the Service class
```java
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    static List<Agent> agentList = new ArrayList();
    
    static {
        agentList.add(new Agent(1, "Sue Robert", "999-555-111", "78-45-56-51", "Sue.Roberts@litrealty.com", "Female", new Date(1998 - 1900, 12, 12), 9859655.39999));
        agentList.add(new Agent(2, "Natasha Watkins", "999-555-112", "78-45-56-52", "Natasha.Watkins@litrealty.com", "Female", new Date(2019 - 1900, 01, 15), 55000.00));
        agentList.add(new Agent(3, "Chris Clarkson", "999-555-113", "78-45-56-53", "Chris.Clarkson@litrealty.com", "Male", new Date(2005 - 1900, 06, 27), 350000.00));
        agentList.add(new Agent(4, "Laura Blain", "999-555-114", "78-45-56-54", "Laura.Blain@litrealty.com", "Female", new Date(2016 - 1900, 11, 25), 650000.45));
        agentList.add(new Agent(5, "Dave Lindale", "999-555-115", "78-45-56-55", "Dave.Lindale@litrealty.com", "Male", new Date(2016 - 1900, 03, 25), 0.0));   
    }

    public List<Agent> getAllAgents() {
       return agentList;
    }//end getAllAgents
   
    public Agent find(int id) {
        Agent a = null;
        Iterator<Agent> iterator = agentList.iterator();
        while (iterator.hasNext()) {
            Agent agent = iterator.next();
            if (agent.getAgentID() == id) {
                a = agent;
            }
        }
        return a;
    }
        
 
}//end AgentService

```

## Create the Rest Controller
```java
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/agents")
public class AgentRestController {
    
    @Autowired
    AgentService service;
    
    @GetMapping
    public List<Agent> getAgents() {
        return service.getAllAgents(); //the list is returned in JSON format by default. Each browser will handle this differently (e.g. IE will let you download a file containing the objects in JSON format)
    }
   
    @GetMapping("/{id}")
    public Agent getAgent(@PathVariable("id") int id) {
        return service.find(id); //again the object is returned in JSON format by default. Each browser will handle this differently.
    }
    
    /*
    
    The following requests cannot be tested through the browser.
    DELETE's  @DeleteMapping
    INSERTS's @PostMapping
    UPDATES's @PutMapping
    
    The will have to be tested through a 3rd Party App like Postman (https://www.postman.com/downloads/)
    
    
    See the notes for examples of not only using these mappings but also testing them with Postman
    */
}
```
