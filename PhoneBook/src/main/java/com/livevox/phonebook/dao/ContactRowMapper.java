package com.livevox.phonebook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import com.livevox.phonebook.web.model.Contact;

/**
 * Used by JdbcTemplate for mapping rows of a java.sql.ResultSet on a per-row basis. 
 * SQLExceptions will be caught and handled by the calling JdbcTemplate.
 */
public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setFirstName(StringUtils.capitalize(StringUtils.lowerCase(rs.getString(2))));
		contact.setLastName(StringUtils.capitalize(StringUtils.lowerCase(rs.getString(3))));
		contact.setPhoneNumber(rs.getString(4));
		return contact;
	}

}
