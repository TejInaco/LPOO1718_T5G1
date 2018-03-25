package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.JComponent;
import java.awt.event.*;

public class guiLauncher {
	// Main program. Launches main window with the panel

	public static void main(String[] args) {
		JFrame f = new JFrame("Dungeons & Dragons");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(500, 500));
		GraphicsPanel panel = new GraphicsPanel();
		f.getContentPane().add(panel);
		f.pack();
		f.setVisible(true);
		panel.requestFocusInWindow();
		// to handlekeyboardevents
	}
}