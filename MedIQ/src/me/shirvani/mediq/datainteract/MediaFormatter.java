package me.shirvani.mediq.datainteract;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MediaFormatter {
	
	// returns scaled imageicon
	public static ImageIcon scaleImageIcon(ImageIcon img, int newX, int newY) {
		return new ImageIcon(img.getImage().getScaledInstance(newX, newY, Image.SCALE_SMOOTH));
	}
	
}
