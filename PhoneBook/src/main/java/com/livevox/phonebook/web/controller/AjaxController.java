package com.livevox.phonebook.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livevox.phonebook.web.model.AjaxResponse;
import com.livevox.phonebook.web.model.Contact;

/**
 * Controller to handle Async requests.
 * Uses @RestController annotation which is a convenience annotation
 * that is itself annotated with @Controller and @ResponseBody.
 *
 */
@RestController
@RequestMapping("/api/phonebook")
public class AjaxController {
	
	@Autowired
	private ControllerTask controllerTask;
	
	
	/**
	 * Creates a new contact in the Storage
	 * @param contact a Contact 
	 * @return AjaxResponse with status success and a list of all contacts
	 * 		   or status error with error message
	 */
	@PostMapping(value = "/save")
	public AjaxResponse saveContact(@RequestBody Contact contact) {		
		AjaxResponse responseSave = controllerTask.saveContact(contact);
		if("Error".equals(responseSave.getStatus())) {
			return responseSave;
		}	
		AjaxResponse response = controllerTask.getAllContacts();
		return response;
	}
	
	/**
	 * Gets all Contacts available in the Storage
	 * @return AjaxResponse with all Contacts or error message
	 */
	@GetMapping(value = "/getall")
	public AjaxResponse getAllContacts() {			
		AjaxResponse response = controllerTask.getAllContacts();
		return response;
	}
	
	/**
	 * Handles the search of Contacts
	 * @param searchCriteria used to search a Contact by any of the its properties
	 * @return AjaxResponse with found Contacts or error message
	 */
	@GetMapping(value = "/search")
	public AjaxResponse searchContacts(@RequestParam String searchCriteria) {
		AjaxResponse response  = controllerTask.searchContact(searchCriteria);
		return response;
	}
	
	public void setControllerTask(ControllerTask controllerTask) {
		this.controllerTask = controllerTask;
	}
	
}
