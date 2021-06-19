package attacks.app;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import attacks.app.rdf.GetAttacks;
import attacks.app.view.mainFrame.MainFrame;

public class Application {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				try {
					UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
			
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);

				} catch (Exception e) {
					System.out.println("nije ucitan LookAndFeel!");
				}

				GetAll getAll = new GetAll();
				getAll.action();

				InitAll initAll = new InitAll();
				initAll.action();

				PrintAll printAll = new PrintAll();
				printAll.action();

				/*GetAttacks printAll1 = new GetAttacks();
				printAll1.action();
				*/
				MainFrame mainFrame = new MainFrame();
				Singleton.getInstance().setMainFrame(mainFrame);

				mainFrame.setVisible(true);
			}
		});
	}

}
