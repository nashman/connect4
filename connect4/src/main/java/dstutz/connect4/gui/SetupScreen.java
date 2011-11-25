package dstutz.connect4.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dstutz.connect4.common.SkillLevel;

public class SetupScreen extends Observable {

	private JFrame frame;
	private JTextField txtNameP1;
	private JTextField txtNameP2;
	private JLabel labelMessagebox;

	private JComboBox<SkillLevel> comboBox_levelP1;
	private JComboBox<SkillLevel> comboBox_levelP2;
	private String[] gameSetupData = new String[4];

	private final JRadioButton rdbtnPlayerH1 = new JRadioButton("Human");
	private final JRadioButton rdbtnPlayerH2 = new JRadioButton("Human");
	private final JRadioButton rdbtnPlayerAI1 = new JRadioButton("AI player");
	private final JRadioButton rdbtnPlayerAI2 = new JRadioButton("AI player");

	public void setFrame(boolean status) {
		this.frame.setVisible(status);
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	public void setMesssageBox(String text) {
		labelMessagebox.setText(text);
	}

	public SetupScreen getSetupData() {

		return this;
	}

	public String[] getSetupDataArr() {
		return gameSetupData;
	}

	public void setSetupDataArr() {
		System.out.println(rdbtnPlayerH1.getSelectedObjects());
		if (rdbtnPlayerH1.getSelectedObjects() == null) {
			gameSetupData[0] = "";
			SkillLevel sk = (SkillLevel) comboBox_levelP1.getSelectedItem();
			gameSetupData[2] = sk.name();

		} else {
			gameSetupData[0] = this.getTxtNameP1();
			gameSetupData[2] = "";
		}
		System.out.println(rdbtnPlayerH2.getSelectedObjects());
		if (rdbtnPlayerH2.getSelectedObjects() == null) {
			gameSetupData[1] = "";
			SkillLevel sk = (SkillLevel) comboBox_levelP2.getSelectedItem();
			gameSetupData[3] = sk.name();
		} else {
			gameSetupData[1] = this.getTxtNameP2();
			gameSetupData[3] = "";
		}
	}

	public String getTxtNameP1() {
		return txtNameP1.getText();
	}

	public String getTxtNameP2() {
		return txtNameP2.getText();
	}

	public String getComboBox_levelP1() {
		return "Weiss noch nicht"; // comboBox_levelP1.;
	}

	public JComboBox<SkillLevel> getComboBox_levelP2() {
		return comboBox_levelP2;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		labelMessagebox = new JLabel("messageBox");
		labelMessagebox.setBounds(10, 11, 504, 66);
		frame.getContentPane().add(labelMessagebox);

		// Player 2 area
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 88, 240, 130);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPlayer = new JLabel("Player 1");
		lblPlayer.setBounds(10, 6, 180, 14);
		panel_1.add(lblPlayer);

		rdbtnPlayerH1.setBounds(6, 27, 91, 23);
		rdbtnPlayerH1.setSelected(true);
		panel_1.add(rdbtnPlayerH1);

		rdbtnPlayerAI1.setBounds(6, 64, 91, 23);
		panel_1.add(rdbtnPlayerAI1);

		comboBox_levelP1 = new JComboBox<SkillLevel>();
		comboBox_levelP1.setModel(new DefaultComboBoxModel<SkillLevel>(
				SkillLevel.values()));
		comboBox_levelP1.setBounds(103, 65, 127, 22);
		panel_1.add(comboBox_levelP1);

		txtNameP1 = new JTextField();
		txtNameP1.setText("gamer1");
		txtNameP1.setBounds(103, 28, 127, 22);
		panel_1.add(txtNameP1);
		txtNameP1.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(273, 88, 240, 130);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("Player 2");
		label.setBounds(10, 5, 180, 14);
		panel_2.add(label);

		// Player 2 area
		rdbtnPlayerH2.setBounds(6, 26, 91, 23);
		rdbtnPlayerH2.setSelected(true);
		panel_2.add(rdbtnPlayerH2);

		rdbtnPlayerAI2.setBounds(6, 64, 91, 23);
		panel_2.add(rdbtnPlayerAI2);

		// Radio Button Group, um die gegenseitige Abhaengigkeit zu erstellen.
		ButtonGroup group_p1 = new ButtonGroup();
		group_p1.add(rdbtnPlayerH1);
		group_p1.add(rdbtnPlayerAI1);

		ButtonGroup group_p2 = new ButtonGroup();
		group_p2.add(rdbtnPlayerH2);
		group_p2.add(rdbtnPlayerAI2);

		comboBox_levelP2 = new JComboBox<SkillLevel>();

		comboBox_levelP2.setModel(new DefaultComboBoxModel<SkillLevel>(
				SkillLevel.values()));
		comboBox_levelP2.setBounds(103, 65, 127, 22);
		panel_2.add(comboBox_levelP2);

		txtNameP2 = new JTextField();
		txtNameP2.setText("gamer2");
		txtNameP2.setColumns(10);
		txtNameP2.setBounds(104, 27, 126, 22);
		panel_2.add(txtNameP2);

		JButton btn_startGame = new JButton("Start Game");
		btn_startGame.addActionListener(new MyActionListener());
		btn_startGame.setBounds(401, 229, 112, 23);
		frame.getContentPane().add(btn_startGame);
	}

	public void notifyController() {
		super.setChanged(); // Markierung, da� sich der Text ge�ndert hat
		super.notifyObservers(this.gameSetupData); // ruft f�r alle Beobachter
													// die
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setSetupDataArr();
			notifyController();
			setFrame(false);
		}
	}
}
