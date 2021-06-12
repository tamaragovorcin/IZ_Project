package attacks.app;

import attacks.app.view.mainFrame.MainFrame;

public class Singleton {

	private static Singleton instance = new Singleton();

	private MainFrame mainFrame;
	private boolean modeOfReasoning = false;
	
	private Singleton() {

	}

	public static Singleton getInstance() {
		return instance;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public boolean isModeOfReasoning() {
		return modeOfReasoning;
	}

	public void setModeOfReasoning(boolean modeOfReasoning) {
		this.modeOfReasoning = modeOfReasoning;
	}

	
}