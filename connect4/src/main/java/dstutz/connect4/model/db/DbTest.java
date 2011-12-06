/**
 * 
 */
package dstutz.connect4.model.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.Assert;
import dstutz.connect4.model.db.utils.DatabaseSetup;

/**
 * @author Daniel Stutz
 * 
 */
public class DbTest {
	private final DatabaseSetup databaseSetup;
	private final String driverName = "org.h2.Driver";
	private final String username = "sa";
	private final String password = "";
	private final String url = "jdbc:h2:tcp://localhost/~/DB/EDU/DBBASICS;SCHEMA_SEARCH_PATH=DBBASICS";
	public String[] data = { "Daniel", "Stutz", "true", "1985-09-11" };
	public String firstname;
	public String lastname;
	public boolean pStatus;
	public String date;
	public DbTest dbtest;

	public static void main(String[] args) {
		System.out.println("Kann diese Klasse gestartet werden ? ");
		DbTest test = new DbTest(databaseSetup);

		init();
	}

	/**
	 * 
	 */
	public DbTest() {
		// TODO Auto-generated constructor stub

	}

	public void init() {
		DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username,
				password, url);
		dbtest = new DbTest(databaseSetup);
	}

	/**
	 * 
	 */
	public DbTest(DatabaseSetup databaseSetup) {
		// TODO Auto-generated constructor stub
		this.databaseSetup = databaseSetup;
	}

	public String getPersonFromDB() {
		String str = "";

		return str;
	}

	public void testGetPerson() {
		// insert person
		DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username,
				password, url);
		// PersonDao personDao = new PersonDaoJDBCImpl(databaseSetup);

		// Person person =
		// TestPersonFactory.createPerson("Rolf", "Keller", true, new
		// GregorianCalendar(1985, Calendar.MAY, 13));
		GregorianCalendar birthday = new GregorianCalendar(1974, Calendar.MAY,
				11);
		Person person = new Person();
		person.setActiv(true);
		person.setBirthday(birthday.getTime());
		person.setFirstname(firstname);
		person.setLastname(lastname);

		personDao.insertPerson(person);
		idsToDelete.add(person.getId());

		// get the person
		Person personFromDatabase = personDao.getPerson(person.getId());

		// assertions
		Assert.assertNotNull("person not found in database", personFromDatabase);
		Assert.assertEquals("id is not equals", person.getId(),
				personFromDatabase.getId());
	}

	public Person getPerson(Long id) {

		List<Person> result = executeQuery("WHERE ID=" + id);
		if (result.size() > 0) {
			return result.get(0);
		}

		return null;
	}

	private List<Person> executeQuery(String clause) {

		Connection connection = null;
		Statement stmt = null;

		List<Person> results = new ArrayList<Person>();
		try {
			connection = databaseSetup.getConnection();
			stmt = connection.createStatement();

			ResultSet resultSet = stmt.executeQuery(SELECT_BODY + clause);

			while (resultSet.next()) {
				results.add(mapResultSetEntry(resultSet));
			}

		} catch (Exception e) {
			throw new DatabaseException("executeQuery failed", e);
		} finally {
			try {
				if (null != stmt) {
					stmt.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (final SQLException e) {
				logger.error("close connection failed", e);
			}
		}

		return results;
	}
}
