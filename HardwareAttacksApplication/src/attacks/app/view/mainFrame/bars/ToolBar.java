package attacks.app.view.mainFrame.bars;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import attacks.app.view.AllAttacks;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import attacks.app.view.dialogues.NewAttack;

import attacks.app.Singleton;
import attacks.app.model.Attack;
import attacks.app.view.dialogues.BayesFrame;
import attacks.app.view.dialogues.FuzzyPanel;


import unbbayes.io.exception.LoadException;

public class ToolBar extends JToolBar {
	private JButton fuzzy;
	private JButton bayes;
	private JButton rdf;
	private JButton similarity;
	private JButton mitigations;
	private JButton allAttacks;
	private JButton addNewAttack;


	public ToolBar() {
		super(SwingConstants.HORIZONTAL);

		this.initButtons();
		this.initActionListeners();

		this.setFloatable(true);

	}

	public void initButtons() {
		this.fuzzy = new JButton();
		this.fuzzy.setText("Risk of vulnerability");
		this.add(fuzzy);
		
		this.bayes =  new JButton();
		this.bayes.setText("The most probable attack");
		this.add(bayes);
		
		this.addNewAttack =  new JButton();
		this.addNewAttack.setText("Register new attack");
		this.add(addNewAttack);
		
		this.allAttacks =  new JButton();
		this.allAttacks.setText("All attacks");
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
				
				AllAttacks allAttacks = new AllAttacks();
				allAttacks.setVisible(true);

			}
		});
		
		this.addNewAttack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				NewAttack newAttack = new NewAttack();
				newAttack.setVisible(true);

			}
		});
		
		this.bayes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				BayesFrame newAttack = new BayesFrame();
				newAttack.setVisible(true);

			}
		});
		
		
	}

	
}