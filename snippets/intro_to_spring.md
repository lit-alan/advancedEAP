
## Snippets for 'Introduction To Spring' Live Coding Session: :point_down:


1. [Plugin Repositories](#plugin-repositories)

2. [CMD to Run Spring](#cmd-to-run-spring)

3. [Configure Views](#configure-views) 

4. [Maven Dependencies For Tomcat And JSTL](#maven-dependencies-for-tomcat-and-jstl) 

5. [Messages For List](#messages-for-list)

6. [Greetings.jsp](#greetingsjsp)

7. [Person.java](#personjava)

### Plugin Repositories
```xml
<pluginRepositories>
  <pluginRepository>
    <id>central</id>
    <name>Central Repository</name>
    <url>https://repo.maven.apache.org/maven2</url>
    <layout>default</layout>
    <snapshots>
      <enabled>false</enabled>
    </snapshots>
    <releases>
      <updatePolicy>never</updatePolicy>
    </releases>
 </pluginRepository>
</pluginRepositories>


```

### CMD to Run Spring
> spring-boot:run


### Maven Dependencies For Tomcat And JSTL
```xml

<dependency>
       <groupId>org.apache.tomcat.embed</groupId>
       <artifactId>tomcat-embed-jasper</artifactId>
       <scope>provided</scope>
</dependency>
        <dependency>
        <groupId>jstl</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
</dependency>

```
### Configure Views
```properties
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix= .jsp

```
### Messages For List
```java
List<String> messages = new ArrayList();
messages.add("Dia duit domhan");
messages.add("Hello World");
messages.add("Hallo Welt");
messages.add("Bonjour le monde");
messages.add("Hola Mundo");
messages.add("Hej Verden");
messages.add("Привет, мир");
messages.add("Witaj świecie");
messages.add("Hallo Wereld");
messages.add("Olá Mundo");
```
### Greetings.jsp
```jsp
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Greetings!</title>
    </head>
    <body>
        <c:forEach items="${hellolist}" var="item"> 
            ${item} <br>
        </c:forEach>
    </body>
</html>
```


### Person.java
```java
class Person {
    private String name;
    private String city;
    private int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
```

