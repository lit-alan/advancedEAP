## Todays Snippets :point_down:
1. [Product.java](#productjava) <br>
2. [ProductService.java](#productservicejava) <br>
3. [allProducts.jsp](#allProductsjsp) <br>
4. [addProduct.jsp](#addproductjsp) <br>
5. [POM.XML](#pomxml) <br>
6. [WEB.XML](#webxml)


## Product.java
```java
public class Product {
    
    private String code;
    private String name;
    private String description;
    private double buyPrice;
    private double sellPrice;
    private int quantityInStock;

    public Product() {
    }

    public Product(String code, String name, String description, double buyPrice, double sellPrice, int quantityInStock) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.quantityInStock = quantityInStock;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the buyPrice
     */
    public double getBuyPrice() {
        return buyPrice;
    }

    /**
     * @param buyPrice the buyPrice to set
     */
    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * @return the sellPrice
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * @param sellPrice the sellPrice to set
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * @return the quantityInStock
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * @param quantityInStock the quantityInStock to set
     */
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", name=" + name + ", description=" + description + ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice + ", quantityInStock=" + quantityInStock + '}';
    }
}

```
## ProductService.java
```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lit.sd4.model.Product; //you may have to change this import depending on where you store the Product class
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    static List<Product> productList = new ArrayList();

    static {
        productList.add(new Product("XG809", "Contemporary Office Desk", "Concentrating on the job is a lot easier when everyone has a place that’s comfortable to work at.", 25.00, 69.00, 18));
        productList.add(new Product("BG565", "Bed Frame With Storage", "With the comfort and quality you get from our sturdy single beds, you’ll wake up refreshed and ready to roll. ", 139.00, 175.00, 5));
        productList.add(new Product("PO262", "TV Stand", "Our TV stands and TV cabinets are there to cut the clutter and get things organised.", 69.99, 89.99, 120));
        productList.add(new Product("MC342", "Kitchen Unit", "They make the most of your wall by giving you extra storage, and the right kitchen shelf can boost the style of your decor too", 23.00, 65.99, 89));
        productList.add(new Product("WS341", "Folding Chair", "You can fold the chair, so it takes less space when you're not using it.", 12.00, 35.99, 30));
        productList.add(new Product("TF875", "Berkant Kitchen", "Express yourself in the place where all of life’s daily activities take place.in our stylish, yet personalised kitchen..", 8900.00, 12200.99, 4));

    }

    public List<Product> getAllProducts() {
        return productList;
    }// end getAllProducts

    
    public boolean addAProduct(Product p) {
        return productList.add(p);
    }
    
    public void deleteAProduct(String code) {
        
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCode().equalsIgnoreCase(code)) {
                iterator.remove();
            }
        }
    }//end deleteAProduct

}//end class ProductService
```


## allProducts.JSP
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
        <title>All Products</title>
    </head> 
   <body>
        <table style="width:100%">
            <tr>
            <th align="left">Code</th>
             <th align="left">Name</th>
             <th align="left">Description</th>
             <th align="left">Buy Price</th>
             <th align="left">Sell Price</th>
             <th align="left">Qty In Stock</th>
             <th align="left">Actions</th>
            </tr>
            <c:forEach items="${productList}" var="product"> 
                <tr>
                    <td>${product.code}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.buyPrice}</td>
                    <td>${product.sellPrice}</td>
                    <td>${product.quantityInStock}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
             
    </body>
</html>



```


## addProduct.JSP
```jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        
        <form:form >
            <table>
                <tr> 
                    <td><form:label path="code">Code</form:label></td>
                    <td><form:input path="code"/></td> 
                    <td style="color:red"><form:errors path="code"/> </td>
               </tr> 
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name" /></td>
                    <td style="color:red"><form:errors path="name"/> </td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                    <td style="color:red"><form:errors path="description"/> </td>
                    
                </tr>
                <tr>
                    <td><form:label path="buyPrice">Buy Price</form:label></td>
                    <td><form:input path="buyPrice"/></td>
                    <td style="color:red"> <form:errors path="buyPrice"/> </td>
                </tr>
               <tr>
                    <td><form:label path="sellPrice">Sell Price</form:label></td>
                    <td><form:input path="sellPrice"/></td>
                    <td style="color:red"> <form:errors path="sellPrice"/> </td>
                </tr>
               
                <tr>
                    
                    <td><form:label path="quantityInStock">Quantity In Stock</form:label></td>
                    <td><form:input type="quantityInStock" path="quantityInStock"/></td>
                    <td style="color:red"> <form:errors path="quantityInStock"/> </td>
                   
                </tr>
                <tr>
                    <td><input type="submit" value="Add Product"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
```

## POM.XML
```xml
These are the versions of SpringMVC and Spring Security that you are required to use for this assignment.
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
<dependency>
    <groupId>javax</groupId>
    <artifactId>javaee-web-api</artifactId>
    <version>6.0</version>
    <scope>provided</scope>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.0.0.RELEASE</version>
</dependency>		
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-web</artifactId>
    <version>4.0.3.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
	<artifactId>spring-security-config</artifactId>
    <version>4.0.3.RELEASE</version>
</dependency>	
<dependency>  
    <groupId>org.springframework.security</groupId>  
    <artifactId>spring-security-taglibs</artifactId>  
    <version>4.0.3.RELEASE</version>  
</dependency>  
```


## WEB.XML
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
    
    <filter>
        <filter-name>springSecurityFilterChain</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>
	 
    <filter-mapping>
        <filter-name>springSecurityFilterChain</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping> 
 
 
</web-app>



```
