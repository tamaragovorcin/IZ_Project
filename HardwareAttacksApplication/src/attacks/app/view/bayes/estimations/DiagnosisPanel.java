package attacks.app.view.bayes.estimations;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import attacks.app.model.BayesEstimationModel;
import attacks.app.model.BayesEstimationModels;

public class DiagnosisPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BayesEstimationModels diagnosisModels;
	private JPanel mainPanel;
	private JList<BayesEstimationModel> diagnosisList;
	private DefaultListModel<BayesEstimationModel> diagnosisModelList;
	private JScrollPane scrollPane;

	public DiagnosisPanel(BayesEstimationModels diagnosisModels) {
		this.diagnosisModels = diagnosisModels;

		this.setLayout(new GridLayout(1, 1));
		this.initPanel();
	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());

		this.initComponents();

		this.diagnosisList.getVisibleRowCount();
		this.diagnosisList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.diagnosisList);
		this.mainPanel.add(scrollPane, BorderLayout.CENTER);
		this.add(mainPanel, BorderLayout.CENTER);

		this.setVisible(true);

	}

	public void initComponents() {
		this.diagnosisList = new JList<BayesEstimationModel>();
		this.diagnosisModelList = new DefaultListModel<BayesEstimationModel>();
		this.diagnosisList.setModel(diagnosisModelList);
		this.diagnosisList.setCellRenderer(new DiagnosisListRenderer());

		this.initModel();
	}

	public void initModel() {
		ArrayList<BayesEstimationModel> tempDiagnosis = this.diagnosisModels.getBayesEstimationModels();
		for (int i = 0; i < tempDiagnosis.size(); i++) {
			this.diagnosisModelList.add(i, tempDiagnosis.get(i));
		}

		this.diagnosisList.setVisibleRowCount(tempDiagnosis.size());
	}
}
