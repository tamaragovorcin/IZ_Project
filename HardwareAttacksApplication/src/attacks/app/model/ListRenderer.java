package attacks.app.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class ListRenderer extends JPanel implements ListCellRenderer<Object> {

	private static final long serialVersionUID = 1L;

	private JLabel labelName;
	private JProgressBar progressBar;

	public ListRenderer() {

		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(100, 25));
		this.setVisible(true);
		this.labelName = new JLabel();
		this.progressBar = new JProgressBar();
		this.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 255), 1));

		setOpaque(true);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {

		if (value instanceof BayesEstimationModel) {
			BayesEstimationModel temp = (BayesEstimationModel) value;
			this.labelName.setText(temp.getAttackName());
			this.progressBar.setMinimum(0);
			this.progressBar.setMaximum(100);

			this.progressBar.setForeground(new Color(0, 204, 255));

			this.progressBar.setValue((int) (temp.getAttackPercentage() * 100));

			this.progressBar.setStringPainted(true);

			this.progressBar.setBackground(Color.RED);
			float f = 100 - (temp.getAttackPercentage() * 100);
			this.progressBar.setString(temp.getAttackPercentage()* 100 + "% / " + f + "%");

			this.add(labelName, BorderLayout.WEST);
			this.add(progressBar, BorderLayout.EAST);
		}

		setEnabled(list.isEnabled());

		return this;
	}

}
