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

```
