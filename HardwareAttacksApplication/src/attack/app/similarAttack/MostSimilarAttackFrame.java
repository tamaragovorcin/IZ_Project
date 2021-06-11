package attack.app.similarAttack;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MostSimilarAttackFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel mainPanel;
	private TabbedPane tabbedPane;

	public MostSimilarAttackFrame() {
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
	
	
}
