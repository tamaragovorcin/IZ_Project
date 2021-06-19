package attacks.app.rdf;

import java.util.ArrayList;

import attacks.app.enumerations.Likelihood;
import attacks.app.enumerations.Prerequisites;
import attacks.app.enumerations.Severity;
import attacks.app.model.Attack;

public class AttackCreate {


    public AttackCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void action(Attack newAttack, String id, String name, String severity, String likelyhood, String weaknesses, String prerequisites, String mitigations) {
        newAttack.setId(id);
        newAttack.setName(name);
        
        String[] parts = mitigations.split(",");
        ArrayList<String> splitMitigation = new ArrayList();
       // splitMitigation = null;
        for (int i = 0; i < parts.length; i++) {
			splitMitigation.add(parts[i]);
		}
		        
        newAttack.setMitigations(splitMitigation);
        newAttack.setLikelihood(Likelihood.High);
        newAttack.setPrerequisites(Prerequisites.Blur);
        
        String[] parts1 = weaknesses.split(",");
        ArrayList<String> splitWeaknesses = new ArrayList();
      //  splitWeaknesses = null;
        for (int i = 0; i < parts1.length; i++) {
        	splitWeaknesses.add(parts1[i]);
		}
        newAttack.setWeaknesses(splitWeaknesses);


        if (severity.equals(Severity.low.toString())) {
            newAttack.setSeverity(Severity.low);
        } else {
            newAttack.setSeverity(Severity.High);
        }




        InsertAttack insert = new InsertAttack(newAttack);
        insert.insert();

    }

}