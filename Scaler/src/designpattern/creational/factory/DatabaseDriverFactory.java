package designpattern.creational.factory;

public class DatabaseDriverFactory {
	private DriverDetails details = new DriverDetails();
    public DatabaseDriver getDatabaseDriver() {
        if (details.driverType.equalsIgnoreCase("mysql")) {
            return new MySqlDatabaseDriver(details.driverUrl);
        } else if (details.driverType.equalsIgnoreCase("oracle")) {
            return new OracleDatabaseDriver(details.driverUrl);
        }

        return null;
    }
    
    public DatabaseDriverFactory withUrl(String driverUrl) {
		this.details.driverUrl = driverUrl;
		return this;
	}
    public DatabaseDriverFactory withType(String driverType) {
		this.details.driverType = driverType;
		return this;
	}
    
    static class DriverDetails{
    	private String driverUrl;
    	private String driverType;
    }
    
}