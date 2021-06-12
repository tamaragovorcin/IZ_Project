package attacks.app.view.mainFrame.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import attacks.app.view.bayes.estimations.NewEstimation;

public class MenuBar extends JMenuBar {

	private JMenu file;
	private JMenu neW;
	private JMenuItem exitItem;
	private JMenuItem addNewEstimationItem;


	public MenuBar() {
		super();
		this.initMenuBar();

	}

	public void initMenuBar() {
		this.file = new JMenu("File");
		this.file.setMnemonic('F');

		this.neW = new JMenu("New");
		this.neW.setMnemonic('N');
		
		this.addNewEstimationItem = new JMenuItem("New Bayes Estimation");
		this.addNewEstimationItem.setMnemonic('E');
		
		this.exitItem = new JMenuItem("Exit");

		

		this.file.addSeparator();
		this.file.add(exitItem);

		this.add(file);

		this.initActionListeners();

	}

	public void initActionListeners() {
		
		this.addNewEstimationItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//NewEstimation newEstimation = new NewEstimation();
				//newEstimation.setVisible(true);
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
