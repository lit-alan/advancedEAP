
package com.sd4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long authorID;
    private String firstName;
    private String lastName;
    private int yearBorn;

    public Author() {
    }

    public Author(long authorID, String firstName, String lastName, int yearBorn) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

       public Author(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

    /**
     * @return the authorID
     */
    public long getAuthorID() {
        return authorID;
    }

    /**
     * @param authorID the authorID to set
     */
    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the yearBorn
     */
    public int getYearBorn() {
        return yearBorn;
    }

    /**
     * @param yearBorn the yearBorn to set
     */
    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }
    
}