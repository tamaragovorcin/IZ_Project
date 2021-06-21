package attacks.app.view.dialogues;

import java.awt.BorderLayout;
import java.lang.Math;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import attacks.app.enumerations.Likelihood;
import attacks.app.enumerations.Prerequisites;
import attacks.app.enumerations.Severity;
import attacks.app.model.Attack;
import attacks.app.rdf.AttackCreate;
import attacks.app.rdf.GetAttacks;



public class EditAttack extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Attack attack;
	
	private JPanel mainPanel;
	
	private JLabel nameLabel;
	private JLabel severityLabel;
	private JLabel likelyhoodLabel;
	private JLabel mitigationsLabel;
	private JLabel prerequisitesLabel;
	private JLabel weaknessesLabel;
	
	

	private JTextField nameField;
	private JTextField weaknessesField;
	private JTextField mitigationsField;
	
	
	private String[] severity = { Severity.Low.toString(), Severity.Medium.toString(),  Severity.High.toString(), Severity.Very_high.toString() };
	private JComboBox<String> severityField;
	
	private String[] likelihood = {  Likelihood.Low.toString(), Likelihood.Medium.toString(),  Likelihood.High.toString() };
	private JComboBox<String> likelihoodField;
	
	private String[] prerequest = { Prerequisites.A_SIM_card_that_relies_on_the_DES_cipher.toString(), 
			Prerequisites.Access_to_the_component_currently_deployed_at_a_victim_location.toString(),
			Prerequisites.Access_to_the_software_during_the_development_phase.toString(),
			Prerequisites.An_attacker_and_the_victim_are_both_using_the_same_WiFi_network.toString(),
			Prerequisites.Application_is_connected_to_the_Windows_domain.toString(),
			Prerequisites.Configuration_files_must_be_modifiable_by_the_attacker.toString(),
			Prerequisites.HTTP_TRACE_is_enabled_on_the_web_server.toString(),
			Prerequisites.Physical_access_to_the_system.toString(),
			Prerequisites.Requires_the_existence_of_a_physical_target.toString(),
			Prerequisites.Session_identifiers_that_remain_unchanged_when_the_privilege_levels_change.toString(),
			Prerequisites.Targeted_software_is_utilizing_application_framework_APIs.toString(),
			Prerequisites.The_ability_to_calculate_a_card_checksum_and_write_out_a_valid_checksum_value.toString(),
			Prerequisites.The_adversary_requires_knowledge_of_and_access_to_network_route.toString(),
			Prerequisites.The_attacker_must_have_direct_access_to_the_target_server.toString(),
			Prerequisites.The_target_host_is_logging_the_action_and_data_of_the_user.toString(),
			Prerequisites.The_target_must_use_the_affected_file_without_verifying_its_integrity.toString(),
			Prerequisites.The_targeted_site_must_contain_hidden_fields_to_be_modified.toString(),
			Prerequisites.The_various_resources_must_be_discoverable_by_the_attacker.toString(),
			Prerequisites.Advanced_knowledge_about_the_target_system_and_sub_components.toString() };
	
	private JComboBox<String> prerequisitesField;
	
	private JButton noteButton;
	private Dimension fieldDim;
	private Dimension labelDim;

	public EditAttack(String id) {
		 GetAttacks get = new GetAttacks();
         ArrayList<Attack> allAttacks = new ArrayList();
         allAttacks = get.getAttacks();
		for (Attack attack : allAttacks) {
			if(attack.getId().equals(id)) {
				this.attack = attack;
			}
		}
				
		this.initDialog();
	}

	public void initDialog() {
		this.setTitle("Edit attack");
		this.setPreferredSize(new Dimension(800, 500));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initPanel();
	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout(9, 2, 10, 30));

		this.add(mainPanel, BorderLayout.CENTER);

		this.initComponents();
		this.initActionListeners();

	}

	public void initComponents() {
		this.labelDim = new Dimension(300, 25);
		this.fieldDim = new Dimension(300, 25);

		this.nameLabel = new JLabel("Name:");
		this.nameField = new JTextField(attack.getName());
		this.nameLabel.setPreferredSize(labelDim);
		this.nameField.setPreferredSize(fieldDim);
	
		
		this.mainPanel.add(nameLabel);
		this.mainPanel.add(nameField);
		
		this.mitigationsLabel = new JLabel("Mitigation:");
		this.mitigationsField = new JTextField("Input in form mitigation1, mitigation2");
		this.mitigationsLabel.setPreferredSize(labelDim);
		this.mitigationsField.setPreferredSize(fieldDim);
	
		
		this.mainPanel.add(mitigationsLabel);
		this.mainPanel.add(mitigationsField);
		
		this.weaknessesLabel = new JLabel("Weaknesses:");
		this.weaknessesField = new JTextField("Input in form weaknesse1, weaknesse2.");
		this.weaknessesLabel.setPreferredSize(labelDim);
		this.weaknessesField.setPreferredSize(fieldDim);
	
		
		this.mainPanel.add(weaknessesLabel);
		this.mainPanel.add(weaknessesField);
		
		
		
		this.severityLabel = new JLabel("Severity:");
		this.severityField = new JComboBox<String>(severity);
		this.severityLabel.setPreferredSize(labelDim);
		this.severityField.setPreferredSize(fieldDim);

		this.mainPanel.add(severityLabel);
		this.mainPanel.add(severityField);
		
		
		

		
		this.prerequisitesLabel = new JLabel("Prerequisite:");
		this.prerequisitesField = new JComboBox<String>(prerequest);
		this.prerequisitesLabel.setPreferredSize(labelDim);
		this.prerequisitesField.setPreferredSize(fieldDim);

		this.mainPanel.add(prerequisitesLabel);
		this.mainPanel.add(prerequisitesField);
		
		

		
		this.likelyhoodLabel = new JLabel("Likelihood:");
		this.likelihoodField = new JComboBox<String>(likelihood);
		this.likelyhoodLabel.setPreferredSize(labelDim);
		this.likelihoodField.setPreferredSize(fieldDim);

		this.mainPanel.add(likelyhoodLabel);
		this.mainPanel.add(likelihoodField);
		
		
		
		JPanel panel = new JPanel();
		this.noteButton = new JButton();
		this.noteButton.setText("Add new attack");
		panel.add(noteButton);
	
		
		this.add(panel, BorderLayout.SOUTH);
	}
	public int genereateId() {
		int min = 0;  
		int max = 1500;
		int b = (int)(Math.random()*(max-min+1)+min);  
		System.out.println(b);  
		return b;
	}

	public void initActionListeners() {
		this.noteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AttackCreate createAction = new AttackCreate();
				createAction.action(attack,String.valueOf(genereateId()) ,nameField.getText(),severityField.getSelectedItem().toString(),likelihoodField.getSelectedItem().toString(),
						weaknessesField.getText(), prerequisitesField.getSelectedItem().toString(),mitigationsField.getText());

				dispose();


			
				
				
			}
			
		});
		
		
	}
}