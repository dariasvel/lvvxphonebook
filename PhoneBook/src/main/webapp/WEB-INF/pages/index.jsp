<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>PhoneBook</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.tablesorter.min.js"/>"></script>
	<script src="<c:url value="/resources/js/phonebook.js"/>"></script>
</head>
<body>
	<div class="container">
		<div class="pure-g">
			<div class="pure-u-1">
				<div class="header">
					<img class="logo" src="<c:url value="/resources/img/phonebook.png"/>" />
					<p>v 1.0</p>
				</div>
				
			</div>
		</div>
	    <div class="pure-g" id="errorDiv">
	       <div class="pure-u-1" style="width: 50%;margin-left:25%">
		   		<p class="errorp"><span id="errMsg">Error message</span>
		   		<span id="errClose">[Close]</span></p>
		   </div>
		</div>
		<div class="pure-g">
		    <div class="pure-u-sm-1 pure-u-1-3">
		    	<div class="box">
		    		<h2><i class="fa fa-user-plus"></i>New contact</h2>
		    		<form class="pure-form" id="contactForm">
					    <fieldset class="pure-group">
					        <input type="text" class="pure-input-1-2" placeholder="First Name" id="firstName">
					        <input type="text" class="pure-input-1-2" placeholder="Last Name" id="lastName">
					        <input type="tel" class="pure-input-1-2" placeholder="Phone 123-456-7890" 
					        pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" id="phoneNumber" title="Please provide a phone number in the form xxx-xxx-xxxx">
					    </fieldset>
					    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">
					    <i class="fa fa-user-plus"></i>Add</button>
					</form>
				</div>
			</div>
		    <div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-search"></i>Search contact</h2>
		    		<form class="pure-form" id="searchForm">
		    			<fieldset class="pure-group">
					    	<input type="text" class="pure-input-1-2" id="searchCriteria">
					     </fieldset>
					    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">
					    <i class="fa fa-search"></i>Search</button>
					</form>
				</div>
			</div>
			<div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-users"></i> Contacts</h2>
		    		<div id="divAllContacts">
		    			<table class="pure-table" id="contactTable">
						    <thead>
						        <tr>
						            <th>First Name</th>
						            <th>Last Name</th>
						            <th>Phone</th>
						        </tr>
						    </thead>
						    <tbody>
						    <!-- 
						        <tr>
						            <td>Arun</td>
						            <td>Kart</td>
						            <td>415-8679089</td>
						        </tr>
						        <tr>
						            <td>Juan</td>
						            <td>Torus</td>
						            <td>301-2390930</td>
						        </tr>
						        <tr>
						            <td>Nolux</td>
						            <td>Fernandez</td>
						            <td>310-2930291</td>
						        </tr>
						      -->
						    </tbody>
						</table>
					</div>
		    		<div id="searchResults">
			    		<h5><span id="resetAll"><i class="fa fa-refresh"></i>See All Contacts</span></h5>
		    			<table class="pure-table" id="searchResTable">
		    				<caption>Search Result</caption>
						    <thead>
						        <tr>
						            <th>First Name</th>
						            <th>Last Name</th>
						            <th>Phone</th>
						        </tr>
						    </thead>
						    <tbody>
						    </tbody>
						</table>
					</div>					
				</div>
			</div>
		</div>
	</div>
</body>
</html>