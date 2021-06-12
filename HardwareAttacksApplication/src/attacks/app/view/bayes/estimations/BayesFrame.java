package attacks.app.view.bayes.estimations;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import attacks.app.model.BayesEstimationModels;


public class BayesFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	
	private JPanel mainPanel;
	private TabbedPane tabbedPane;
	private DiagnosisPanel diagnosisTab;

	private BayesEstimationModels diagnosisModels;

	public BayesFrame() {
		this.action();
		this.initFrame();

	}

	public void initFrame() {
		this.setPreferredSize(new Dimension(800, 500));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.initPanel();
	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());

	}

	public void initTabs(DiagnosisPanel diagnosisTab) {
		this.tabbedPane = new TabbedPane();

		this.diagnosisTab = diagnosisTab;

		this.tabbedPane.addTab("Attack history", this.diagnosisTab);
		// SwingUtilities.updateComponentTreeUI(this.mainPanel);

		this.mainPanel.add(tabbedPane);
		this.add(mainPanel);

	}

	public DiagnosisPanel getDiagnosisTab() {
		return diagnosisTab;
	}

	public void setDiagnosisTab(DiagnosisPanel diagnosisTab) {
		this.diagnosisTab = diagnosisTab;
	}


	public void action() {
		//PatientGetDataAction getData = new PatientGetDataAction(this.patient);
//		getData.action();

		//this.diagnosisModels = getData.getDiagnosisModels();
	}



	public BayesEstimationModels getDiagnosisModels() {
		return diagnosisModels;
	}

	public void setDiagnosisModels(BayesEstimationModels diagnosisModels) {
		this.diagnosisModels = diagnosisModels;
	}

}

