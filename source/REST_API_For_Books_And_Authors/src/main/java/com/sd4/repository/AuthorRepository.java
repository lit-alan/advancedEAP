
package com.sd4.repository;

import com.sd4.model.Author;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
 
    @Query("SELECT a FROM Author a WHERE a.firstName like :prefix%")
    public List<Author> getAuthorsWithPrefix(String prefix);
    
 
}
