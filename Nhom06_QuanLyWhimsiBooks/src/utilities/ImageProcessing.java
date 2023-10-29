package utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI_Login;

/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 * @description: 
 * 				1. Sử dụng để tạo Image có chất lượng cao
 * 				2. Fit image với label
 *
 */

public class ImageProcessing {
	public static void scaleImageFitToLabel(JLabel lbl, ImageIcon icon) {
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iconScale = new ImageIcon(imgScale);
		lbl.setIcon(iconScale);
	}
	
	public static ImageIcon generateImageIcon(URL u) {
		BufferedImage image;
		try {
			image = ImageIO.read(u);
	        // Create a new BufferedImage from the original image
	        BufferedImage scaledImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = scaledImage.createGraphics();
	        g2d.drawImage(image, 0, 0, null);
	        g2d.dispose();
			return new ImageIcon(scaledImage);
		} catch (IOException e) {
			return null;
		}
	}
        
        public static ImageIcon resizeIcon(ImageIcon imageIcon, int width, int height){
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            return new ImageIcon(newimg);  // transform it back
        }
}
