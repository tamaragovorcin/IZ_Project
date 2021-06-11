package attack.app.similarAttack;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import attacks.app.miscellaneous.MitigationsPrologFinder;
import attacks.app.model.AttackName;
import attacks.app.model.Mitigation;
import attacks.app.model.MitigationsModels;


public class MitigationsPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private MitigationsModels mitigationsModels;
	private JPanel mainPanel;
	private JList<Mitigation> mitigationsJList;
	private DefaultListModel<Mitigation> mitigationsListModel;
	private JScrollPane scrollPane;
	public ArrayList<String> mitigationsStrings;


	public MitigationsPanel() {
		this.mitigationsModels = mitigationsModels;
		this.setLayout(new GridLayout(1, 1));
		this.initPanel();
	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());

		this.initComponents();

		this.mitigationsJList.getVisibleRowCount();
		this.mitigationsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.mitigationsJList);
		this.mainPanel.add(scrollPane, BorderLayout.CENTER);
		this.add(mainPanel, BorderLayout.CENTER);

		this.setVisible(true);

	}

	public void initComponents() {
		this.mitigationsJList = new JList<Mitigation>();
		this.mitigationsListModel = new DefaultListModel<Mitigation>();
		this.mitigationsJList.setModel(mitigationsListModel);
		this.mitigationsJList.setCellRenderer(new MitigationsListRenderer());

		this.initModel();
	}

	public void initModel() {
		AttackName attack = new AttackName();
		attack.setId(0);
		//attack.setAttackName("anxiety");
		attack.setAttackName("cache_poisoning");
		
		ArrayList<Mitigation> mitigationsArrayList = MitigationsPrologFinder.findMitigations(attack);
		for (int i = 0; i < mitigationsArrayList.size(); i++) {
			this.mitigationsListModel.add(i, mitigationsArrayList.get(i));
		}

		this.mitigationsJList.setVisibleRowCount(mitigationsArrayList.size());
	}
}
