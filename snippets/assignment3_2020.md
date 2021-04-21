# Todays snippets :point_down:
1. [Property.java](#propertyjava)
2. [PropertyService.java](#propertyservicejava)
3. [viewAll.jsp](#viewalljsp)
4. [viewOne.jsp](#viewonejsp)
5. [add.jsp](#addjsp)
6. [AgentController.java](#agentcontrollerjava)
7. [PropertyController.java](#propertycontrollerjava)


# Property.java
```java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Property {
    
    private String id;
    private String street;
    private String city;
    private Integer bedrooms;
    private Integer bathrooms;
    private String description;
    private Double price;
  
    
}
```
# PropertyService.java
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    
    static List<Property> pList = new ArrayList(); 
    
    
    static {
        
        pList.add(new Property("1", "123 Fake St", "Limerick", 5, 3, "Great family home",350000.00));
        pList.add(new Property("2", "89 Duckworth St", "Cork", 3, 1, "Close to all amenities", 270000.00));
        pList.add(new Property("3", "85 Nrth Circular Road", "Dublin", 4, 2, "Great transport links nearby",650000.00));
        pList.add(new Property("4", "5 Northern Pass", "Limerick", 3, 2, "Fantastic starter home",250000.00));
        pList.add(new Property("5", "Windy Arbour", "Waterford", 5, 3, "Very private and scenic setting",240000.00));
        pList.add(new Property("6", "Beach View Terrace", "Sligo", 5, 3, "Fantastic sea views", 230000.00));
        pList.add(new Property("7", "36 LIT View", "Limerick", 5, 4, "Rental Income Assured",280000.00));

        
    }
    
    public List<Property> getAllProperties() {
        return pList;
    }
    
    public Optional<Property> getPropByID(String id) {
            return pList.stream().filter(p -> id.equals(p.getId())).findAny();
    
     }

    public boolean addAProperty(Property p) {
        return pList.add(p);
    }
    

}
```
# viewAll.jsp

```jsp
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Properties</title>
    </head> 
   <body>
   
   
        <table style="width:100%">
            <tr>
            <th align="left">ID</th>
             <th align="left">Street</th>
             <th align="left">City</th>
             <th align="left">Bedrooms</th>
             <th align="left">Bathrooms</th>
             <th align="left">Description</th>
             <th align="left">Price</th>
             <th align="left">Actions</th>
            </tr>
            <c:forEach items="${propList}" var="p"> 
                <tr>
                    <td>${p.id}</td>
                    <td>${p.street}</td>
                    <td>${p.city}</td>
                    <td>${p.bedrooms}</td>
                    <td>${p.bathrooms}</td>
                    <td>${p.description}</td>
                    <td>${p.price}/></td>
                
                </tr>
            </c:forEach>
        </table>
             
    </body>
</html>
```
# viewOne.jsp

```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
    <title>JSP Page</title>
</head>
<body>
    <h1>Property   id</h1>
    <table style="width:20%">
        <tr>
            <td>ID</td>
            <td>id</td>
        <tr>   
        <tr>
            <td>Street</td>
            <td>street</td>
        <tr>   
        <tr>
            <td>City</td>
            <td>city</td>
        <tr>   
        <tr>
            <td>Bedrooms</td>
            <td>bedrooms</td>
        <tr>   
        <tr>
            <td>Bathrooms</td>
            <td>bathrooms</td>
        <tr>   
        <tr>
            <td>Description</td>
            <td>description</td>
        <tr>   
        <tr>
            <td>Price</td>
            <td>price</td>
        <tr>   

    </table>

</body>
</html>
```
# add.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
  
         <form:form method="POST"
                   action="/properties/add/" modelAttribute="property">
            <table>
                <tr> 
                    <td><form:label path="id">ID</form:label></td>
                    <td><form:input path="id"/></td> 
               </tr> 
                <tr>
                    <td><form:label path="street">Street</form:label></td>
                    <td><form:input path="street" /></td>
                </tr>
                <tr>
                    <td><form:label path="city">City</form:label></td>
                    <td><form:input path="city"/></td>  
                </tr>
                <tr>
                    <td><form:label path="bedrooms">Bedrooms</form:label></td>
                    <td><form:input path="bedrooms"/></td>

                </tr>
               <tr>
                    <td><form:label path="bathrooms">Bathrooms</form:label></td>
                    <td><form:input path="bathrooms"/></td>
                </tr>
               <tr>
                    <td><form:label path="description">Description </form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
               <tr>
                    <td><form:label path="price">Price </form:label></td>
                    <td><form:input path="price"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add A Property"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
```

# AgentController.java
```java

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/agent")
public class AgentController {
    
    @GetMapping("add")
    @ResponseBody
    public String add() {
         return "AgentController/add";
    }
    
     
    @GetMapping("view")
    @ResponseBody
    public String viewAll() {
         return "AgentController/view";
    }
    
    @GetMapping("delete")
    @ResponseBody
    public String delete() {
         return "AgentController/delete";
    }
    
    @GetMapping("edit")
    @ResponseBody
    public String edit() {
         return "AgentController/edit";
    }
    
}
```

# PropertyController.java
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/properties")
public class PropertyController {
    
    @Autowired
    private PropertyService propertyService;
    
    //add a route for /view/{id}
    
    @GetMapping("view")
    @ResponseBody
    public ModelAndView viewAll() {
        List propList = propertyService.getAllProperties();
        return new ModelAndView("/viewAll", "propList",propList);
    }
    
    
    @GetMapping("add")
    @ResponseBody
    public ModelAndView showAddForm() {
           return new ModelAndView("/add","property", new Property());
    }
    
    @PostMapping("add")
    @ResponseBody
    public String addProperty(@ModelAttribute("property") Property property) {
           propertyService.addAProperty(property);
           return "";
    }
    
 
    @GetMapping("delete")
    @ResponseBody
    public String delete() {
         return "PropertyController/delete";
    }
    
    @GetMapping("edit")
    @ResponseBody
    public String edit() {
         return "PropertyController/edit";
    }
    
}
```
