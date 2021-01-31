
## To do (Week 4): :relaxed:
          
          
1. Create a project using [Spring Initializr](https://start.spring.io/) using the settings I have recommended.  
![settings to use when creating your Spring Boot project](todo/images/spring_init.JPG)
   * Add dependencies for Spring Web along with **Spring Data and H2** to the project using the Initlializr. 
   * Don't forget to add an [entry](https://github.com/lit-alan/SD4-Adv-Enterprise-App-Development/blob/master/snippets/intro_to_spring.md#plugin-repositories) to your POM to instruct Maven to use *https* when downloading the necessary plugins.

2. Create an entity class to model a [Book](#bookjava)

3. Create a repository interface, that extends [CrudRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html), as well as an associated service class for your Book entity. See my [source code on Github](https://github.com/lit-alan/SD4-Adv-Enterprise-App-Development/tree/master/source/SpringBootAndTheCrudRepository) (and the image below) for help with structuring your project and also the course notes on [Moodle](https://moodle.lit.ie/course/view.php?id=1766). 
![settings to use when creating your Spring Boot project](todo/images/project_structure.JPG)
    * Don't forget to add the [necesary config](https://github.com/lit-alan/SD4-Adv-Enterprise-App-Development/blob/master/source/SpringBootAndTheCrudRepository/src/main/resources/application.properties) to the *application.properties* file for H2.

4. In your Spring Boot [Application class](source/SpringBootAndTheCrudRepository/src/main/java/com/sd4/application/SpringBootAndTheCrudRepositoryApplication.java), add the necessary package scans and add some Books objects to H2. Don't forget to implement the *CommandLineRunner* interface 

5. Build a CRUD application for the Book entity (this will necessitate you adding a Controller(s) to your project).
   * The "add a Book" feature **must be implemented in an MVC fashion** using  a [form](#addbookjsp) to gather the data to be inserted in the DB. Use the [following code](#addbook-controller-methods) in your MVC controller to assist with this.
   * You will have to add a dependency for [Jasper and JSTL](https://github.com/lit-alan/SD4-Adv-Enterprise-App-Development/blob/master/snippets/intro_to_spring.md#maven-dependencies-for-tomcat-and-jstl) to your POM at this stage.
   * You will have to create a folder to store your view(s) and you will have to put the associated [hooks](https://github.com/lit-alan/SD4-Adv-Enterprise-App-Development/blob/master/snippets/intro_to_spring.md#configure-views) into the *application.properties* file at this point.
   * All other aspects of the CRUD can be implemented with a Rest Controller - they should be quicker to develop this way as they don't have any associated views.


### Book.java
```java


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long bookId;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private double price;
    private String isbn;

    public Book() {
    }

    public Book(long bookId, String title, String author, String publisher, int yearPublished, double price, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.price = price;
        this.isbn = isbn;
    }

    /**
     * @return the bookId
     */
    public long getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the yearPublished
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * @param yearPublished the yearPublished to set
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
}


```
### addBook Controller methods
```java

//method to load the add book form. This method also creates a Book object that will back the add book form
 @GetMapping("/add")
public ModelAndView displayAddForm() {
        return new ModelAndView("/addBook", "aBook", new Book());
}.

//method to save the book entity to the DB    
//decide on mapping etc..
 public ModelAndView addAnAgent(@ModelAttribute("aBook") Book b, BindingResult result) {
                
        if (result.hasErrors()) {
            //display error page
        }
        //save the book object to the DB
        //display success page
    }
    
```
### addBook.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
    <head>
        <title>Add a book</title>
    </head>

    <p>Add a book</p>

    <form:form method="?" action="?" modelAttribute="aBook">

        <table>
            <tr>
                <td><form:label path="title">Title</form:label></td>
                <td><form:input path="title"/></td>

            </tr>
            <tr>
                <td><form:label path="author">Author</form:label></td>
                <td><form:input path="author"/></td>
            </tr>
            <tr>
                <td><form:label path="publisher">Publisher</form:label></td>
                <td><form:input path="publisher"/></td>
            </tr>
            <tr>
                <td><form:label path="yearPublished">Year of Publication</form:label></td>
                <td><form:input path="yearPublished"/></td>
            </tr>
            <tr>
                <td><form:label path="price">Price</form:label></td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td><form:label path="isbn">ISBN</form:label></td>
                <td><form:input path="isbn"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit!"/></td>
                <td><input type="reset" value="Clear"/></td>
            </tr>
        </table>
    </form:form>
</html>
```
