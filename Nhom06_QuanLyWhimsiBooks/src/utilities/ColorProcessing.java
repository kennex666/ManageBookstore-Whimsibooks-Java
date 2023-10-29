package utilities;

import java.awt.Color;
/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 * @description: 
 * 				1. Tạo mã màu RGB
 *
 */


/*
 * ColorProcessing.rgbColor(Màu red, màu green, màu blue); => Tựa với Color.RED, sẽ trả về Color., giống color bên CSS
 * ColorProcessing.rgbColor(0, 0, 0); => #000000, #000
 */
public class ColorProcessing {
	public static Color rgbColor(int r, int g, int b) {
		return new java.awt.Color(r,g,b);
	}
}
