package crudcontatos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id_contact;
	String name;
	String phone;
	String email;
	
	public Contact() {
	}

	public Contact(int id, String name, String phone, String email) {
		this.id_contact = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public int getId() {
		return id_contact;
	}

	public void setId(int id) {
		this.id_contact = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_contact;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (id_contact != other.id_contact)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id_contact + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
}
