To do (Week 5) : :smiley:
 
1. Finish last weeks exercise (*its vital that you do*).
2. Add a dependency for Hibernate Validator to your POM.
```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.0.1.Final</version>
</dependency>
```
3. Add some validation to the fields in your Book entity class (decide on the validation yourself). Consult with last weeks lecture for help with this.
 
4. Test the validation. For the 'Add a Book' feature which you implemented using a *view* you will need to amend the form so that you can display the post validation error messages.
 
5. To return post validation messages as part of a REST response, add the following method to your REST controller.
 
```java
@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
```
*I won't be distributing a solution for this (or last weeks) exercise. Ensure you complete these tasks so you have a working project which you can reference going forward*
 
 
 
