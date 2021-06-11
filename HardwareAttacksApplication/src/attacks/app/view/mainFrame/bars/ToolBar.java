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

import attack.app.similarAttack.MitigationsFrame;
import attack.app.similarAttack.MitigationsPanel;
import attacks.app.Singleton;



public class ToolBar extends JToolBar {
	private JButton mitigations;


	public ToolBar() {
		super(SwingConstants.HORIZONTAL);

		this.initButtons();
		this.initActionListeners();

		this.setFloatable(true);

	}

	public void initButtons() {
		this.mitigations = new JButton();
		this.mitigations.setToolTipText("mitigations");
		this.mitigations.setText("Find most similar attack");

		this.add(mitigations);

	}

	private void initActionListeners() {
		this.mitigations.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MitigationsFrame mitigationsFrame = new MitigationsFrame();
				// sluzi za prikaz onih tabova
			
				MitigationsPanel mitigationsPanel = new MitigationsPanel();
				mitigationsFrame.initTabs(mitigationsPanel);
				mitigationsFrame.setVisible(true);

			}
		});
		
	}

}
