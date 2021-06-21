package attacks.app.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import attacks.app.miscellaneous.CbrController;
import attacks.app.miscellaneous.CbrResult;
import attacks.app.model.Attack;
import attacks.app.model.AttackCaseComponent;
import attacks.app.rdf.GetAttacks;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;

public class ButtonEditorSelect extends DefaultCellEditor {
      protected JButton button;

      private String label;

      private boolean isPushed;

      public ButtonEditorSelect(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
              }
            });
          }

      public Component getTableCellEditorComponent(JTable table, Object value,
          boolean isSelected, int row, int column) {
        if (isSelected) {
          button.setForeground(table.getSelectionForeground());
          button.setBackground(table.getSelectionBackground());
        } else {
          button.setForeground(table.getForeground());
          button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
      }

      public Object getCellEditorValue() {
        if (isPushed) {
          // 
          // 
        try {

            CbrController recommender = new CbrController();
            recommender.configure();
            recommender.preCycle();
            CBRQuery query = new CBRQuery();
            AttackCaseComponent creditDescription = getAttackCaseComponent(label);
            
            
            query.setDescription( creditDescription );
            recommender.cycle(query);
            recommender.postCycle();
            
             Map<String,Double> potentialAttacks2 = CbrResult.potentialAttacks;
             String bestName = potentialAttacks2.entrySet().iterator().next().getKey();
             Double bestValue = potentialAttacks2.entrySet().iterator().next().getValue();

             for(Map.Entry<String,Double> entry  : potentialAttacks2.entrySet()) {
                 System.out.println(entry.getValue() + "    -    " + entry.getKey());
                 if(entry.getValue()>bestValue) {
                     bestValue=entry.getValue();
                     bestName = entry.getKey();
                 }
             }
              JOptionPane.showMessageDialog(button, label + bestName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        isPushed = false;
        return new String(label);
        
      }

      private AttackCaseComponent getAttackCaseComponent(String id) {
          AttackCaseComponent attackCase = new AttackCaseComponent();
          GetAttacks get = new GetAttacks();
          ArrayList<Attack> all= get.getAttacks();
          for (Attack attack : all) {
              if(attack.getId().equals(id)) {
                  attackCase.setId(id);
                  attackCase.setName(attack.getName());
                  attackCase.setPrerequisites(attack.getPrerequisites());
                  attackCase.setLikelihood(attack.getLikelihood());
                  attackCase.setMitigations(attack.getMitigations());
                  attackCase.setSeverity(attack.getSeverity());
                  attackCase.setWeaknesse(attack.getWeaknesse());
              }
          }
          return attackCase;
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
      }

      protected void fireEditingStopped() {
        super.fireEditingStopped();
      }
    }