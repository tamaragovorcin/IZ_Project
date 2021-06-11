package attack.app.similarAttack;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class MitigationsFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel mainPanel;
	private MitigationsPanel mitigationsTab;
	private TabbedPane tabbedPane;

	public MitigationsFrame() {
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

	public void initTabs(MitigationsPanel mitigationsPanel) {
		this.tabbedPane = new TabbedPane();

		this.mitigationsTab = mitigationsPanel;
	
		this.tabbedPane.addTab("Mitigations", this.mitigationsTab);
		
		this.mainPanel.add(tabbedPane);
		this.add(mainPanel);

	}

	

}
