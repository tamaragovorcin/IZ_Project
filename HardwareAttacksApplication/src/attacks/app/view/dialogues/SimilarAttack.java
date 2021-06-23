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

import attacks.app.model.Attack;
import attacks.app.rdf.GetAttacks;
import attacks.app.view.ButtonRendererSelect;
import attacks.app.view.ButtonEditorSelect;

public class SimilarAttack extends JDialog {

    JTable table;
    JButton selectButton;

      public SimilarAttack(  ) {
          
          JFrame frame = new JFrame("All attacks");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JPanel panel = new JPanel();
          panel.setAlignmentX(CENTER_ALIGNMENT);
          panel.setAlignmentY(CENTER_ALIGNMENT);
          this.initButtons();
              
          GetAttacks get = new GetAttacks();
          ArrayList<Attack> all = new ArrayList();
          all = get.getAttacks();
          table = new JTable();
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(new Object[]{"Name","Severity","Likelihood", "Prerequisites", "Weekneses", "Mitigations", "Select"});

          table.setModel(model);

          for (Attack attack : all) {
              System.out.println(attack.getMitigations().toString());
              model.addRow(new Object[] {attack.getName(),attack.getSeverity(),attack.getLikelihood(),attack.getPrerequisites(),attack.getWeaknesse().toString().substring(1,attack.getWeaknesse().toString().length()-1), attack.getMitigations().toString().subSequence(1, attack.getMitigations().toString().length()-1),attack.getId()});
          }

          table.getColumn("Select").setCellRenderer(new ButtonRendererSelect());
          table.getColumn("Select").setCellEditor(
              new ButtonEditorSelect(new JCheckBox()));
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