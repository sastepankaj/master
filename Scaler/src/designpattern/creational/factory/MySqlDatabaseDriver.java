package designpattern.creational.factory;
public class MySqlDatabaseDriver implements DatabaseDriver {
	private String driverUrl;
	public MySqlDatabaseDriver(String driverUrl) {
		this.driverUrl = driverUrl;
	}
    @Override
    public void connect() {
        System.out.println("Connecting to MySql Database " + driverUrl);
    }

    @Override
    public void query() {
        System.out.println("Querying MySql Database");
    }

    @Override
    public void close() {
        System.out.println("Closing MySql Database");
    }
    
}