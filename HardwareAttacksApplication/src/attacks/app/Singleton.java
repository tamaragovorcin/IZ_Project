package attacks.app;

import attacks.app.rdf.Attacks;
import attacks.app.view.mainFrame.MainFrame;


public class Singleton {

	private static Singleton instance = new Singleton();

	private MainFrame mainFrame;
	private boolean modeOfReasoning = false;
	private Attacks attacks;
	
	private Singleton() {

	}

	public Attacks getAttacks() {
		return attacks;
	}

	public void setAttacks(Attacks attacks) {
		this.attacks = attacks;
	}

	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
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