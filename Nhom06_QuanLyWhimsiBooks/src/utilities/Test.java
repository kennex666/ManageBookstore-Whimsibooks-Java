package utilities;

public class Test {
	private String tenTest;
	private int soLuongTest;
	
	
	
	public Test(String tenTest, int soLuongTest) {
		super();
		this.tenTest = tenTest;
		this.soLuongTest = soLuongTest;
	}
	public String getTenTest() {
		return tenTest;
	}
	public void setTenTest(String tenTest) {
		this.tenTest = tenTest;
	}
	public int getSoLuongTest() {
		return soLuongTest;
	}
	public void setSoLuongTest(int soLuongTest) {
		this.soLuongTest = soLuongTest;
	}
	@Override
	public String toString() {
		return this.getTenTest() + " - " + soLuongTest + " files";
	}
	
	
}
