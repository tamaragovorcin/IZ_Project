package attacks.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import attacks.app.miscellaneous.BayesController;
import attacks.app.model.Estimation;
import attacks.app.model.BayesEstimationModel;
import attacks.app.model.ListRenderer;

import unbbayes.io.exception.LoadException;

public class NewEstimation extends JDialog {

	private DefaultListModel<BayesEstimationModel> modelList;
	private JList<BayesEstimationModel> diagnosisList;
	private String bajesFajl = "bajes" ;

	private ArrayList<BayesEstimationModel> dijagnoze;

	private BayesEstimationModel selectedDiagnosis;

	private JScrollPane scrollPane;

	private Estimation examination;

	private JButton okButton;

	public NewEstimation(Estimation examination) throws LoadException, IOException {
		// kad napravis to za uzimanje dijagnoza
		// samo u konstruktor prosledi neku listu dijagnoza
		this.examination = examination;
		this.selectedDiagnosis = new BayesEstimationModel();
		initDialog();
	}

	public void initDialog() throws LoadException, IOException {
		this.setTitle("Estimation result");
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
		this.diagnosisList = new JList<BayesEstimationModel>();
		this.modelList = new DefaultListModel<BayesEstimationModel>();
		this.diagnosisList.setModel(modelList);
		this.diagnosisList.setCellRenderer(new ListRenderer());
		this.okButton = new JButton("Ok");
		this.okButton.setPreferredSize(new Dimension(100, 25));

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				examination.setFinalDiagnosisModel(selectedDiagnosis);

				dispose();
			}
		});

		this.diagnosisList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (diagnosisList.getSelectedIndex() != -1) {
					selectedDiagnosis = dijagnoze.get(diagnosisList.getSelectedIndex());

					System.out.println("SELEKTOVANO:" + selectedDiagnosis.getAttackName());
				}
			}
		});

		dijagnoze = new ArrayList<>();
		BayesController bc = new BayesController();
		BayesEstimationModel dijagnoza = new BayesEstimationModel();
			try {
				dijagnoza = bc.CreateBayesNet(bajesFajl, examination.getSymptoms());

				if (!dijagnoza.getAttackName().equals("Empty")) {
					dijagnoze.add(dijagnoza);
				}

			} catch (Exception e) {
				// sluzi ako naidje dijagnoza koja je null
			}

		

		if (dijagnoze.isEmpty()) {
				String[] names = bajesFajl.split("_");
				BayesEstimationModel diagnoses = new BayesEstimationModel();
				diagnoses.setAttackName(names[0]);
				diagnoses.setAttackPercentage(Float.parseFloat("0.0833"));
				dijagnoze.add(diagnoses);
			
		}

		Collections.sort(dijagnoze);

//		for (int i = 0; i < dijagnoze.size() - 1; i++) {
//			for (int j = 1; j < dijagnoze.size(); j++) {
//				if (dijagnoze.get(i).getDiagnosisPercentage() < dijagnoze.get(j).getDiagnosisPercentage()) {
//					DiagnosisModel temp = dijagnoze.get(i);
//
//					dijagnoze.set(i, dijagnoze.get(j));
//					dijagnoze.set(j, temp);
//				}
//			}
//		}
//		

		int n = 0;
		for (int i = 0; i < dijagnoze.size(); i++) {
			if (!dijagnoze.get(i).getAttackName().equals("Empty")) {

				String dij = this.dijagnoze.get(i).getAttackName();
				String output = dij.substring(0, 1).toUpperCase() + dij.substring(1);

				float f = this.dijagnoze.get(i).getAttackPercentage() * 100;

				this.modelList.add(n, dijagnoze.get(i));
				// this.modelList.add(n, output + ": " + f + "%");
				n++;
			}
		}
		this.diagnosisList.setVisibleRowCount(dijagnoze.size());

	}

}