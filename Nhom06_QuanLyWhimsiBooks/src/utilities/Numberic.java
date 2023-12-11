package utilities;

import java.text.DecimalFormat;

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
	
	public static double roundNumber(double x) {
		return Math.floor(x/1000) * 1000;
	}
	
	public static String roundNumberAndFormat(String format, double x) {
		return String.format(format, roundNumber(x));
	}
	
	public static String roundNumberAndFormatVND(double x) {
		DecimalFormat df = new DecimalFormat("#,### VND");
		return df.format(roundNumber(x));
	}
	
	public static String formatVND(double x) {
		DecimalFormat df = new DecimalFormat("#,### VND");
		return df.format(x);
	}
	
	public static String formatD(double x) {
		DecimalFormat df = new DecimalFormat("#,### đ");
		return df.format(x);
	}
}
