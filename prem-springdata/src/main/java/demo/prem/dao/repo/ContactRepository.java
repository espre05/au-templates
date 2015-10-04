package demo.prem.dao.repo;

import demo.prem.model.Contact;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{ //extends BaseRepository<Contact, Long> {
    Optional<Contact> findById(Long id);
    
}