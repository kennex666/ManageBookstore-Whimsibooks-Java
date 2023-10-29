package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testconnect {
    public static void main(String[] args) {
        // Thay đổi các thông tin kết nối dựa trên cấu hình của bạn
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyNhaSachWhimsiBooks;encrypt=false";
        String user = "sa";
        String password = "sapassword";

        Connection connection = null;
        try {
            // Nạp lớp driver (chỉ cần làm một lần)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối vào cơ sở dữ liệu
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");

  
            
            
            
            
            
      
    
            
            
            // Đóng kết nối khi bạn đã hoàn thành
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không thể nạp lớp driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi: Không thể kết nối đến cơ sở dữ liệu.");
            e.printStackTrace();
        }
    }

	public static Connection createConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}

