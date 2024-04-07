package com.itwill.ver03;

import java.util.ArrayList;

import com.itwill.ver01.Contact;
import com.itwill.ver02.ContactDao;

public class ContactDaoImpl implements ContactDao {

	private static ContactDaoImpl instance = null;

	private ContactDaoImpl() {
	}

	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}

	private Contact[] contacts = new Contact[MAX_LENGTH];
	private int count = 0;

	@Override
	public int create(Contact contact) {
		ArrayList<String> contacts = new ArrayList<String>();
		for (String s : contacts) {
			contacts.add(s);
		}
		return 0;
	}

	@Override
	public Contact[] read() {
		ArrayList<String> contacts = new ArrayList<String>();
		for (String s : contacts) {
			contacts.get(Integer.parseInt(s));
		}
		return null;
	}

	@Override
	public Contact read(int index) {
//		ArrayList<String> contact = new ArrayList<>();
//		for (int i : contact) {
//			
//		}
			return null;
	}

	@Override
	public int update(int index, Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

}
