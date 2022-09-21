import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void oracleDriverCreation() {
		DatabaseDriver dbDriver = new DatabaseDriverFactory()
				.withType("oracle")
				.withUrl("localhost:1521@orcl")
				.getDatabaseDriver();
		assertTrue("Check if Oracle Driver is created correctly", dbDriver instanceof OracleDatabaseDriver);
	}
	
	@Test
	public void mysqlDriverCreation() {
		DatabaseDriver dbDriver = new DatabaseDriverFactory()
				.withType("mysql")
				.withUrl("mysql:7707@sql")
				.getDatabaseDriver();
		assertTrue("Check if MySql Driver is created correctly", dbDriver instanceof MySqlDatabaseDriver);
	}

}
