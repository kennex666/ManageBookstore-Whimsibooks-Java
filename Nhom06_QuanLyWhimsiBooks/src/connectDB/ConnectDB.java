package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilities.ErrorMessage;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();
	private static Connection conn = null;

	public static void connect() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyNhaSachWhimsiBooks";
			conn = DriverManager.getConnection(url, "sa", "sapassword");
		} catch (SQLException e) {
		}
	}

	public static ConnectDB getInstance() {
		return instance;
	}

	public static Connection getConnection() {
            if (conn == null)
                if (!ErrorMessage.showConfirmDialogYesNo("Lỗi cơ sở dữ liệu", "Kết nối cơ sở dữ liệu thất bại! Bạn có muốn tiếp tục?"))
                    System.exit(500);
		return conn;
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}
}
