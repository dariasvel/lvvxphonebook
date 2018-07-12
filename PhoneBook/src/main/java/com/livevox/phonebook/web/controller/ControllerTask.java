package com.livevox.phonebook.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.livevox.phonebook.dao.ContactDao;
import com.livevox.phonebook.web.model.AjaxResponse;
import com.livevox.phonebook.web.model.Contact;

/**
 * Service class that handles the interaction with the Data Access Object.
 * In the DAO pattern this class acts as the Business Object, handling the logic
 * before and after the interaction with the DAO.
 *
 */
@Service
public class ControllerTask {
	
	@Autowired
	private ContactDao contactDao;
	
	/**
	 * Saves a contact in the DB handling response and exceptions.
	 * Creation of new Contacts does not allow duplicated contacts.
	 * @param contact a Contact object
	 * @return AjaxResponse with success or error message
	 */
	public AjaxResponse saveContact(Contact contact) {
		AjaxResponse response = new AjaxResponse("Done", "Success");
		try{
			contactDao.save(contact);
		}catch (DuplicateKeyException duplicateKeyException) {
			//Table is configured to don't accept duplicated contacts
			//This avoid a call to the DB just to verify if a contact already exists
			response.setStatus("Error");
			response.setData("Contact alreay exist in PhoneBook");
		}catch (Exception exception) {
			response.setStatus("Error");
			response.setData(exception.getMessage());
		}
		return response;
		
	}
	
	/**
	 * Searches a Contact by the given search criteria. The criteria is used
	 * to find the Contact by any of its properties.
	 * Handles response and exceptions
	 * @param searchCriteria search criteria
	 * @return AjaxResponse with search results or error message
	 */
	public AjaxResponse searchContact(String searchCriteria){
		String queryCriteria = StringUtils.defaultIfEmpty(searchCriteria, "").replaceAll("[\\-\\+\\(\\)]", "");
		AjaxResponse response = new AjaxResponse("Done", "Success");
		List<Contact> result = new ArrayList<Contact>();
		try {
			result = contactDao.search(queryCriteria.toLowerCase());
			if(result.isEmpty()) {
				response.setStatus("Error");
				response.setData("Contact not found");
			}else {
				response.setData(result);
			}		
		}catch (Exception exception) {
			response.setStatus("Error");
			response.setData(exception.getMessage());
		}
		return response;
		
	}
	
	/**
	 * Gets all available Contacts in the DB. It handles response and exceptions
	 * @return AjaxResponse with result or error message
	 */
	public AjaxResponse getAllContacts(){
		AjaxResponse response = new AjaxResponse("Done", "Success");
		List<Contact> result = new ArrayList<Contact>();
		try {
			result = contactDao.getAll();
			response.setData(result);		
		}catch (Exception exception) {
			response.setStatus("Error");
			response.setData(exception.getMessage());
		}
		return response;
	}
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

}
