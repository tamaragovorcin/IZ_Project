package attacks.app.view.dialogues;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import attacks.app.model.Attack;


public class ChangeAttack extends NewAttack{

	private Attack s;
	JButton potvrdi;
	
	public ChangeAttack() {
		super();
		
		nameField.setText(s.getName());
		weaknessesField.setText(s.getWeaknesses().toString());
		mitigationsField.setText(s.getMitigations().toString());
		prerequisitesField.setSelectedItem(s.getPrerequisites());
		likelihoodField.setSelectedItem(s.getLikelihood());
		severityField.setSelectedItem(s.getSeverity());
	
	
	potvrdi.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String pod[] = podaci();
			
			s.setName(pod[0]);
			//s.setWeaknesses(pod[1]);
			
			
			dispose();
			//StudentiTable.getInstance().refreshTable();
			JOptionPane.showMessageDialog((Component)e.getSource(), "Uspesijesna izmjena studenta!");
			
		}
	});

	
	}
}
