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

	public void action(Attack newPatient, String name, String severity, String id, String likelyhood, String weaknesses, String prerequisites, String mitigations) {
		newPatient.setId(id);
		newPatient.setName(name);
		newPatient.setMitigations(mitigations);
		newPatient.setLikelihood(Likelihood.High);
		newPatient.setPrerequisites(Prerequisites.Blur);
		newPatient.setWeaknesses(weaknesses);
		
		
		if (severity.equals(Severity.low.toString())) {
			newPatient.setSeverity(Severity.low);
		} else {
			newPatient.setSeverity(Severity.High);
		}
		
		
		

		InsertAttack insert = new InsertAttack(newPatient);
		insert.insert();

	}

}
