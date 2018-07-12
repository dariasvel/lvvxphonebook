package com.livevox.phonebook.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.livevox.phonebook.web.model.Contact;

/**
 * Implementation of the Data Access Object
 * Encapsulates the interaction with the DB using the JdbcTemplate which
 * simplifies the use of JDBC helping to avoid common errors and providing thread safety.
 *
 */
public class ContactDaoImpl implements ContactDao {
	
	private DataSource dataSource;
	
	//SQL statements
	private static final String CREATE_SQL = "INSERT INTO contact (first_name,last_name,phone_number) VALUES (?,?,?)";
	private static final String GETALL_SQL = "SELECT * FROM contact ORDER BY first_name ASC";
	private static final String SEARCH_SQL = "SELECT * FROM contact WHERE LOWER(first_name) LIKE ? OR "
			+ "LOWER(last_name) LIKE ? OR REPLACE(phone_number, '-', '') LIKE ?"; 

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @see ContactDao#save(Contact)
	 */
	@Override
	public void save(Contact contact) {
        JdbcTemplate createTemplate = new JdbcTemplate(dataSource);
        createTemplate.update(CREATE_SQL,
                new Object[]{contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber()});
	}

	/**
	 * @see ContactDao#search(String)
	 */
	@Override
	public List<Contact> search(String searchCriteria) {
		JdbcTemplate searchTemplate = new JdbcTemplate(dataSource);
		return searchTemplate.query(SEARCH_SQL, 
				new Object[]{"%"+searchCriteria+"%", "%"+searchCriteria+"%", "%"+searchCriteria+"%"}, 
				new ContactRowMapper());
	}

	/**
	 * @see ContactDao#getAll()
	 */
	@Override
	public List<Contact> getAll() {
        JdbcTemplate getAllTemplate = new JdbcTemplate(dataSource);
        return getAllTemplate.query(GETALL_SQL, new ContactRowMapper());
	}

}
