package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ultilities.EnviromentConfigs;
import ultilities.ErrorMessage;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();
	private static Connection conn = null;
	private static EntityManager em = null;

	public static void connect() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=" + EnviromentConfigs.DB_DATABASE +";trustServerCertificate=true";
			conn = DriverManager.getConnection(url, EnviromentConfigs.DB_USERNAME, EnviromentConfigs.DB_PASSWORD);
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Whimsibook-MSSQL-Production");
			em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectDB getInstance() {
		return instance;
	}
	
	public static EntityManager getEntityManager() {
		return em;
	}

	@Deprecated
	public static Connection getConnection() {
            if (conn == null) {
            	System.out.println("This function is dprecated, please use getEntityManager() instead");
            }
            return conn;
	}
	
	@Deprecated
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}
}
