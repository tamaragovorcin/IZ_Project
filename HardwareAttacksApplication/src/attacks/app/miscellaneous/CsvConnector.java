package attacks.app.miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import attacks.app.model.Attack;
import attacks.app.model.AttackCaseComponent;
import attacks.app.rdf.GetAttacks;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class CsvConnector implements Connector {
    
    @Override
    public Collection<CBRCase> retrieveAllCases() {
        LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
        
        try {
             GetAttacks get = new GetAttacks();

             ArrayList<Attack> all =get.getAttacks();
            
              for (Attack attack : all) {

                    CBRCase cbrCase = new CBRCase();
                    AttackCaseComponent attackCaseComponent = new AttackCaseComponent();
                    
                    attackCaseComponent.setId(attack.getId());
                    attackCaseComponent.setLikelihood(attack.getLikelihood());
                    attackCaseComponent.setMitigations(attack.getMitigations());
                    attackCaseComponent.setName(attack.getName());;
                    attackCaseComponent.setPrerequisites(attack.getPrerequisites());
                    attackCaseComponent.setSeverity(attack.getSeverity());
                    attackCaseComponent.setWeaknesse(attack.getWeaknesse());
                    
                    cbrCase.setDescription(attackCaseComponent);
                    cases.add(cbrCase);
              }

                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cases;
    }

    @Override
    public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
        return null;
    }

    @Override
    public void storeCases(Collection<CBRCase> arg0) {
    }
    
    @Override
    public void close() {
    }

    @Override
    public void deleteCases(Collection<CBRCase> arg0) {
    }

    @Override
    public void initFromXMLfile(URL arg0) throws InitializingException {
    }

}