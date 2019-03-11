
## Dispatcher Servlet Config (sd4-config.xml)
```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">
    <context:component-scan base-package="lit.sd4.agents" />
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
    
    <bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean" >
          <property name="validationMessageSource" ref="messageSource"/>
    </bean>
        
    <bean id="messageAccessor" class="org.springframework.context.support.MessageSourceAccessor">
          <constructor-arg index="0" ref="messageSource"/>
    </bean> 

    <bean id="messageSource"
          class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
        <property name="basename" value="classpath:messages" />
        <property name="defaultEncoding" value="UTF-8" />
    </bean>

    <bean id="localeResolver"
              class="org.springframework.web.servlet.i18n.SessionLocaleResolver">
        <property name="defaultLocale" value="en_IE" />
    </bean>

    <mvc:interceptors>
        <bean id="localeChangeInterceptor"
                      class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
            <property name="paramName" value="language" />
        </bean>
    </mvc:interceptors>
    
   
</beans>

```
## messages_en.properties
```
#headers
welcome.message= Welcome
addagentform.header = Enter the agent details
allagents.title = All Agents

#labels for forms
label.actions = Actions
label.id = ID
label.name = Name
label.fax = Fax
label.phone = Phone
label.email = Email
label.sales = Average Sale This Year
label.datejoined = Date Joined
label.gender = Gender
label.gender.male = Male
label.gender.female = Female

#links and text for buttons
label.delete = Delete
label.insert = Insert
label.edit = Edit
submit.button = Submit

#Error messages from Agent Bean
typeMismatch.agent.id = the ID must be a number
Min.agent.id = {0} must be greater than or equal to {1}
Size.agent.name = enter at least {2} Characters 
NotBlank.agent.fax = {0} cannot be empty
NotBlank.agent.email = {0} cannot be empty
Email.agent.email = enter a valid {0} address
NotBlank.agent.phone = {0} cannot be empty
NotBlank.agent.gender = please select a {0}
Past.agent.dateJoined = {0} must be in the past
NotNull.agent.dateJoined = you must select a date
DecimalMin.agent.averageSaleThisYear =  must be greater than {2}
```


## messages_es.properties
```
#headers
welcome.message= Bienvenido
addagentform.header = Ingrese los detalles del agente
allagents.title = Todos los agentes

#labels for forms
label.actions = Comportamiento
label.id = Carneé de Identidad
label.name = Nombre
label.fax = Fax
label.phone = Teléfono
label.email = Email
label.sales = Promedio de venta este año
label.datejoined = Fecha de Registro
label.gender = Género
label.gender.male = Masculino
label.gender.female = Hembra

#links and text for buttons
label.delete = Borrar
label.insert = Insertar
label.edit = Editar
submit.button = Enviar

#Error messages from Agent Bean
typeMismatch.agent.id = la identificación debe ser un número
Min.agent.id = la {0} debe ser mayor o igual a {1}
Size.agent.name = introduce al menos {2} caracteres
NotBlank.agent.fax = el {0} no puede estar vacío
NotBlank.agent.email = el correo electrónico no puede estar vacío
Email.agent.email = introduzca una dirección de correo electrónico válida
NotBlank.agent.phone = el teléfono no puede estar vacío
NotBlank.agent.gender = seleccione un género
Past.agent.dateJoined = la fecha de ingreso debe estar en el pasado
NotNull.agent.dateJoined = debes seleccionar una fecha
DecimalMin.agent.averageSaleThisYear =  la cifra promedio de ventas debe ser mayor a {2}
```


## messages_fr.properties
```
#headers
welcome.message= Bienvenue
addagentform.header = Entrez les détails de l'agent
allagents.title = Tous les agents

#labels for forms
label.actions = Actes
label.id = ID
label.name = Prénom
label.fax = Fax
label.phone = Téléphone
label.email = Email
label.sales = Vente moyenne cette année
label.datejoined = Date d'inscription
label.gender = Le sexe
label.gender.male = Mâle
label.gender.female = Femelle

#links and text for buttons
label.delete = Effacer
label.insert = Insérer
label.edit = Modifier
submit.button = Soumettre

#Error messages from Agent Bean
typeMismatch.agent.id = l'ID doit être un numéro
Min.agent.id = {0} doit être supérieur ou égal à {1}
Size.agent.name = entrez au moins {2} caractères
NotBlank.agent.fax = le {0} ne peut pas être vide
NotBlank.agent.email = l'email ne doit pas être vide
Email.agent.email = entrez une adresse mail valide
NotBlank.agent.phone = le téléphone ne peut pas être vide
NotBlank.agent.gender = veuillez choisir un genre
Past.agent.dateJoined = la date d'adhésion doit être dans le passé
NotNull.agent.dateJoined = vous devez choisir une date
DecimalMin.agent.averageSaleThisYear =  le chiffre de vente moyen doit être supérieur à {2}
```


## allAgents.jsp
```
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@ page contentType="text/html; charset=UTF-8" %>

    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="allagents.title" /> </title>
    </head>
       

    <spring:message code="welcome.message" /> 
    <body>
        <table style="width:100%">
            <tr>
            <th align="left"><spring:message code="label.id" /></th>
             <th align="left"><spring:message code="label.name" /></th>
             <th align="left"><spring:message code="label.fax" /></th>
             <th align="left"><spring:message code="label.phone" /></th>
             <th align="left"><spring:message code="label.email" /></th>
             <th align="left"><spring:message code="label.datejoined" /></th>
             <th align="left"><spring:message code="label.sales" /></th>
             <th align="left"><spring:message code="label.actions" /></th>
            </tr>
            <c:forEach items="${agentList}" var="agent"> 
                <tr>
                    <td>${agent.id}</td>
                    <td>${agent.name}</td>
                    <td>${agent.fax}</td>
                    <td>${agent.phone}</td>
                    <td>${agent.email}</td>
                    <td><fmt:formatDate  dateStyle="full" value="${agent.dateJoined}" /></td>
                    <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${agent.averageSaleThisYear}" /></td>
                    <td>
                     <a href="\AgentsCRUD\agent\delete?id=${agent.id}"><spring:message code="label.delete" /></a>
                     <spring:url value="/agent/edit/${agent.id}" var="editURL"/>
                     <a href="${editURL}"><spring:message code="label.edit" /></a>
                     <a href="\AgentsCRUD\agent\add"><spring:message code="label.insert" /></a>
                    </td>
                  
                </tr>
            </c:forEach>
        </table>
    </body>
</html>



```
## addAgent.jsp
```
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>              
        <h1><spring:message code="addagentform.header" /> </h1>
        <form:form method="POST" action="/AgentsCRUD/agent/addAgent" modelAttribute="agent">
            <table>
                <tr> 
                    <td><form:label path="id"><spring:message code="label.id" /></form:label></td>
                    <td><form:input path="id"/></td> 
                    <td style="color:red"><form:errors path="id"/> </td>
               </tr> 
                <tr>
                    <td><form:label path="name"><spring:message code="label.name" /></form:label></td>
                    <td><form:input path="name" /></td>
                    <td style="color:red"><form:errors path="name"/> </td>
                </tr>
                <tr>
                    <td><form:label path="phone"><spring:message code="label.phone" /></form:label></td>
                    <td><form:input path="phone"/></td>
                    <td style="color:red"><form:errors path="phone"/> </td>
                    
                </tr>
                <tr>
                    <td><form:label path="fax"><spring:message code="label.fax" /></form:label></td>
                    <td><form:input path="fax"/></td>
                    <td style="color:red"> <form:errors path="fax"/> </td>
                </tr>
               <tr>
                    <td><form:label path="email"><spring:message code="label.email" /></form:label></td>
                    <td><form:input path="email"/></td>
                    <td style="color:red"> <form:errors path="email"/> </td>
                </tr>
                <tr> 
                    <td><form:label path="gender"><spring:message code="label.gender" /></form:label></td>
                    <td><form:radiobutton path="gender" value="Male"/><spring:message code="label.gender.male" />
                        <form:radiobutton path="gender" value="Female"/><spring:message code="label.gender.female" />
                    </td>
                     <td style="color:red"> <form:errors path="gender"/> </td>
                </tr>
                <tr>
                    
                    <td><form:label path="dateJoined"><spring:message code="label.datejoined" /></form:label></td>
                    <td><form:input type="date" path="dateJoined"/></td>
                    <td style="color:red"> <form:errors path="dateJoined"/> </td>
                   
                </tr>
                <tr>
                    <td><form:label path="averageSaleThisYear"><spring:message code="label.sales" /></form:label></td>
                    <td><form:input path="averageSaleThisYear"/></td>
                    <td style="color:red"> <form:errors path="averageSaleThisYear"/> </td>
                </tr>
                <tr>
                    <spring:message code="submit.button" var="labelSubmit"></spring:message>
                    <td><input type="submit" value="${labelSubmit}"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
```
## Agent.java
```

import java.util.Date;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Agent {
 
    @Min(value = 10)
    private int id;
     
    @Size(min = 10)
    private String name;
    
    @NotBlank
    private String fax;

    @NotBlank
    private String phone;
    
    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String gender;
    
    @NotNull
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateJoined;
    
    @DecimalMin(value = "0.0")
    private double averageSaleThisYear;
    
    public Agent() {
    }

    public Agent(int id, String name, String fax, String phone, String email, String gender, Date dateJoined, double averageSaleThisYear) {
        this.id = id;
        this.name = name;
        this.fax = fax;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.dateJoined = dateJoined;
        this.averageSaleThisYear = averageSaleThisYear;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dateJoined
     */
    public Date getDateJoined() {
        return dateJoined;
    }

    /**
     * @param dateJoined the dateJoined to set
     */
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    /**
     * @return the averageSaleThisYear
     */
    public double getAverageSaleThisYear() {
        return averageSaleThisYear;
    }

    /**
     * @param averageSaleThisYear the averageSaleThisYear to set
     */
    public void setAverageSaleThisYear(double averageSaleThisYear) {
        this.averageSaleThisYear = averageSaleThisYear;
    }  
    
    
    @Override
    public String toString() {
        return "Name: " + getName() + "\t" +
               "Email: "+ getEmail() + "\t" +
               "Fax: " + getFax() + "\t" + 
               "ID: " + getId() + "\t" + 
               "Phone: " + getPhone()+ "\t" +
               "Gender: " + getGender() + "\t" +
               "Date Joined " + getDateJoined() + "\t" + 
               "Total Sales "  + getAverageSaleThisYear();
                
    }
}
```
