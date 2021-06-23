package attacks.app.view.dialogues;



import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.Math;   
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import attacks.app.enumerations.Likelihood;
import attacks.app.enumerations.Mitigations;
import attacks.app.enumerations.Prerequisites;
import attacks.app.enumerations.Severity;
import attacks.app.enumerations.Weaknesses;
import attacks.app.miscellaneous.FuzzyController;
import attacks.app.model.Attack;
import attacks.app.rdf.AttackCreate;
import attacks.app.rdf.AttackUpdate;
import attacks.app.rdf.GetAttacks;



public class EditAttack extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Attack attack;
	
	private String resultString;
	private JPanel mainPanel;
	
	private JLabel nameLabel;
	private JLabel severityLabel;
	private JLabel likelyhoodLabel;
	private JLabel mitigationsLabel;
	private JLabel prerequisitesLabel;
	private JLabel weaknessesLabel;
	
	

	private JTextField nameField;

	
	
	private String[] severity = { Severity.Low.toString(), Severity.Medium.toString(),  Severity.High.toString(), Severity.VeryHigh.toString() };
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
	
	private String[] mitigations = { Mitigations.Always_invalidate_a_session_ID_after_the_user_logout.toString(), 
			Mitigations.Apply_the_least_privilege_principles.toString(),
			Mitigations.Checking_headers_in_traffic.toString(),
			Mitigations.Ensure_that_client_process_and_or_message_is_authenticated.toString(),
			Mitigations.Ensure_that_design_documentation_is_saved_in_a_secure_location.toString(),
			Mitigations.Ensure_that_the_content_of_the_file_doesnt_depend_solely_on_the_file_extension.toString(),
			Mitigations.Ensure_that_the_proper_permissions_are_set_on_local_files.toString(),
			Mitigations.Ensure_the_web_server_implements_all_relevant_security_patches.toString(),
			Mitigations.Ensure_users_are_not_reusing_username_password_combinations.toString(),
			Mitigations.Get_your_Public_Key_signed_by_a_Certificate_Authority.toString(),
			Mitigations.Identify_programs_that_may_be_used_to_acquire_process_information_and_block_them.toString(),
			Mitigations.Implement_communications_to_and_from_the_registry_using_secure_protocols.toString(),
			Mitigations.Include_hosts_file.toString(),
			Mitigations.Leverage_anti_virus_products.toString(),
			Mitigations.Limit_users_and_accounts_that_have_remote_interactive_login_access.toString(),
			Mitigations.Load_configuration_from_separate_process_and_memory_space.toString(),
			Mitigations.Use_session_identifiers_that_are_difficult_to_guess_or_brute_force.toString(),
			Mitigations.Use_strong_session_identifiers.toString(),
			Mitigations.Users_should_not_open_other_tabs_in_the_browser.toString(),
			Mitigations.Validate_software_updates_before_installing.toString(),
			Mitigations.Use_strong_session_identifiers.toString()};
	
	private JComboBox<String> mitigationsField;
	
	private String[] weaknesses = { Weaknesses.Authentication_Bypass_by_Assumed_Immutable_Data.toString(), 
			Weaknesses.Authentication_Bypass_by_Spoofing.toString(),
			Weaknesses.Call_to_Non_ubiquitous_API.toString(),
			Weaknesses.Channel_Accessible_by_NonEndpoint.toString(),
			Weaknesses.Channel_Accessible_by_NonEndpoint.toString(),
			Weaknesses.Client_Side_Enforcement_of_Server_Side_Security.toString(),
			Weaknesses.Command_Shell_in_Externally_Accessible_Directory.toString(),
			Weaknesses.Device_Unlock_Credential_Sharing.toString(),
			Weaknesses.Download_of_Code_Without_Integrity_Check.toString(),
			Weaknesses.Exposure_of_Data_Element_to_Wrong_Session.toString(),
			Weaknesses.External_Control_of_System_or_Configuration_Setting.toString(),
			Weaknesses.Improper_Authorization.toString(),
			Weaknesses.Improper_Control_of_Generation_of_Code.toString(),
			Weaknesses.Improper_Implementation_of_Lock_Protection_Registers.toString(),
			Weaknesses.Insufficiently_Protected_Credentials.toString(),
			Weaknesses.Missing_Encryption_of_Sensitive_Data.toString(),
			Weaknesses.Missing_Support_for_Integrity_Check.toString(),
			Weaknesses.Origin_Validation_Error.toString(),
			Weaknesses.PK_API_Abuse.toString(),
			Weaknesses.Protection_Mechanism_Failure.toString(),
			Weaknesses.Use_of_a_Broken_or_Risky_Cryptographic_Algorithm.toString()};
	
	private JComboBox<String> weaknessesField;
		
	private JButton noteButton;

	private Dimension fieldDim;
	private Dimension labelDim;

	public EditAttack(String id) {
		GetAttacks getAttacks = new GetAttacks();
		for (Attack attack : getAttacks.getAttacks()) {
			if(attack.getId().equals(id)) {
				this.attack = attack;
			}
		}
		this.initDialog();
	}

	public void initDialog() {
		this.setTitle("Registration of new attack");
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
		keyListener(this.nameField, 1);

		
		this.mainPanel.add(nameLabel);
		this.mainPanel.add(nameField);
		
	
		
		
		
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
		
		this.mitigationsLabel = new JLabel("Mitigation:");
		this.mitigationsField = new JComboBox<String>(mitigations);
		this.mitigationsLabel.setPreferredSize(labelDim);
		this.mitigationsLabel.setPreferredSize(fieldDim);

		this.mainPanel.add(mitigationsLabel);
		this.mainPanel.add(mitigationsField);
		
		this.weaknessesLabel = new JLabel("Weaknesses:");
		this.weaknessesField = new JComboBox<String>(weaknesses);
		this.weaknessesLabel.setPreferredSize(labelDim);
		this.weaknessesLabel.setPreferredSize(fieldDim);

		this.mainPanel.add(weaknessesLabel);
		this.mainPanel.add(weaknessesField);
		
		

		
		this.likelyhoodLabel = new JLabel("Likelihood:");
		this.likelihoodField = new JComboBox<String>(likelihood);
		this.likelyhoodLabel.setPreferredSize(labelDim);
		this.likelihoodField.setPreferredSize(fieldDim);

		this.mainPanel.add(likelyhoodLabel);
		this.mainPanel.add(likelihoodField);
		
		
		
		JPanel panel = new JPanel();
		this.noteButton = new JButton();
		this.noteButton.setText("Save changes");
		panel.add(noteButton);
	
		
		this.add(panel, BorderLayout.SOUTH);
	}
	
	public String parseName(String name) {
		return name.replace(" ", "_").toLowerCase();
	}
	public void initActionListeners() {
		this.noteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AttackUpdate createAction = new AttackUpdate();
				createAction.action(attack,attack.getId() ,parseName(nameField.getText()),severityField.getSelectedItem().toString(),likelihoodField.getSelectedItem().toString(),
						weaknessesField.getSelectedItem().toString(), prerequisitesField.getSelectedItem().toString(),mitigationsField.getSelectedItem().toString());

				dispose();


			
				
				
			}
			
		});
		
		
	}

	public boolean validation() {
		if (this.nameField.getText().equals("")) {
			this.nameField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			this.nameField.setToolTipText("The field can not be empty!");
			return false;
		}
		return true;
	}

	
	public void keyListener(JTextField textField, int option) {

		if (option == 1) {
			textField.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {

					if (!textField.getText().matches("^[a-zA-Z]+([\\s][a-zA-Z]+)*$")) {
						textField.setToolTipText("Only letters are allowed!");
						textField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
					} else {
						textField.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 255), 2));
					}
				}
			});
		}

	}
	


}