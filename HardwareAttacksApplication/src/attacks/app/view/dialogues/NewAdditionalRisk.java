package attacks.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import attacks.app.controller.AdditionalRiskCreateAction;
import attacks.app.miscellaneous.RiskVulnerabilityFounder;
import attacks.app.model.AdditionalRisk;
import attacks.app.model.Prerequisite;
import attacks.app.model.Risk;


public class NewAdditionalRisk extends JDialog {

	private Risk risk;
	private AdditionalRisk additionalRisk;

	private ArrayList<JLabel> labelList = new ArrayList<>();

	private ArrayList<JCheckBox> checkBoxList = new ArrayList<>();

	private JPanel mainPanel;

	private JScrollPane scrollPane;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	private JButton okButton;
	private JButton cancelButton;

	public NewAdditionalRisk(Risk e) {
		// List<Symptoms>
		this.risk = e;
		additionalRisk = new AdditionalRisk();
		//System.out.println(risk.getPhysicalExamination().toString());
		ArrayList<Prerequisite> calculatedSymptoms = RiskVulnerabilityFounder.findRelatedPrerequisites(risk.getPrerequistes());
		ArrayList<Prerequisite> filteredSymptoms = RiskVulnerabilityFounder.getOnlyImportantPrerequisites(calculatedSymptoms,
				risk.getAttack());
		additionalRisk.setPrerequisitesToCheck(filteredSymptoms);

		this.initDialog();

		// on ok button popuniti additionalExamination i postaviti u examinations
	}

	public void initDialog() {
		this.setTitle("New Medical Examination: Additional Examination");
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
		this.mainPanel.setLayout(new GridLayout(additionalRisk.getPrerequisitesToCheck().size() + 1, 2, 10, 30));

		this.scrollPane = new JScrollPane(this.mainPanel);
		this.scrollPane.setSize(700, 500);
		this.scrollPane.setPreferredSize(new Dimension(700, 500));

		this.initComponents();
		this.initActionListeners();

		this.add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.add(okButton);
		panel.add(cancelButton);

		this.add(panel, BorderLayout.SOUTH);
	}

	public void initComponents() {

		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(200, 25);

		for (Prerequisite symptom : additionalRisk.getPrerequisitesToCheck()) {
			JLabel label = new JLabel(symptom.getName());
			JCheckBox checkBox = new JCheckBox();
			checkBox.setName(symptom.getName());

			label.setPreferredSize(labelDim);

			this.mainPanel.add(label);
			this.mainPanel.add(checkBox);
			this.labelList.add(label);
			this.checkBoxList.add(checkBox);
		}

		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.okButton.setPreferredSize(buttonDim);
		this.cancelButton.setPreferredSize(buttonDim);

	}

	public void initActionListeners() {

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ovde preuzeti sve vrednosti koje je korisnik uneo i dodati i u additional i u
				// examination, sad ide zakucavanje
				// physicalExamination.setMusclesRecognition(NewPhysicalExamination.this.);
				for (JCheckBox jcb : checkBoxList) {
					if (jcb.isSelected()) {
						risk.getPrerequistes().add(new Prerequisite(jcb.getName()));
					}
				}

				AdditionalRiskCreateAction addCreateAction = new AdditionalRiskCreateAction();
				addCreateAction.action(risk.getPrerequistes());

				NewAdditionalRisk.this.risk
						.setAdditionalRisk(NewAdditionalRisk.this.additionalRisk);

				System.out.println("Simptomi iz liste:");
				for (Prerequisite s : risk.getPrerequistes()) {
					System.out.println(s.getName());
				}

				NewAttack diagnosisDialog = null;
				
				diagnosisDialog.setVisible(true);

				dispose();
			}
		});

		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
