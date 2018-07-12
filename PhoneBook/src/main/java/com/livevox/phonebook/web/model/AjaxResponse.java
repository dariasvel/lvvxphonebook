package com.livevox.phonebook.web.model;

/**
 * Generic response object for the Ajax requests.
 * It provides a status field to pass success or error
 * or other statuses to the caller
 * It also provides a generic Object to hold the
 * response data from the service call 
 *
 */
public class AjaxResponse {
	private String status;
	private Object data;	
	
	public AjaxResponse() {
		
	}
	
	public AjaxResponse(String status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}	
}
