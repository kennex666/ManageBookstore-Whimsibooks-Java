package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

public class QueryBuilder {
	private String query;
	public static enum Enum_DataType {
		STRING,
		INTEGER,
		DOUBLE,
		FLOAT,
		DATE,
		TIMESTAMP,
		BOOLEAN
	}
	private ArrayList<Object[]> params;
	
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public ArrayList<Object[]> getParams() {
		return params;
	}
	public void setParams(ArrayList<Object[]> params) {
		this.params = params;
	}
	
	/**
	 * Tạo query builder, truyền vào một chuỗi query.
	 * Hiện đang beta, chỉ có thể tạo query select
	 * 
	 * @param query 
	 * <b>SELECT ... FROM ...? .....</b>
	 * <br>EX original query: <b>SELECT * FROM NhaSach WHERE id = ? ORDER BY id DESC</b>
	 * <br> Write it into: 
	 * <b>SELECT * FROM NhaSach ? ORDER BY id DESC. </b>
	 * @param params ArrayList<Object[]>. Object[] needs follow this {datatype, colname, condition, value}
	 */
	public QueryBuilder(String query, ArrayList<Object[]> params) {
		super();
		this.query = query;
		if (params != null)
			this.params = params;
		else
			params = new ArrayList<Object[]>();
	}
	
	/**
	 * Tạo query builder, truyền vào một chuỗi query.
	 * Hiện đang beta, chỉ có thể tạo query select
	 * 
	 * @param query 
	 * <b>SELECT ... FROM ...? .....</b>
	 * <br>EX original query: <b>SELECT * FROM NhaSach WHERE id = ? ORDER BY id DESC</b>
	 * <br> Write it into: 
	 * <b>SELECT * FROM NhaSach ? ORDER BY id DESC. </b>
	 */
	public QueryBuilder(String query) {
		super();
		this.query = query;
		params = new ArrayList<Object[]>();
	}
	
	/**
	 * Tạo ra một parameter
	 *  
	 */
	public Object[] generateParameter( Enum_DataType dataType, String columnName, String condition, Object value) {
		if (columnName.isBlank() || condition.isBlank())
			return null;
		Object[] obj = {dataType, columnName, condition, value};
		return obj;
	}
	
	/**
	 * Thêm parameter vào query
	 * <br>
	 * Hỗ trợ toán tử '<', '>', '=', '>=', '<='
	 * <br>
	 * Kiểu chuỗi có thêm %. Ví dụ query '%a' sẽ được để ở condition
	 * có dạng '%a'.
	 * <br> Nếu tìm %a + chuỗi người dùng nhập, bạn sẽ có '%a?'
	 *  
	 */
	public void addParameter( Enum_DataType dataType, String columnName, String condition, Object value) throws Exception{
		Object[] obj = generateParameter(dataType, columnName, condition, value);
		if (obj == null) {
			throw new Exception("Khởi tạo parameter thất bại");
		}
		params.add(obj);
	}
	
	/**
	 * Truyền vào <b> conditionAll </b> là một phép toán tử giữa các param như <b>AND, OR</b>
	 */
	public Object[] generateQuery(String conditionsAll) {
		
		String tempQuery = getQuery();
		String paramsQuery = "WHERE";
		int numParamsQuery = 0;
		try {
			for (Object[] x : params) {
				String tempCondition = (String) x[2];
				String tempStr = "";
				if ((Enum_DataType) x[0] == Enum_DataType.STRING && tempCondition.contains("%")) {
					if (x[3] == null)
						continue;
					tempStr = (String) x[2];
					if (tempStr.length() < 1)
						continue;
					paramsQuery += (numParamsQuery++ < 1) ? " " + ((String) x[1]  + " = " )
							: " " + conditionsAll + " " + ((String) x[1]  + " = " );
				
					paramsQuery += "CONCAT('" +  tempStr.charAt(0) + "'";
					for (int j = 1; j < tempCondition.length(); j++) {
						paramsQuery += ", '" +  tempStr.charAt(j) + "'";
					}
					paramsQuery += ")";
				}else
				
				if (x[3] != null) {
					paramsQuery += (numParamsQuery++ < 1) ? " " + ((String) x[1] + " " + (String) x[2] + " ?")
							: " " + conditionsAll + " " + ((String) x[1] + " " + (String) x[2] + " ?");
				}
			}
			if (numParamsQuery > 0)
				tempQuery = tempQuery.replace("?", paramsQuery);
			Object[] obj = {numParamsQuery, tempQuery};
			return obj;
		}
		catch (Exception e){
			return null;
		}
	}
	
	/**
	 * Tự động set parameters, build theo dữ liệu lấy từ object
	 * <br>
	 * Thay vì phải tự kiểm tra dữ liệu có tồn tại hay không để set thì chức năng này sẽ làm thay bạn
	 * @param conn
	 * @param conditionForAll
	 * @return
	 */
	public PreparedStatement setParamsForPrepairedStament(Connection conn, String conditionForAll) {
		PreparedStatement pstm = null;
		try {
		Object[] obj = generateQuery(conditionForAll);
		if (obj == null)
			return null;
		String tempQuery = (String) obj[1];
		int numParamsQuery = 0;
		pstm = conn.prepareStatement(tempQuery);
		if ((int) obj[0] < 1)
			return pstm;
		
		for (Object[] x : params) {

			if (x[3] == null) {
				continue;
			}
			switch ((Enum_DataType) x[0]) {
				case BOOLEAN -> {
					pstm.setBoolean(++numParamsQuery, (boolean) x[3]);
				}
				case DATE -> {
					pstm.setDate(++numParamsQuery, new java.sql.Date(((Date) x[3]).getTime()));
				}
				case DOUBLE -> {
					pstm.setDouble(++numParamsQuery, (double) x[3]);
				}
				case FLOAT -> {
					pstm.setFloat(++numParamsQuery, (float) x[3]);
				}
				case INTEGER -> {
					pstm.setInt(++numParamsQuery, (int) x[3]);
				}
				case STRING -> {
					pstm.setString(++numParamsQuery, (String) x[3]);
				}
				case TIMESTAMP -> {
					pstm.setTimestamp(++numParamsQuery,  new java.sql.Timestamp(((Date) x[3]).getTime()));
				}
				default -> {
					return null;
				}
			
			}
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pstm;
		
		
	}
	
	public QueryBuilder() {
		super();
		params = new ArrayList<Object[]>();
	}
	@Override
	public String toString() {
		return "QueryBuilder [query=" + query + ", params=" + params + "]";
	}
	
	
	
	
	
}
