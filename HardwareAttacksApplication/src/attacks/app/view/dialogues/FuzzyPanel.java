package attacks.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import attacks.app.miscellaneous.FuzzyController;
import attacks.app.model.Attack;
import attacks.app.model.Characteristics;


public class FuzzyPanel extends JDialog {

	private static final long serialVersionUID = 1L;

	private Characteristics characteristics;
	private double result = 0;
	private String resultString;
	private JPanel mainPanel;
	
	private JLabel severityLabel;
	private JLabel likelyhoodLabel;
	private JLabel exploitabilityLabel;
	private JLabel authenticationLabel;
	private JLabel impact_biasLabel;
	private JLabel access_vectorLabel;
	private JLabel access_complexityLabel;
	private JLabel confidentiality_impactLabel;
	private JLabel availability_impactLabel;
	private JLabel remediation_levelLabel;
	private JLabel report_confidenceLabel;
	private JLabel collateral_damage_potentialLabel;
	private JLabel target_distributionLabel;
	
	private JLabel resultLabel;
	private JLabel titleLabel;


	private JTextField severityField;
	private JTextField likelyhoodField;
	private JTextField exploitabilityField;
	private JTextField authenticationField;
	private JTextField impact_biasField;
	private JTextField access_vectorField;
	private JTextField access_complexityField;
	private JTextField confidentiality_impactField;
	private JTextField remediation_levelField;
	private JTextField availability_impactField;
	private JTextField report_confidenceField;
	private JTextField collateral_damage_potentialField;
	private JTextField target_distributionField;
	
	
	private JTextField resultField;
	
	private JButton calculateButton;
	private JButton cancelButton;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;
	private Dimension labelDimTitle;
	public FuzzyPanel() {
		//this.characteristics = new Characteristics();
		this.initDialog();
	}

	public void initDialog() {
		this.setTitle("Evidente characteristics");
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
		this.mainPanel.setLayout(new GridLayout(9, 2, 12, 30));

		this.add(mainPanel, BorderLayout.CENTER);

		this.initComponents();
		this.initActionListeners();

	}

	public void initComponents() {
		this.labelDim = new Dimension(300, 25);
		this.labelDimTitle = new Dimension(600, 600);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(300, 25);
	
		Box titleText = Box.createHorizontalBox();
		JLabel title = new JLabel("ENTER NUMBERS FROM 1-10 FOR EACH FIELD");
		title.setFont (title.getFont().deriveFont(25.0f));
		titleText.add(title);
		titleText.setAlignmentX(mainPanel.getWidth() / 2);
	//	this.mainPanel.add(titleText);
		
		
		this.severityLabel = new JLabel("Severity:");
		this.severityField = new JTextField("Input number 1 - 10");
		this.severityLabel.setPreferredSize(labelDim);
		this.severityField.setPreferredSize(fieldDim);
		keyListener(this.severityField, 1);

		this.mainPanel.add(severityLabel);
		this.mainPanel.add(severityField);

		this.likelyhoodLabel = new JLabel("Likelyhood:");
		this.likelyhoodField = new JTextField("Input number 1 - 10");
		this.likelyhoodLabel.setPreferredSize(labelDim);
		this.likelyhoodLabel.setPreferredSize(fieldDim);
		keyListener(this.likelyhoodField, 1);

		this.mainPanel.add(likelyhoodLabel);
		this.mainPanel.add(likelyhoodField);
		
		this.exploitabilityLabel = new JLabel("Exploatabiity:");
		this.exploitabilityField = new JTextField("Input number 1 - 10");
		this.exploitabilityLabel.setPreferredSize(labelDim);
		this.exploitabilityLabel.setPreferredSize(fieldDim);
		keyListener(this.exploitabilityField, 1);

		this.mainPanel.add(exploitabilityLabel);
		this.mainPanel.add(exploitabilityField);
		
		this.authenticationLabel = new JLabel("Authentication:");
		this.authenticationField = new JTextField("Input number 1 - 10");
		this.authenticationLabel.setPreferredSize(labelDim);
		this.authenticationLabel.setPreferredSize(fieldDim);
		keyListener(this.authenticationField, 1);

		this.mainPanel.add(authenticationLabel);
		this.mainPanel.add(authenticationField);
		
		
		this.impact_biasLabel = new JLabel("Impact_bias:");
		this.impact_biasField = new JTextField("Input number 1 - 10");
		this.impact_biasLabel.setPreferredSize(labelDim);
		this.impact_biasLabel.setPreferredSize(fieldDim);
		keyListener(this.impact_biasField, 1);

		this.mainPanel.add(impact_biasLabel);
		this.mainPanel.add(impact_biasField);
		
		this.access_vectorLabel = new JLabel("Access_vector:");
		this.access_vectorField = new JTextField("Input number 1 - 10");
		this.access_vectorLabel.setPreferredSize(labelDim);
		this.access_vectorLabel.setPreferredSize(fieldDim);
		keyListener(this.access_vectorField, 1);

		this.mainPanel.add(access_vectorLabel);
		this.mainPanel.add(access_vectorField);
		
		this.access_complexityLabel = new JLabel("Access_complexity:");
		this.access_complexityField = new JTextField("Input number 1 - 10");
		this.access_complexityLabel.setPreferredSize(labelDim);
		this.access_complexityLabel.setPreferredSize(fieldDim);
		keyListener(this.access_complexityField, 1);

		this.mainPanel.add(access_complexityLabel);
		this.mainPanel.add(access_complexityField);
		
		this.confidentiality_impactLabel = new JLabel("Confidentiality_impact:");
		this.confidentiality_impactField = new JTextField("Input number 1 - 10");
		this.confidentiality_impactLabel.setPreferredSize(labelDim);
		this.confidentiality_impactLabel.setPreferredSize(fieldDim);
		keyListener(this.confidentiality_impactField, 1);

		this.mainPanel.add(confidentiality_impactLabel);
		this.mainPanel.add(confidentiality_impactField);
		
		this.availability_impactLabel = new JLabel("Availability_impact:");
		this.availability_impactField = new JTextField("Input number 1 - 10");
		this.availability_impactLabel.setPreferredSize(labelDim);
		this.availability_impactLabel.setPreferredSize(fieldDim);
		keyListener(this.availability_impactField, 1);

		this.mainPanel.add(availability_impactLabel);
		this.mainPanel.add(availability_impactField);
		
	
		this.remediation_levelLabel = new JLabel("Remediation_level:");
		this.remediation_levelField = new JTextField("Input number 1 - 10");
		this.remediation_levelLabel.setPreferredSize(labelDim);
		this.remediation_levelLabel.setPreferredSize(fieldDim);
		keyListener(this.remediation_levelField, 1);

		this.mainPanel.add(remediation_levelLabel);
		this.mainPanel.add(remediation_levelField);
		
		this.report_confidenceLabel = new JLabel("Report_confidence:");
		this.report_confidenceField = new JTextField("Input number 1 - 10");
		this.report_confidenceLabel.setPreferredSize(labelDim);
		this.report_confidenceLabel.setPreferredSize(fieldDim);
			keyListener(this.report_confidenceField, 1);

		this.mainPanel.add(report_confidenceLabel);
		this.mainPanel.add(report_confidenceField);
		
		this.collateral_damage_potentialLabel = new JLabel("Collateral_damage_potential:");
		this.collateral_damage_potentialField = new JTextField("Input number 1 - 10");
		this.collateral_damage_potentialLabel.setPreferredSize(labelDim);
		this.collateral_damage_potentialLabel.setPreferredSize(fieldDim);
		keyListener(this.collateral_damage_potentialField, 1);

		this.mainPanel.add(collateral_damage_potentialLabel);
		this.mainPanel.add(collateral_damage_potentialField);
		
		this.target_distributionLabel = new JLabel("Target_distribution:");
		this.target_distributionField = new JTextField("Input number 1 - 10");
		this.target_distributionLabel.setPreferredSize(labelDim);
		this.target_distributionLabel.setPreferredSize(fieldDim);
		keyListener(this.target_distributionField, 2);

		this.mainPanel.add(target_distributionLabel);
		this.mainPanel.add(target_distributionField);
		
		
		
		JPanel panel = new JPanel();
		this.calculateButton = new JButton();
		this.calculateButton.setText("Calculate");
		panel.add(calculateButton);
		
		this.resultLabel = new JLabel("RESULT:");
		this.resultField = new JTextField();
		this.resultLabel.setPreferredSize(labelDim);
		this.resultLabel.setPreferredSize(fieldDim);
		keyListener(this.resultField, 2);

		this.mainPanel.add(resultLabel);
		this.mainPanel.add(resultField);
		
		
		this.add(panel, BorderLayout.SOUTH);
	}

	public void initActionListeners() {
		this.calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validation()) {
				FuzzyController controller;
				
				controller = new FuzzyController();
				

				Double severityDouble = Double.parseDouble(severityField.getText());
				Double likelyhoodDouble = Double.parseDouble(likelyhoodField.getText());
				Double exploitability = Double.parseDouble(exploitabilityField.getText());
				Double authentication = Double.parseDouble(authenticationField.getText());
				Double impact_bias = Double.parseDouble(impact_biasField.getText());
				Double access_vector = Double.parseDouble(access_vectorField.getText());
				Double access_complexity = Double.parseDouble(access_complexityField.getText());
				Double confidentiality_impact = Double.parseDouble(confidentiality_impactField.getText());
				Double availability_impact = Double.parseDouble(remediation_levelField.getText());
				Double remediation_level = Double.parseDouble(availability_impactField.getText());
				Double report_confidence = Double.parseDouble(report_confidenceField.getText());
				Double collateral_damage_potential = Double.parseDouble(collateral_damage_potentialField.getText());
				Double target_distribution = Double.parseDouble(target_distributionField.getText());

				
			
				result = controller.calculate(severityDouble, likelyhoodDouble, exploitability, authentication, impact_bias, access_vector, access_complexity, confidentiality_impact, availability_impact, remediation_level, report_confidence, collateral_damage_potential, target_distribution);
				System.out.println(result);
				resultString = String.valueOf(result);
				resultField.setText(resultString);
				}else {
				
					//JOptionPane.showMessageDialog((Component) e.getSource(), "Fill input field", "Greska", JOptionPane.ERROR);
					
				}
			}
			
		});
	
		this.resultField.setText(resultString);
	
	}

	public boolean validation() {
		if (this.severityField.getText().equals("")) {
			this.severityField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.severityField.setToolTipText("The field can not be empty!");

			return false;
		} else if (this.access_complexityField.getText().equals("")) {
			this.access_complexityField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.access_complexityField.setToolTipText("The field can not be empty!");

			return false;
		} else if (this.access_vectorField.getText().equals("")) {
			this.access_vectorField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.access_vectorField.setToolTipText("The field can not be empty!");

			return false;
		} else if (this.authenticationField.getText().equals("")) {
			this.authenticationField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.authenticationField.setToolTipText("The field can not be empty!");

			return false;
		}
		else if (this.likelyhoodField.getText().equals("")) {
			this.likelyhoodField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.likelyhoodField.setToolTipText("The field can not be empty!");

			return false;
		}else if (this.exploitabilityField.getText().equals("")) {
			this.exploitabilityField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.exploitabilityField.setToolTipText("The field can not be empty!");

			return false;
		}else if (this.impact_biasField.getText().equals("")) {
			this.impact_biasField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.impact_biasField.setToolTipText("The field can not be empty!");

			return false;
		}else if (this.confidentiality_impactField.getText().equals("")) {
			this.confidentiality_impactField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.confidentiality_impactField.setToolTipText("The field can not be empty!");

			return false;
		}else if (this.remediation_levelField.getText().equals("")) {
			this.remediation_levelField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.remediation_levelField.setToolTipText("The field can not be empty!");

			return false;
		}else if (this.availability_impactField.getText().equals("")) {
			this.availability_impactField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.availability_impactField.setToolTipText("The field can not be empty!");

			return false;
		}else if (this.report_confidenceField.getText().equals("")) {
			this.report_confidenceField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.report_confidenceField.setToolTipText("The field can not be empty!");

			return false;
		}else if (this.collateral_damage_potentialField.getText().equals("")) {
			this.collateral_damage_potentialField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.collateral_damage_potentialField.setToolTipText("The field can not be empty!");

			return false;
		}else if (this.target_distributionField.getText().equals("")) {
			this.target_distributionField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.target_distributionField.setToolTipText("The field can not be empty!");

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
					if (!textField.getText().matches("^[0-9]|[0-9][0-9]$")) {
						textField.setToolTipText("Only numbers are allowed!");
						textField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
					} else {
						textField.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 255), 2));
					}

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					if (!textField.getText().matches("^[0-9]|[0-9][0-9]$")) {
						textField.setToolTipText("Only numbers are allowed!");
						textField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
					} else {
						textField.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 255), 2));
					}

				}

				@Override
				public void keyPressed(KeyEvent e) {


				
				}
			});
		}

			
	}
}