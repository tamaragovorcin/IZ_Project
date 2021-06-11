package attack.app.similarAttack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.ListCellRenderer;

import attacks.app.model.Mitigation;


public class MitigationsListRenderer extends JPanel implements ListCellRenderer<Object> {

	private static final long serialVersionUID = 1L;
	private JLabel labelName;
	private JProgressBar progressBar;

	public MitigationsListRenderer() {

		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.labelName = new JLabel();
		this.progressBar = new JProgressBar();
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

		setOpaque(true);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {

		if (value instanceof Mitigation) {
			Mitigation temp = (Mitigation) value;
			this.labelName.setText(temp.getMitigationName());
			this.progressBar.setMinimum(0);
			this.progressBar.setMaximum(100);


			this.progressBar.setStringPainted(true);

			this.add(labelName, BorderLayout.WEST);
			this.add(progressBar, BorderLayout.EAST);
		}

		setEnabled(list.isEnabled());

		return this;
	}

}
