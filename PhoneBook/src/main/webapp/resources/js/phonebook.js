/* Phonebook */
$(document).ready(function() {
	var homeURL = "http://localhost:8080/PhoneBook/";
	
	$("#contactTable").tablesorter();
	$("#searchResTable").tablesorter();

	resetDivs();
	$("#errorDiv p").hide();
	$("#errClose").click(function(){
		$("#errorDiv p").hide();
	});
	
	$("#resetAll").click(function(){
		$("#errorDiv p").hide();
		resetDivs()
	});
	
//------------------------- Get all Contacts on page load
	$.ajax({
		type : "GET",
		url : homeURL + "api/phonebook/getall",
		success: function(result){
			if(result.status == "Done"){
				displayAllContacts(result);
			}else{
				$("#errorDiv p").show();
				$("#errMsg").text(result.data);
			}
		},
		error : function(e) {
			$("#errorDiv p").show();
			$("#errMsg").text(""+e);
		}
	});

//------------------------- Create Contact
	//Submit Form
    $("#contactForm").submit(function(event) {
		event.preventDefault();
		$("#errorDiv p").hide();
		ajaxCreate();
	});
    
    function ajaxCreate(){ 
    	// form data
    	var formData = {
    		"firstName" : $("#firstName").val(),
    		"lastName" :  $("#lastName").val(),
    		"phoneNumber" : $("#phoneNumber").val()
    	}  	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : homeURL + "api/phonebook/save",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					displayAllContacts(result);
				}else{
					$("#errorDiv p").show();
					$("#errMsg").text(result.data);
				}
			},
			error : function(e) {
				$("#errorDiv p").show();
				$("#errMsg").text(""+e);
			}
		});   	
    	// Reset FormData after Posting
    	resetData();
    }
    
  //------------------------- Search Contacts
    
	//Submit Form
    $("#searchForm").submit(function(event) {
		event.preventDefault();
		$("#errorDiv p").hide();
		if($("#searchCriteria").val()){
			ajaxSearch();
		}
	});
    
    function ajaxSearch(){
    	// form data
    	var formData = {
    		"searchCriteria" : $("#searchCriteria").val()
    	}
    	$.ajax({
			type : "GET",
			url : homeURL + "api/phonebook/search",
			data : formData,
			success: function(result){
				if(result.status == "Done"){
					displaySearchRes(result);
				}else{
					$("#errorDiv p").show();
					$("#errMsg").text(result.data);
				}
			},
			error : function(e) {
				$("#errorDiv p").show();
				$("#errMsg").text(""+e);
			}
		});
    	$("#searchCriteria").val("");
    }

    //---------------------- Common functions
    
    function resetDivs(){
    	$("#searchResults").hide();
    	$("#divAllContacts").show();
    }
    
    function resetData(){
    	$("#firstName").val("");
    	$("#lastName").val("");
    	$("#phoneNumber").val("");
    }
    
    function displayAllContacts(result){
    	$("#divAllContacts").show();
    	$("#searchResults").hide();
		$('#contactTable tbody tr').remove();
		$.each(result.data, function(i, contact){
			var rowHtml = "<tr><td>" + contact.firstName + 
			"</td><td>" + contact.lastName + 
			"</td><td>" + contact.phoneNumber + "</td></tr>"; 
			$('#contactTable tbody').append(rowHtml);	
        });
		$("#contactTable").trigger("update"); 
    }
    
    function displaySearchRes(result){
    	$("#divAllContacts").hide();
    	$("#searchResults").show();
		$('#searchResTable tbody tr').remove();
		$.each(result.data, function(i, contact){
			var rowHtml = "<tr><td>" + contact.firstName + 
			"</td><td>" + contact.lastName + 
			"</td><td>" + contact.phoneNumber + "</td></tr>"; 
			$('#searchResTable tbody').append(rowHtml);	
        });
		$("#searchResTable").trigger("update");
    }
})
