package attacks.app.rdf;

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
		newAttack.setMitigations(mitigations);
		newAttack.setLikelihood(Likelihood.High);
		newAttack.setPrerequisites(Prerequisites.Blur);
		newAttack.setWeaknesses(weaknesses);
		
		
		if (severity.equals(Severity.Low.toString())) {
			newAttack.setSeverity(Severity.Low);
		} else {
			newAttack.setSeverity(Severity.High);
		}
		
		
		

		InsertAttack insert = new InsertAttack(newAttack);
		insert.insert();

	}

}
