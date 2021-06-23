package attacks.app.view.dialogues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import attacks.app.miscellaneous.MitigationsPrologFinder;
import attacks.app.model.Attack;
import attacks.app.model.AttackName;
import attacks.app.model.Mitigation;
import attacks.app.rdf.GetAttacks;
import attacks.app.view.ButtonRendererSelect;
import attacks.app.view.ButtonEditorSelect;

public class MitigationsView extends JDialog {

    JTable table;
    JButton selectButton;

      public MitigationsView(AttackName attack) {
          
    	  System.out.println("MITIGATIONS VIEWWW");
          JFrame frame = new JFrame("Mitigations for attack" + attack.getAttackName());
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JPanel panel = new JPanel();
          panel.setAlignmentX(CENTER_ALIGNMENT);
          panel.setAlignmentY(CENTER_ALIGNMENT);
          this.initButtons();
              
          
          table = new JTable();
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(new Object[]{"Most simmilar attack - " + attack.getAttackName()});

          table.setModel(model);
          ArrayList<Mitigation> mitigationsArrayList = MitigationsPrologFinder.findMitigations(attack);
   		
          for (Mitigation m : mitigationsArrayList) {
        	  System.out.println(m.getMitigationName());
              model.addRow(new Object[] {m.getMitigationName()});
          }

          JTableHeader header = table.getTableHeader();
          header.setBackground(Color.BLUE);
          JScrollPane pane = new JScrollPane(table);
          panel.add(pane);
          frame.add(panel);
          frame.setUndecorated(true);
          frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
          frame.setSize(500,500);
          frame.setVisible(true);
          }
      public void initButtons() {
          
          this.selectButton = new JButton();
          this.selectButton.setText("selectButton");
          this.add(selectButton);
      }
      private void initActionListeners() {
          this.selectButton.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent arg0) {
                  
                  DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
              
                  
              }
          });
      
      
      }
}