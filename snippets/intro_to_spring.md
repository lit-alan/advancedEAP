
## Snippets for 'Introduction To Spring' Live Coding Session: :point_down:


1. [Plugin Repositories](#pluginrepositories)

2. [CMD to Run Spring](#cmdtorunspring)

3. [Maven Dependencies For Tomcat And JSTL](#mavendependenciesfortomcatandjstl) 

4. [Configure Views](#configureviews)

5. [Messages For List](#messagesforlist)

6. [Greetings.jsp](#greetingsjsp)

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
