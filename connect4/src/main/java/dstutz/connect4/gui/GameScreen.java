package dstutz.connect4.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dstutz.connect4.common.DropColor;

public class GameScreen extends Observable {
	private JLabel lblYellowPlayer;
	private JLabel lblRedPlayer;
	// private int player1Turns;
	// private int player2Turns;
	private JLabel labelnextDrop;
	private JLabel lblYellowDrops;
	private JLabel lblRedDrops;
	private JLabel lblPlayers;

	private JFrame frame;
	private JLabel nextDropLabel;
	private SlotPanel activeSlotPanel;

	/**
	 * @return the activeSlotPanel
	 */
	public SlotPanel getActiveSlotPanel() {
		return activeSlotPanel;
	}

	/**
	 * @param activeSlotPanel
	 *            the activeSlotPanel to set
	 */
	public void setActiveSlotPanel(SlotPanel activeSlotPanel) {
		this.activeSlotPanel = activeSlotPanel;
	}

	private int[] gameData;

	private final int COLUMNS = 7;
	private final int ROWS = 7;
	private final SlotPanel[][] board = new SlotPanel[COLUMNS][ROWS];

	public void setBoard_slot(int col, int row, DropColor dropColor) {
		Color color = new Color(255, 255, 255); // white
		if (dropColor.toString() == "YELLOW") {
			color = new Color(252, 255, 00);
		} else if (dropColor.toString() == "RED") {
			color = new Color(0, 255, 255);
		}
		board[col][row].setForeground(color);
	}

	public void setBoard_slot(SlotPanel slotPanel, DropColor dropColor) {
		Color color = new Color(255, 255, 255); // white
		if (dropColor.toString().equals("YELLOW")) {
			color = new Color(252, 255, 00);
		} else if (dropColor.toString().equals("RED")) {
			color = new Color(0, 255, 255);
		}
		slotPanel.setForeground(color);
	}

	public void setStartData(String[] gameSetupData, DropColor dropColor) {
		lblPlayers.setText("Match: " + gameSetupData[0] + " vs "
				+ gameSetupData[1]);
		lblYellowPlayer.setText("Yellow player: " + gameSetupData[0]);
		lblRedPlayer.setText("Red player: " + gameSetupData[1]);
		lblYellowDrops.setText("Yellow drops: " + gameSetupData[2]);
		lblRedDrops.setText("Red drops: " + gameSetupData[3]);

		if (dropColor.toString().equals("YELLOW")) {
			labelnextDrop.setText("Next Drop: " + gameSetupData[0]);
		} else if (dropColor.toString().equals("RED")) {
			labelnextDrop.setText("Next Drop: " + gameSetupData[1]);
		}
	}

	//
	public void resetGame() {
		resetBoard();
	}

	private void resetBoard() {
		for (SlotPanel[] list : board) {
			for (SlotPanel cs : list) {
				cs.setForeground(Color.WHITE);
			}
		}
	}

	public void setFrame(boolean status) {
		this.frame.setVisible(status);
	}

	/**
	 * Create the application.
	 */
	public GameScreen() {
		// the board object contains 42 SlotPanel objects
		// the 2 dimensional array has the dimension [7][6]
		// it represents the boards columns and rows.
		final double padding = 4.0;
		final double panelWidth = 96.0;

		for (int i = 0; i < COLUMNS; ++i) {
			for (int j = 0; j < ROWS; ++j) {
				board[i][j] = new SlotPanel(padding, panelWidth - 2 * padding);
			}
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1068, 814);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(10, 146, 700, 600);
		frame.getContentPane().add(boardPanel);
		boardPanel.setLayout(null);
		boardPanel.setBackground(Color.BLUE);

		// - Setzt die Bounds von allen CircleShape Objekten
		// - fuegt jedem SlotPanel Objekt ein MouseListener hinzu
		// - Hinzuf�gen der SlotPanel Objekte zum Board
		int x = 7, y = 7;
		for (int i = 0; i < board.length; ++i) {
			y = 7;
			for (int j = 0; j < 6; ++j) {
				board[i][j].setBounds(x, y, 96, 96);
				board[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						setBoard_slot((SlotPanel) e.getSource(),
								DropColor.YELLOW);
						activeSlotPanel = (SlotPanel) e.getSource();
						// e.getSource gibt eine Referenz auf das
						// gedrueckte Komponenten/Objekt zurueck.
						notifyController("slots");
					}
				});
				boardPanel.add((JPanel) board[i][j]);
				y += 98;
			}
			x += 98;
		}

		// Other labels
		labelnextDrop = new JLabel("Next drop: gamer2");
		labelnextDrop.setBounds(10, 11, 345, 25);
		frame.getContentPane().add(labelnextDrop);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(623, 11, 345, 131);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel labelgameResult = new JLabel("game 1 wons the match");
		labelgameResult.setBounds(10, 11, 325, 43);
		panel_1.add(labelgameResult);

		JButton newGameButton = new JButton("New game");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newGameButton.setBounds(22, 86, 147, 23);
		panel_1.add(newGameButton);

		JButton playAgainButton = new JButton("Play again");
		playAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		playAgainButton.setBounds(186, 86, 138, 23);
		panel_1.add(playAgainButton);

		JPanel panel = new JPanel();
		panel.setBounds(720, 146, 249, 347);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblPlayers = new JLabel("Match: ");
		lblPlayers.setBounds(10, 11, 229, 14);
		panel.add(lblPlayers);

		JLabel lblGameStatistics = new JLabel("Game Statistics: ");
		lblGameStatistics.setBounds(10, 68, 229, 14);
		panel.add(lblGameStatistics);

		lblYellowPlayer = new JLabel("Yellow player :");
		lblYellowPlayer.setBounds(10, 93, 229, 14);
		panel.add(lblYellowPlayer);

		lblYellowDrops = new JLabel("Yellow drops: ");
		lblYellowDrops.setBounds(10, 109, 229, 14);
		panel.add(lblYellowDrops);

		lblRedPlayer = new JLabel("Red player: ");
		lblRedPlayer.setBounds(10, 134, 229, 14);
		panel.add(lblRedPlayer);

		lblRedDrops = new JLabel("Red drops:");
		lblRedDrops.setBounds(10, 146, 229, 14);
		panel.add(lblRedDrops);

		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(10, 177, 229, 14);
		panel.add(lblDuration);
	}

	public void notifyController(String slots) {
		// Eine Klasse, deren Exemplare sich beobachten lassen, muss jede
		// Änderung des Objektzustands nach außen hin mitteilen. Dazu bietet die
		// Klasse Observable die Methoden setChanged() und notifyObservers() an.
		// Mit setChanged() wird die Änderung angekündigt, und mit
		// notifyObservers() wird sie tatsächlich übermittelt. Gibt es keine
		// Änderung, so wird notifyObservers() auch niemanden benachrichtigen.
		super.setChanged(); // Eine Änderung ist aufgetreten
		int activeColumn = 1;

		// finde aktive gedrueckte Spalte
		for (int i = 0; i < COLUMNS; ++i) {
			for (int j = 0; j < ROWS; ++j) {
				if (board[i][j].equals(activeSlotPanel)) {
					activeColumn = i + 1;
				}
			}
		}

		// System.out.println("Welche Spalte hat er gefunden ? " +
		// activeColumn);

		if (slots.equals("slots")) {
			super.notifyObservers(activeColumn); // Informiere Observer über
													// Änderung
		} else {
			super.notifyObservers(getActiveSlotPanel());
		}
	}

	public void setGameData(int[] gameData, DropColor activeDropColor) {
		// this.gameData[0] = gameData[0];
		// this.gameData[1] = gameData[1];
		// this.gameData[2] = gameData[2];
		// this.gameData[3] = gameData[3];

		Color color = new Color(255, 255, 255); // white
		if (activeDropColor.toString() == "YELLOW") {
			color = new Color(252, 255, 00);
		} else if (activeDropColor.toString() == "RED") {
			color = new Color(0, 255, 255);
		}
		board[gameData[0]][gameData[1]].setForeground(color);
		System.out.println("Spalte: " + gameData[0] + " Zeile: " + gameData[1]);
		// TODO Auto-generated method stub
		this.gameData = gameData;
	}
}
