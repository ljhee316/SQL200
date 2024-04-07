package com.itwill.ver02;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {

	
	
	
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {}
	
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	
	
	private Contact[] contacts = new Contact[MAX_LENGTH];
	
	private int count = 0;
	
	
	
	
	public boolean isMemoryFull() {
		return count == MAX_LENGTH;
	}
	
	public boolean isValidIndex(int index) {
		return (index >= 0 && index < count);
	}
	
	
	
	@Override
	public int create(Contact contact) {
		if (isMemoryFull()) {
			return 0;
		}
		contacts[count] = contact;
		count++;
		return 1;
	}
	
	@Override
	public Contact[] read() {
		Contact[] contact = new Contact[count];
		for(int i =0; i < count; i++) {
			contact[i] = contacts[i];
		}
		
		return contact;
	}

	@Override
	public Contact read(int index) {
		if(isValidIndex(index)) {
			return contacts[index];
		}else {
			return null;		
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if(isValidIndex(index)) {
			contacts[index].setName(contact.getName());
			contacts[index].setPhone(contact.getPhone());
			contacts[index].setEmail(contact.getEmail());
			return 1;
		}
		return 0;
	}

}
