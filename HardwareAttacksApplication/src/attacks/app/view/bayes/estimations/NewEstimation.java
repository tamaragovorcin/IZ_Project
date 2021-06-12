package attacks.app.view.bayes.estimations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import attacks.app.model.CheckedSymptoms;
import attacks.app.model.Estimation;
import attacks.app.model.Symptom;
import unbbayes.io.exception.LoadException;


public class NewEstimation extends JDialog {

	private Estimation examination;
	private CheckedSymptoms additionalExamination;

	private ArrayList<JLabel> labelList = new ArrayList<>();

	private ArrayList<JCheckBox> checkBoxList = new ArrayList<>();

	private JPanel mainPanel;

	private JScrollPane scrollPane;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	private JButton okButton;
	private JButton cancelButton;

	public NewEstimation(Estimation e) {
		// List<Symptoms>
		this.examination = e;
		additionalExamination = new CheckedSymptoms();
		ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
		Symptom likelyhood  = new Symptom();

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
		this.mainPanel.setLayout(new GridLayout(additionalExamination.getSymptomsToCheck().size() + 1, 2, 10, 30));

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

		for (Symptom symptom : additionalExamination.getSymptomsToCheck()) {
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

	
	}

}
