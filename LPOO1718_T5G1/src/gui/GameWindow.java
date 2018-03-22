package gui;

import java.awt.EventQueue;
import logic.*;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import logic.Guard.GuardType;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class GameWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnUp;
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnDown;
	private JButton btnExit;

	Game jogo;
	GraphicsPanel painel = new GraphicsPanel();
	String oldmapping ="";
	String newmapping ="";
	int charpos = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
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
	public GameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Courier New", Font.PLAIN, 9));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0 };
		// gridBagLayout.columnWeights = new double[]{0.0, 1.0};

		gridBagLayout.columnWidths = new int[] { 10, 100, 100, 90, 70, 70, 10 };// 2
		gridBagLayout.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 };// 2

		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Number of Ogres");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setLabelFor(lblNewLabel);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Guard personality");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.BOLD, 10));
		comboBox.setModel(new DefaultComboBoxModel(GuardType.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		frame.getContentPane().add(comboBox, gbc_comboBox);

		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.BOLD, 15));
		textArea.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		textArea.setMargin(new Insets(10, 10, 10, 10));
		gbc_textField_1.ipadx = 2;
		gbc_textField_1.ipady = 2;
		gbc_textField_1.gridheight = 7;
		gbc_textField_1.gridwidth = 3;
		// gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		frame.getContentPane().add(textArea, gbc_textField_1);
		textArea.setColumns(10);

		btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enableButtons();
				jogo = new Game(Integer.parseInt(textField.getText()), comboBox.getSelectedItem());
				
			
				textArea.setBackground(Color.WHITE);
				jogo.board = new Level(1);
				Hero heroi = new Hero(1, 1);
				jogo.setHero(heroi);

				// cria guarda do tipo escolhido na combo box
				Guard grd = new Guard(1, 8, GuardType.valueOf(comboBox.getSelectedItem().toString()));
				jogo.setGuard(grd);

				if (textField.getText().equals(""))
					JOptionPane.showMessageDialog(frame, "You have to insert a positive number!");
				else {

					// perguntar Ricardo como implementou multiplos Ogres
					// jogo.setOgre(Integer.parseInt(textField.getText()));

					jogo.showGame();// mete em mapping
					textArea.setText(jogo.mapping);// transfere a string mapping para o textField
				}

				lblNewLabel_2.setText("Click On buttons to move the hero.");
			}
		});

		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 2;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movement(8);
			}

		});
		btnUp.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_btnUp = new GridBagConstraints();
		gbc_btnUp.gridwidth = 2;
		gbc_btnUp.insets = new Insets(0, 0, 5, 0);
		gbc_btnUp.gridx = 4;
		gbc_btnUp.gridy = 4;
		frame.getContentPane().add(btnUp, gbc_btnUp);

		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movement(4);
			}

		});
		btnLeft.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_btnLeft = new GridBagConstraints();
		gbc_btnLeft.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeft.gridx = 4;
		gbc_btnLeft.gridy = 5;
		frame.getContentPane().add(btnLeft, gbc_btnLeft);

		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movement(6);
			}

		});
		btnRight.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_btnRight = new GridBagConstraints();
		gbc_btnRight.insets = new Insets(0, 0, 5, 0);
		gbc_btnRight.gridx = 5;
		gbc_btnRight.gridy = 5;
		frame.getContentPane().add(btnRight, gbc_btnRight);

		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movement(2);
			}
		});
		btnDown.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_btnDown = new GridBagConstraints();
		gbc_btnDown.gridwidth = 2;
		gbc_btnDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnDown.gridx = 4;
		gbc_btnDown.gridy = 6;
		frame.getContentPane().add(btnDown, gbc_btnDown);

		lblNewLabel_2 = new JLabel("You can start a new game");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 9;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridwidth = 2;
		gbc_btnExit.insets = new Insets(0, 0, 0, 5);
		gbc_btnExit.gridx = 4;
		gbc_btnExit.gridy = 8;
		frame.getContentPane().add(btnExit, gbc_btnExit);
	}

	public void movement(int dir) {

		if (jogo.gameover) {
			lblNewLabel_2.setText("GAME OVER");
			textArea.setBackground(Color.RED);
			disableButtons();
		} else if (jogo.passed) {
			lblNewLabel_2.setText("Player One Wins");
			textArea.setBackground(Color.GREEN);
			disableButtons();
			// passar para o nivel dois;
		} else {
			oldmapping = jogo.mapping;
			lblNewLabel_2.setText("go on");
			jogo.move(dir);
					

			jogo.showGame();// mete em mapping
			if ((charpos=jogo.mapping.compareTo(oldmapping))>0) {
				System.out.println(charpos);
				painel.repaint();
			};	
			textArea.setText(jogo.mapping);// transfere a string mapping para o textField
			//newmapping = jogo.mapping;
			
			
			
		}

	}

	public void disableButtons() {
		btnUp.setEnabled(false);
		btnDown.setEnabled(false);
		btnRight.setEnabled(false);
		btnLeft.setEnabled(false);
	}

	public void enableButtons() {
		btnUp.setEnabled(true);
		btnDown.setEnabled(true);
		btnRight.setEnabled(true);
		btnLeft.setEnabled(true);
	}

}