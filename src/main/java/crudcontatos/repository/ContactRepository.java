package crudcontatos.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import crudcontatos.domain.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{

}
