package gui;

import java.awt.*;
import javax.swing.*;

import logic.Game;
import logic.Guard;
import logic.Hero;
import logic.Level;
import logic.Guard.GuardType;

import java.awt.event.*;

//public class guiLauncher {
//	// Main program. Launches main window with the panel
//
//	public static void main(String[] args) {
//		JFrame f = new JFrame("Dungeons & Dragons");
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setPreferredSize(new Dimension(500, 500));
//		GraphicsPanel panel = new GraphicsPanel();
//		f.getContentPane().add(panel);
//		f.pack();
//		f.setVisible(true);
//		panel.requestFocusInWindow();
//		// to handlekeyboardevents
//	}
//}

public class guiLauncher {

	private JFrame frame;
	private JTextField textField;
	private Game jogo;
	private JTextArea textArea;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiLauncher window = new guiLauncher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiLauncher() {
		initialize();
	}

	public void processButtons(int dir) {		

		if ((jogo.gameover) && (jogo.ended)) {
			jogo.move(dir);
			jogo.showGame();
			textArea.setText(jogo.mapping);
		}
		
		if (jogo.ended)
			label.setText("You won.");
		else if (jogo.passed) {
			label.setText("Level up.");
			jogo.passed = false;
		} else if (jogo.gameover){
			label.setText("You lost.");
		}else{
			label.setText("Keep going...");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(399, 297, 97, 25);
		frame.getContentPane().add(btnExit);

		JLabel lblNumberOfOgres = new JLabel("Number of Ogres");
		lblNumberOfOgres.setBounds(12, 13, 125, 16);
		frame.getContentPane().add(lblNumberOfOgres);

		textField = new JTextField();
		textField.setBounds(166, 11, 37, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblGuardPersonality = new JLabel("Guard personality");
		lblGuardPersonality.setBounds(12, 48, 141, 16);
		frame.getContentPane().add(lblGuardPersonality);//, gbc_lblNewLabel_1);

		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(166, 45, 150, 22);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jogo = new Game(Integer.parseInt(textField.getText()), comboBox.getSelectedItem());
				
				
				textArea.setBackground(Color.WHITE);
				jogo.board = new Level(1);
				Hero heroi = new Hero(1, 1);
				jogo.setHero(heroi);

				// cria guarda do tipo escolhido na combo box
				Guard grd = new Guard(1, 8, GuardType.valueOf(comboBox.getSelectedItem().toString()));
				jogo.setGuard(grd);

				if (textField.getText().equals(""))
					JOptionPane.showMessageDialog(frame, "Only positives numbers allowed");
				else {

					// perguntar Ricardo como implementou multiplos Ogres
					// jogo.setOgre(Integer.parseInt(textField.getText()));

					jogo.showGame();// mete em mapping
					textArea.setText(jogo.mapping);// transfere a string mapping para o textField
				}
				
							
		

				label.setText("You can play now.");
			}
		});
		btnNewGame.setBounds(386, 77, 119, 25);
		frame.getContentPane().add(btnNewGame);

		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 20));
		textArea.setBounds(12, 77, 330, 245);
		frame.getContentPane().add(textArea);

		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processButtons(8);
			}
		});
		btnUp.setBounds(409, 135, 75, 25);
		frame.getContentPane().add(btnUp);

		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processButtons(4);
			}
		});
		btnLeft.setBounds(354, 173, 75, 25);
		frame.getContentPane().add(btnLeft);

		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processButtons(2);
			}
		});
		btnDown.setBounds(409, 211, 75, 25);
		frame.getContentPane().add(btnDown);

		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processButtons(6);
			}
		});
		btnRight.setBounds(455, 173, 75, 25);
		frame.getContentPane().add(btnRight);

		label = new JLabel("");
		label.setBounds(12, 334, 330, 16);
		frame.getContentPane().add(label);
	}
}