package attacks.app.controller;

import java.util.ArrayList;

import attacks.app.model.AdditionalRisk;
import attacks.app.model.Prerequisite;


public class AdditionalRiskCreateAction {
	public void action(ArrayList<Prerequisite> prerequisite) {
		AdditionalRisk additionalRisk = new AdditionalRisk();
		additionalRisk.setPrerequisitesToCheck(prerequisite);
	}

}
