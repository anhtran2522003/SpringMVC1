package context;

import java.sql.Connection;
import java.sql.DriverManager;

//Add-ons (DBContext),  the class that establishes the connection with the data source

public class DBContext {
	public Connection getConnection() throws Exception {
		String connectionUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName="
				+ dbName;
		if (instance == null || instance.trim().isEmpty()) {
			connectionUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
					+ ";integratedSecurity=true;" + "encrypt=true;trustServerCertificate=true";

		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(connectionUrl, userID, password);

	}

	/* Insert your other code right after this comment */

	private final String serverName = "DESKTOP-AHDBN55";
	private final String dbName = "ShoppingDB";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "demo";
	private final String password = "25PhuTrantpth";

	public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

