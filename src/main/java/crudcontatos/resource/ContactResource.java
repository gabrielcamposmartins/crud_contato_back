package crudcontatos.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import crudcontatos.domain.Contact;
import crudcontatos.service.ContactService;

@RestController
@RequestMapping(value="/contacts")
public class ContactResource {

	@Autowired
	private ContactService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Contact>>findAll(){
		List<Contact> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contact> findById(@PathVariable int id) throws Exception{
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Contact contact) throws Exception{
		contact = service.insert(contact);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contact.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Contact> delete(@PathVariable int id) throws Exception{
		findById(id);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Contact contact, @PathVariable int id) throws Exception{
		contact.setId(id);
		contact = service.update(contact);
		return ResponseEntity.noContent().build();
	}
}
