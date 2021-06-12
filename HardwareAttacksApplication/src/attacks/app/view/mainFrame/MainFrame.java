package attacks.app.view.mainFrame;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import attacks.app.view.mainFrame.bars.MenuBar;
import attacks.app.view.mainFrame.bars.ToolBar;

public class MainFrame extends JFrame {

	private MenuBar menuBar;
	private ToolBar toolBar;

	public MainFrame() {

		this.initFrame();

	}

	public void initFrame() {
		this.initComponents();

		this.setJMenuBar(menuBar);
		this.setTitle("Hardware attacks");
		this.setLayout(new BorderLayout());
		ImageIcon logoIcon = new ImageIcon("resources/logo.png");
		Image logo = logoIcon.getImage();
		logo = logo.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		this.setIconImage(logo);
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(toolBar, BorderLayout.NORTH);

		this.initImage();
	}

	public void initImage() {
		ImageIcon icon = new ImageIcon("resources/logo2.png");
		JLabel temp = new JLabel();
		temp.setIcon(icon);
		temp.setHorizontalAlignment(JLabel.CENTER);
		temp.setVerticalAlignment(JLabel.CENTER);

		this.add(temp);
	}

	public void initComponents() {
		this.menuBar = new MenuBar();

		this.toolBar = new ToolBar();

	}

}