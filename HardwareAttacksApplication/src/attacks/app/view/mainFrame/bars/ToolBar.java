package attacks.app.view.mainFrame.bars;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import attacks.app.Singleton;
import attacks.app.model.Attack;


import attacks.app.view.dialogues.FuzzyPanel;


import unbbayes.io.exception.LoadException;

public class ToolBar extends JToolBar {
	private JButton fuzzy;

	public ToolBar() {
		super(SwingConstants.HORIZONTAL);

		this.initButtons();
		this.initActionListeners();

		this.setFloatable(true);

	}

	public void initButtons() {
		this.fuzzy = new JButton();
		this.fuzzy.setText("fuzzy");
		this.add(fuzzy);

	}


	private void initActionListeners() {
		this.fuzzy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				FuzzyPanel attack;
				
					attack = new FuzzyPanel();
						
				attack.setVisible(true);

			}
		});
		
	}

	
}