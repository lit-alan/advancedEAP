
package com.sd4.repository;

import com.sd4.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    
    @Query("SELECT b FROM Book b WHERE b.authorID = :id")
    public List<Book> getBooksByAuthor(Long id);
}
