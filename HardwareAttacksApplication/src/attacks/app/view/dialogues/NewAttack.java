package attacks.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import attacks.app.model.AttackModel;
import attacks.app.model.Risk;
import unbbayes.io.exception.LoadException;


public class NewAttack extends JDialog {
	
	private DefaultListModel<AttackModel> modelList;
	private JList<AttackModel> diagnosisList;
	
	private ArrayList<AttackModel> dijagnoze;

	private AttackModel selectedDiagnosis;

	private JScrollPane scrollPane;

	private Risk risk;

	private JButton okButton;

	public NewAttack(Risk risk) throws LoadException, IOException {
		// kad napravis to za uzimanje dijagnoza
		// samo u konstruktor prosledi neku listu dijagnoza
		this.risk = risk;
		this.selectedDiagnosis = new AttackModel();
		initDialog();
	}

	public void initDialog() throws LoadException, IOException {
		this.setTitle("Result");
		this.setPreferredSize(new Dimension(400, 400));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		this.initComponents();

		this.diagnosisList.getVisibleRowCount();
		this.diagnosisList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.diagnosisList);
		this.scrollPane.setSize(380, 380);
		this.scrollPane.setPreferredSize(new Dimension(380, 380));
		this.add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();

		panel.add(okButton);

		this.add(panel, BorderLayout.SOUTH);

	}

	public void initComponents() throws LoadException, IOException {
		this.diagnosisList = new JList<AttackModel>();
		this.modelList = new DefaultListModel<AttackModel>();
		this.diagnosisList.setModel(modelList);
		//this.diagnosisList.setCellRenderer(new ListRenderer());
		this.okButton = new JButton("Ok");
		this.okButton.setPreferredSize(new Dimension(100, 25));

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//risk.setFinalDiagnosisModel(selectedDiagnosis);
				//NewMedicationProcedure newMed = new NewMedicationProcedure(risk);
				//newMed.setVisible(true);

				dispose();
			}
		});

		this.diagnosisList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (diagnosisList.getSelectedIndex() != -1) {
					selectedDiagnosis = dijagnoze.get(diagnosisList.getSelectedIndex());

					System.out.println("SELEKTOVANO:" + selectedDiagnosis.getEvidenteName());
				}
			}
		});

		
	

		Collections.sort(dijagnoze);

	

	}

	
}
