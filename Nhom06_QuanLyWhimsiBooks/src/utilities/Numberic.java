package utilities;

public class Numberic {
	public static boolean isInteger(String x) {
		try {
			Integer.parseInt(x);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean isDouble(String x) {
		try {
			Double.parseDouble(x);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static double parseDouble(String x) {
		try {
			return Double.parseDouble(x);
		} catch (Exception e) {
			return -500;
		}
	}
	public static int parseInteger(String x) {
		try {
			return Integer.parseInt(x);
		} catch (Exception e) {
			e.printStackTrace();
			return -500;
		}
	}
}
