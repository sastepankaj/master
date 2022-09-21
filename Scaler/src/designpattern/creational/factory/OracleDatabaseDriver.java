package designpattern.creational.factory;

public class OracleDatabaseDriver implements DatabaseDriver {
	private String driverUrl;
	public OracleDatabaseDriver(String driverUrl) {
		this.driverUrl = driverUrl;
	}
    @Override
    public void connect() {
        System.out.println("Connecting to Oracle Database " + driverUrl);
    }

    @Override
    public void query() {
        System.out.println("Querying Oracle Database");
    }

    @Override
    public void close() {
        System.out.println("Closing Oracle Database");
    }

}