package attacks.app.miscellaneous;

import java.util.ArrayList;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

import attacks.app.model.AttackName;
import attacks.app.model.Mitigation;


public class MitigationsPrologFinder {

	public static ArrayList<Mitigation> findMitigations(AttackName attack) {
		ArrayList<Mitigation> retVal = new ArrayList<>();
		JIPEngine engine = new JIPEngine();

		engine.consultFile("data/facts/project.pl");

		JIPQuery query = engine
				.openSynchronousQuery("mitigations(" + attack.getAttackName() + ",_,X)");
		JIPTerm solution;

		while ((solution = query.nextSolution()) != null) {
			int num = 0;
			for (JIPVariable var : solution.getVariables()) {
				num+=1;
				if(num%2==0) {
					Mitigation mitigation = new Mitigation();
					mitigation.setMitigationName(var.getValue().toString());
					retVal.add(mitigation);
				}				
			}
		}

		return retVal;

	}

}
