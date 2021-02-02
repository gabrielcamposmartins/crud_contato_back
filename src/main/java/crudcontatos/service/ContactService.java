package crudcontatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudcontatos.domain.Contact;
import crudcontatos.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository repo;
	
	public List<Contact> findAll(){
		return (List<Contact>)repo.findAll();
	}
	
	public Contact findById(int id) throws Exception {
		Contact contact = repo.findById(id).get();
		if(contact == null) {
			throw new Exception("Not found");
		}
		return contact;
	}
	
	public Contact insert (Contact contact) {
		return repo.save(contact);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public Contact update(Contact contact) {
		Contact newContact = repo.findById(contact.getId()).get();
		updateData(newContact, contact);
		return repo.save(newContact);
	}

	private void updateData(Contact newContact, Contact contact) {
		newContact.setName(contact.getName());
		newContact.setEmail(contact.getEmail());
	}

}
