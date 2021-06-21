package attacks.app.view.mainFrame.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import attacks.app.view.AllAttacks;
import attacks.app.view.dialogues.FuzzyPanel;
import attacks.app.view.dialogues.NewAttack;

import attacks.app.model.Attack;

public class MenuBar extends JMenuBar {

	private JMenu file;
	private JMenuItem addNewPatientItem;

	private JMenu neW;
	private JMenuItem exitItem;

	public MenuBar() {
		super();
		this.initMenuBar();

	}

	public void initMenuBar() {
		this.file = new JMenu("File");
		this.file.setMnemonic('F');

		this.neW = new JMenu("New");
		this.neW.setMnemonic('N');

		this.addNewPatientItem = new JMenuItem("New attack");
		this.addNewPatientItem.setMnemonic('P');
		

		

		this.exitItem = new JMenuItem("Exit");

		this.neW.add(addNewPatientItem);
		this.file.add(neW);

		this.file.addSeparator();
		this.file.add(exitItem);

		this.add(file);

		this.initActionListeners();

	}

	public void initActionListeners() {
		this.addNewPatientItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewAttack newPatient = new NewAttack();
				newPatient.setVisible(true);

			}
		});

	

		this.exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
