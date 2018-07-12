package com.livevox.phonebook.dao;

import java.util.List;

import com.livevox.phonebook.web.model.Contact;

/**
 * Interface for the Data Access Object
 */
public interface ContactDao {
	
	/**
	 * Creates a new contact 
	 * @param contact a Contact object
	 */
	public void save(Contact contact);
	
	/**
	 * Searches for a Contact given a search criteria
	 * @param queryCriteria Search Criteria
	 * @return List of Contacts found. It might be zero.
	 */
	public List<Contact> search(String queryCriteria);
	
	/**
	 * Returns all Contacts available 
	 * @return List of available Contacts found. It might be zero.
	 */
	public List<Contact> getAll();
}
