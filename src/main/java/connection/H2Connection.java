package connection;

public class H2Connection extends AbstractConnection {

	@Override
	public String getDriver() {
		return "org.h2.Driver";
	}

	@Override
	public String getDatabaseUser() {
		return "admin";
	}

	@Override
	public String getDatabasePassword() {
		return "Admin1234";
	}

}
