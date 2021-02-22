To Do Week 6: :globe_with_meridians:

1. This week you must develop an Internationalised 'Search Facility' for the Books table in the H2 database.

2. To begin, you will need to add the following (two) Beans along with the 'addInterceptors' method to the application class for your project. This class will also have to implement the *WebMvcConfigurer* interface.

```java
    @Bean
    public LocaleResolver localeResolver() { 
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("en", "IE"));
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
```

3. You will need to support English and another language of your chosing ([use Google Translate](https://translate.google.com/) to assist you with this), so you will need to create two resource bundles (.properties files)

4. You will need ***two*** views for this exercise, ***one*** to allow the user to enter a search term (a book title) and a ***second*** to display the search results. Your search should cater for a partial search and ***there should be no hard-coded strings in your views***. If you are using Thymeleaf as your view template then you can store the views in the *templates* package, with other assets such as css/javascript/images etc being stored in the static package. For example:

![](/images/views_and_assets.JPG)




5. As we have discovered, Spring's [CrudRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html) will perform a number of basic CRUD features out of the box for you. A partial search is not one of these features :cry:. Therefore, you will have to create your own custom query for this exercise and add it to your *BookRepository* interface. The method should look something like the following:

```java
@Query("SELECT b FROM Book b WHERE b.title etc....")
public List<Book> getBooksThatContainTerm(String term);

```
   *In order to define SQL to execute for a Spring Data repository method, you can annotate a method with the @Query annotation — you can then specify the JPQL or native SQL (yes, you can use native SQL instead of JPQL if you wish) to execute.*

6. You should to add a method to your *BookService* class that calls the above method. After doing this, the method will be available to your Controllers.

7. Make sure to internationalise any validation messages in your Book entity class. Consult the lecture for help with this
