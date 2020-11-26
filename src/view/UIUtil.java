package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UIUtil {

	public static void makeFrameFullSize(JFrame aFrame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	public static Dimension getFullScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize;
	}
}
