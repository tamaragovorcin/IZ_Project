package attacks.app.model;

import java.util.ArrayList;

import attacks.app.enumerations.Likelihood;
import attacks.app.enumerations.Prerequisites;
import attacks.app.enumerations.Severity;


public class Attack {
	private String id;
	private String name;
	private String weaknesse;
	private Prerequisites prerequisites;
	private String  mitigations;
	private Severity severity;
	private Likelihood likelihood;

	public Attack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Prerequisites getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Prerequisites prerequisites) {
		this.prerequisites = prerequisites;
	}

	


	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Likelihood getLikelihood() {
		return likelihood;
	}

	public void setLikelihood(Likelihood likelihood) {
		this.likelihood = likelihood;
	}

	public String getWeaknesse() {
		return weaknesse;
	}

	public void setWeaknesse(String weaknesse) {
		this.weaknesse = weaknesse;
	}

	public String getMitigations() {
		return mitigations;
	}

	public void setMitigations(String mitigations) {
		this.mitigations = mitigations;
	}

	public Attack(String id, String name, String weaknesse, Prerequisites prerequisites, String mitigations,
			Severity severity, Likelihood likelihood) {
		super();
		this.id = id;
		this.name = name;
		this.weaknesse = weaknesse;
		this.prerequisites = prerequisites;
		this.mitigations = mitigations;
		this.severity = severity;
		this.likelihood = likelihood;
	}




	

}