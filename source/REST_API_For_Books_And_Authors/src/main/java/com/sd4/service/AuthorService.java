package com.sd4.service;

import com.sd4.model.Author;
import com.sd4.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    public Optional<Author> findOne(Long id) {
        return authorRepo.findById(id);
    }

    public List<Author> findAll() {
        return (List<Author>) authorRepo.findAll();
    }

    public long count() {
        return authorRepo.count();
    }

    public void deleteByID(long authorID) {
        authorRepo.deleteById(authorID);
    }

    public void saveAuthor(Author a) {
        authorRepo.save(a);
    }  
    
    public List<Author> getAuthorsWithPrefix(String prefix) {
        return authorRepo.getAuthorsWithPrefix(prefix);
    }
    
   
}//end class

