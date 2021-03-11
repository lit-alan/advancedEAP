
package com.sd4.model;

import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Author extends RepresentationModel<Author>  {
    
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long authorID;
    private String firstName;
    private String lastName;
    private int yearBorn;

    
}

