package attacks.app.view.mainFrame.bars;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import attacks.app.Singleton;
import attacks.app.view.bayes.estimations.NewEstimation;
import bayes.SelectSymptoms;

public class ToolBar extends JToolBar {

	private JButton newEstimation;


	public ToolBar() {
		super(SwingConstants.HORIZONTAL);

		this.initButtons();
		this.initActionListeners();

		this.setFloatable(true);

	}

	public void initButtons() {
		this.newEstimation = new JButton();
		this.newEstimation.setToolTipText("Attack estimation");

		ImageIcon examIcon = new ImageIcon("resources/newItem.png");
		Image icon1 = examIcon.getImage();
		icon1 = icon1.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		examIcon = new ImageIcon(icon1);

		this.newEstimation.setIcon(examIcon);
		
		this.add(newEstimation);


	}

	private void initActionListeners() {
		this.newEstimation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			 	SelectSymptoms newEstimation = new SelectSymptoms();
			 	newEstimation.setVisible(true);

			}
		});
		
	}

}
