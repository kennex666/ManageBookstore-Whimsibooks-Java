package exampleUsage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import bus.NhaCungCap_BUS;
import connectDB.ConnectDB;
import dao.DanhMuc_DAO;
import entities.DanhMuc;
import utilities.QueryBuilder;

public class QueryBuilder_Example {
	public static void main(String[] args) {
		
		// Thông thường tạo query truy vấn
		// SELECT * FROM NhanVien WHERE tienLuong < 1000000 OR ngayVaoLam > '2023-11-20'
		
		// Đó là khi bạn đã biết những con số này tồn tại
		// SELECT * FROM NhanVien WHERE tienLuong < ? OR ngayVaoLam > ?
		// Nhưng trường hợp bị null thì sao? Giả sử Date ngayVaoLam = null. Lúc này setDate sẽ lỗi
		
		//
		// SELECT * FROM NhanVien WHERE tienLuong < ? OR ngayVaoLam > null
		
		// Để tạo query tự động biết data có tồn tại hay không, đây là giải pháp.
		
		// Tuy nhiên truy vấn phức tạp hơn sẽ rất khó sử dụng.
		
		// Hàm này chỉ sử dụng khi bạn cần tìm kiếm nâng cao.
		QueryBuilder query = new QueryBuilder("SELECT * FROM NhanVien ? ORDER BY id");
		try {
			
			// Tiền lương < 1000000
			query.addParameter(QueryBuilder.Enum_DataType.DOUBLE, "tienLuong", "<", 100000);

			// Ngày vào làm nhỏ hơn ngày hiện tại
			query.addParameter(QueryBuilder.Enum_DataType.DATE, "ngayVaoLam", "<", new Date());
			
			// Tìm họ tên chứa chữ Bảo
			query.addParameter(QueryBuilder.Enum_DataType.STRING, "hoTen", "%?%", "Bảo");
			
			// Tìm họ tên bắt đầu là Bảo
			query.addParameter(QueryBuilder.Enum_DataType.STRING, "hoTen", "?%", "Bảo");


			
			// Trường hợp 1: Tạo ra query kiểu chuỗi
			System.out.println(query.generateQuery("OR")[1]);
		
			// Trường hợp 2: Connect lên database, tự động set PreparedStament
			//Giả sử muốn lấy thông tin nhân viên từ query trên, nhưng muốn chỉ chọn 1 trong 2
			// Do thoả mãn 1 trong 2 query trên, ta dùng OR thay vì AND
			
			
			//PreparedStatement pstm = query.setParamsForPrepairedStament(ConnectDB.getConnection(),"OR");
			//ResultSet rs = pstm.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
