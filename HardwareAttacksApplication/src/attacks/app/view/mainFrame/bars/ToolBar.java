package attacks.app.view.mainFrame.bars;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import attacks.app.view.dialogues.AllAttacks;
import attacks.app.view.dialogues.FuzzyPanel;



public class ToolBar extends JToolBar {
	private JButton fuzzy;
	private JButton allAttacks;
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

		this.allAttacks = new JButton();
		this.allAttacks.setText("allAttacks");
		this.add(allAttacks);
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
		this.allAttacks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				AllAttacks attack;
				
					attack = new AllAttacks();
						
				attack.setVisible(true);
			
				
			}
		});
	}

	
}